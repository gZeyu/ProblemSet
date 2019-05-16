import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      int firstOfRow = 1;
      for (int i = 0; i < n; i++) {
        int element = firstOfRow;
        for (int j = 0; j < n - i; j++) {
          System.out.print(element + " ");
          element = element + +i + j + 2;
        }
        System.out.print("\n");
        firstOfRow = firstOfRow + i + 1;
      }
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "4\n5\n";
}
