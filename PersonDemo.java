//Base class
public class Person {
  String firstName;
  String lastName;

public Person(String firstName, String lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
}
  void greet() {
    System.out.println("Hello!");
  }
// Getter methods
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
//Derived class: Student
public class Student extends Person {
  public Student(String firstName, String lastName) {
    super(firstName, lastName);
  }
}
//Derived class: Teacher
public class Teacher extends Person {
  public Teacher(String firstName, String lastName) {
    super(firstName, lastName);
  }
}
//Main class
public class Main {
  public static void main(String[] args) {
    Student student = new Student("Kawtar","Zahir");
    Teacher teacher = new Teacher("Alessia","Rossi");

        student.greet();
        teacher.greet();

  System.out.println(student.getFirstName());
    System.out.println(teacher.getLastName());
  }
}
