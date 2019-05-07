import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    char[] digits = scanner.nextLine().toCharArray();
    StringBuilder builder = new StringBuilder();
    for (int i = digits.length - 1; i > -1; i--) {
      builder.append(digits[i]);
    }
    System.out.println(builder.toString());
    scanner.close();
  }

  private static final String INPUT = "1516000";
}
