import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
     System.out.print("Enter first number: ");
    int a = input.nextInt();
    
     System.out.print("Enter second number: ");
    int b = input.nextInt();
    
     System.out.ptrintln("Sum = " + (a+b));
    
    System.out.println("Difference = " + (a-b));
    
     System.out.println("Product = " + (a*b));

        if (b!=0) {
    System.out.println("Division = " + (a/b));
        } else {
      System.out.println("Division not possible");
          }
    }
  }
         
    
