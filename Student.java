public class Student {
  String name;
  int grade;
  
Student(String name, int grade) {
  this.name = name;
  this.grade = grade;
}
void printInfo() {
  System.out.println(name + " has grade " + grade);
  }
}

//To run this code, create a Main class with a Main method like this
public class Main {
  public static void main(String[] args) {
    Student s = new Student("Kawtar", 25);
    s.printInfo();
  }
}
