import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      System.out.println((3 * n + 1) * n / 2);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "2\n";}