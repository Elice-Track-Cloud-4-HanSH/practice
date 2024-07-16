package test.chapter.test3;

// 여기에 Student 클래스와 HighSchoolStudent 클래스를 만들어주세요.
class Student {
  private String name;
  private int age;

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void printDetails() {
    System.out.println("이름 : " + this.name);
    System.out.println("나이 : " + this.age);
  }
}

class HighSchoolStudent extends Student {
  private int grade;

  public int getGrade() { return this.grade; }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public void printDetails() {
    super.printDetails();
    System.out.println("학년 : " + this.grade);
  }
}

public class Main {
  public static void main(String args[]) {
    //채점을 위한 코드이니 변경, 수정 하지말아주세요.
    Student student = new Student();
    student.setName("Alice");
    student.setAge(12);

    HighSchoolStudent highSchoolStudent = new HighSchoolStudent();
    highSchoolStudent.setName("Bob");
    highSchoolStudent.setAge(17);
    highSchoolStudent.setGrade(11);

    student.printDetails();
    highSchoolStudent.printDetails();
  }
}
