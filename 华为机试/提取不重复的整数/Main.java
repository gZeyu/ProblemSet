import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    char[] digits = scanner.nextLine().trim().toCharArray();
    boolean[] map = new boolean[10];
    StringBuilder builder = new StringBuilder();
    for (int i = digits.length - 1; i > -1; i--) {
      if (!map[digits[i] - '0']) {
        builder.append(digits[i]);
        map[digits[i] - '0'] = true;
      }
    }
    System.out.println(builder.toString());
    scanner.close();
  }

  private static final String INPUT = "9876673";
}
