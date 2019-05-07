import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Scanner scanner = new Scanner(INPUT);
    double number = scanner.nextDouble();
    System.out.println((int) (number + 0.5));
    scanner.close();
  }

  private static final String INPUT = "5.5";
}
