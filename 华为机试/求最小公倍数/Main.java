import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int min = a < b ? a : b;
      int max = a > b ? a : b;
      while (max % min != 0) {
        int remainder = max % min;
        max = min;
        min = remainder;
      }
      System.out.println(a * b / min);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "5 \n" + "7\n" + "24 \n" + "36\n";
}
