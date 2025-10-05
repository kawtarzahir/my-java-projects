//Abstract class
public abstract class Vehicle {
  abstract void move();
  abstract void brake();
}
//Concrete class extending vehicle
public class Car extends Vehicle {
  @Override
  void move() {
    System.out.println("The car moves forward!");
    }
  @Override
  void brake() {
    System.out.println("The car stops!");
  }
}
//Main class
public class Main {
  public static void main(String[] args) {
    Car car = new Car();
     car.brake();
     car.move();
  }
}
