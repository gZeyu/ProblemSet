import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner input = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    String s = "";
    while (scanner.hasNextLine()) {
      s = scanner.nextLine();
      s = s.trim();
      String[] words = s.split(" ");
      System.out.println(words[words.length - 1].length());
    }
    scanner.close();
  }

  private static final String INPUT = "hello world\n" + "XSUWHQ\n";
}
