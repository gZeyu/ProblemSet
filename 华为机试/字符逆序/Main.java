import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      StringBuilder builder = new StringBuilder();
      builder.append(str).reverse();
      System.out.println(builder.toString());
    }

    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "I am a student\n";
}