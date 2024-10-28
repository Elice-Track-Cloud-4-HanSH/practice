package beanvalidation;

import io.elice.elcademy.subject.entity.Subject;
import io.elice.elcademy.subject.entity.SubjectPatchDto;
import io.elice.elcademy.subject.entity.SubjectPostDto;
import io.elice.elcademy.subject.mapper.SubjectMapper;
import io.elice.elcademy.subject.service.SubjectService;
import jakarta.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// 지시사항을 참고하여 코드를 작성해 보세요.
@Validated
@RestController
@RequestMapping("/subjects")
public class SubjectController {

  private final SubjectService subjectService;
  private final SubjectMapper mapper;
  private static Logger log = LoggerFactory.getLogger(SubjectController.class);

  public void setLogger(Logger logger) {
    this.log = logger;
  }

  public SubjectController(SubjectService subjectService, SubjectMapper mapper) {
    this.subjectService = subjectService;
    this.mapper = mapper;
  }

  // 지시사항을 참고하여 코드를 작성해 보세요.
  @GetMapping("/{subjectId}")
  public ResponseEntity getSubject(@Positive() @PathVariable("subjectId") long subjectId) {
    Subject findSubject = subjectService.findSubject(subjectId);

    if (findSubject == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(findSubject, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getSubjects() {
    List<Subject> subjects = subjectService.findSubjects();
    if (subjects.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(subjects, HttpStatus.OK);
  }

  // 지시사항을 참고하여 코드를 작성해 보세요.
  @Validated
  @PostMapping
  public ResponseEntity postSubject(@RequestBody SubjectPostDto subjectPostDto) {
    Subject subject = subjectPostDto.toEntity();

    Subject newSubject = subjectService.createSubject(subject);

    if (newSubject == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
  }

  // 지시사항을 참고하여 코드를 작성해 보세요.
  @PatchMapping("/{subjectId}")
  public ResponseEntity patchSubject(@Positive() @PathVariable long subjectId, @RequestBody SubjectPatchDto subjectPatchDto) {
    subjectPatchDto.setSubjectId(subjectId);
    Subject subject = subjectService.updateSubject(mapper.subjectPatchDtoToSubject(subjectPatchDto));
    return new ResponseEntity<>(subject, HttpStatus.OK);
  }

  // 지시사항을 참고하여 코드를 작성해 보세요.
  @DeleteMapping("/{subjectId}")
  public ResponseEntity deleteSubject(@Positive() @PathVariable("subjectId")long subjectId) {
    subjectService.deleteSubject(subjectId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}