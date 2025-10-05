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
    System.out.println("The lion starts the attack!);
  }
}
//Main class
public class Main
  public static void main(String[] args) {
    Lion lion = new Lion();
    Gazelle gazelle = new Gazelle();

       Gazelle.flee();
       Lion.hunt();
  }
}
    
