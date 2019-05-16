import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] characters = scanner.nextLine().toCharArray();
      int englishCharCount = 0;
      int blankCharCount = 0;
      int numberCharCount = 0;
      int otherCharCount = 0;
      for (char character : characters) {
        if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
          englishCharCount++;
        } else if (character == ' ') {
          blankCharCount++;
        } else if (character >= '0' && character <= '9') {
          numberCharCount++;
        } else {
          otherCharCount++;
        }
      }
      System.out.println(englishCharCount);
      System.out.println(blankCharCount);
      System.out.println(numberCharCount);
      System.out.println(otherCharCount);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\\\/;p0-=\\\\][\n";}