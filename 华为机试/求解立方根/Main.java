import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      double a = scanner.nextInt();
      double x = 1;
      while (abs(x * x * x - a) > 0.000001) {
        x = x - (x * x * x - a) / (3 * x * x);
      }
      System.out.printf("%.1f\n", round(x));
    }
    scanner.close();
  }

  private static double round(double x) {
    int tmp = (int) (x * 100);
    if (tmp % 10 > 4) {
      return (((double) ((int) (x * 10))) / 10) + 0.1;
    } else {
      return (((double) ((int) (x * 10))) / 10);
    }
  }

  private static double abs(double x) {
    if (x < 0) {
      return -x;
    }
    return x;
  }

  private static final boolean TEST = true;
  private static final String INPUT = "216\n12\n";
}
