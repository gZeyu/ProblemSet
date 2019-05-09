import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String input = scanner.nextLine();
      String[] words = input.trim().split(" ");
      StringBuilder builder = new StringBuilder();
      for (int i = words.length - 1; i > -1; i--) {
        builder.append(words[i]).append(' ');
      }
      System.out.println(builder.toString().trim());
    }
    scanner.close();
  }

  private static final boolean TEST = false;
  private static final String INPUT = "I am a boy\n\n";
}
