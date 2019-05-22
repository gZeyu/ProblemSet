import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST == 1 ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      System.out.println(calcAutomorphicNumbers(n));
    }
    scanner.close();
  }

  private static int calcAutomorphicNumbers(int n) {
    int count = 0;
    for (int i = 0; i <= n; i++) {
      int a = 1;
      int b = i;
      while (b > 0) {
        b /= 10;
        a *= 10;
      }
      if (i == (i * i) % a) {
        count++;
      }
    }
    return count;
  }

  private static byte TEST = 1;
  private static final String INPUT = "2000\n";
}
