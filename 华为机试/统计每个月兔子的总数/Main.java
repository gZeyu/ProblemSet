import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      int f1 = 1;
      int f2 = 1;
      for (int i = 3; i <= n; i++) {
        int tmp = f2;
        f2 = f1 + f2;
        f1 = tmp;
      }
      System.out.println(f2);
    }

    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "9\n";
}
