//Interface for prey
public interface Prey {
  void flee();
}
//Interface for predator
public interface Predator {
  void hunt();
}
//Class implementing Prey
public class Gazelle implements Prey {
  @Override
  public void flee() {
    System.out.println("The gazelle runs away!");
  }
}
//Class implementing predator
public class Lion implements Predator {
  @Override
  public void hunt() {
    System.out.println("The lion starts the attack!");
  }
}
// Class implementing both Prey and Predator
public class Fish implements Prey, Predator {
    @Override
    public void flee() {
    System.out.println("The fish swims away quickly!");
    }

    @Override
    public void hunt() {
    System.out.println("The fish hunts smaller fish.");
  }
}
//Main class
public class Main {
  public static void main(String[] args) {
    Lion lion = new Lion();
    Gazelle gazelle = new Gazelle();
    Fish fish = new Fish();

       gazelle.flee();
       lion.hunt();
       fish.flee();
       fish.hunt();
  }
}
    
