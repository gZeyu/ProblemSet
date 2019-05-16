import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      double height = scanner.nextInt();
      System.out.println(height * 2.875);
      System.out.println(height * 0.03125);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "1\n38801\n";
}
