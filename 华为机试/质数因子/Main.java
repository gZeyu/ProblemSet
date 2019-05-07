import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    long ulDataInput = scanner.nextLong();
    System.out.print(getResult(ulDataInput));
    scanner.close();
  }

  public static String getResult(long ulDataInput) {
    StringBuilder builder = new StringBuilder();
    long tmp = ulDataInput;
    for (long i = 2; i <= tmp; i++) {
      while (tmp % i == 0) {
        tmp /= i;
        builder.append(i).append(' ');
      }
    }
    return builder.toString();
  }

  private static final String INPUT = "180";
}
