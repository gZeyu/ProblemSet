import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      int n = Integer.valueOf(scanner.nextLine().trim());
      System.out.println(getNumberOfOneBit(n));
    }
    scanner.close();
  }

  private static int getNumberOfOneBit(int n) {
    int count = 0;
    int tmp = n;
    while (tmp > 0) {
      tmp &= tmp - 1;
      count++;
    }
    return count;
  }

  private static final boolean TEST = false;
  private static final String INPUT = "5";
}
