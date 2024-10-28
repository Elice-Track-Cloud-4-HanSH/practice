package beanvalidation;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectPostDto {

  // 지시사항을 참고하여 코드를 작성해 보세요.
  @NotBlank(message = "과목명은 필수 입력 항목입니다.")
  @Size(min = 3, max= 50, message = "과목명은 3자 이상 50자 이하로 입력해야 합니다.")
  @Pattern(regexp = "[a-zA-Z가-힣 ]+", message = "과목명은 문자, 숫자, 한글, 공백만을 포함할 수 있습니다.")
  private String name;

  @NotNull(message = "가격은 필수 입력 항목입니다.")
  @Max(value = 100000, message = "가격은 최대 100,00원까지만 가능합니다.")
  private Integer price;

  public Subject toEntity() {
    return new Subject(name, price);
  }
}