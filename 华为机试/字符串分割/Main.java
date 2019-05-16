import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      for (int i = 0; i < n; i++) {
        String str = scanner.next();
        if (str.length() == 0) {
          continue;
        }
        int numberOfZero = (8 - (str.length() % 8)) % 8;
        int index = 0;
        while (index + 8 <= str.length()) {
          System.out.println(str.substring(index, index + 8));
          index += 8;
        }
        System.out.print(str.substring(index));
        for (int j = 0; j < numberOfZero; j++) {
          System.out.print("0");
          if (j == numberOfZero - 1) {
            System.out.println();
          }
        }
      }
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "2\n" + "abc\n" + "123456789\n";
}
