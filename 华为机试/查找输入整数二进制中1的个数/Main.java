import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      System.out.println(findNumberOf1(n));
    }
    scanner.close();
  }

  private static int findNumberOf1(int num) {
    int count = num;
    count = ((count >> 1) & 0x55555555) + (count & 0x55555555);
    count = ((count >> 2) & 0x33333333) + (count & 0x33333333);
    count = ((count >> 4) & 0x0f0f0f0f) + (count & 0x0f0f0f0f);
    count = ((count >> 8) & 0x00ff00ff) + (count & 0x00ff00ff);
    count = ((count >> 16) & 0x0000ffff) + (count & 0x0000ffff);
    return count;
  }

  private static final boolean TEST = true;
  private static final String INPUT = "5\n";
}
