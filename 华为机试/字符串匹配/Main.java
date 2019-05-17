import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String shortString = scanner.nextLine();
      String longString = scanner.nextLine();
      System.out.println(boolIsAllCharExist(shortString, longString));
    }
    scanner.close();
  }

  private static boolean boolIsAllCharExist(String shortString, String longString) {
    Map<Character, Boolean> map = new HashMap<>();
    for (char ch : shortString.toCharArray()) {
      map.put(ch, true);
    }
    for (char ch : longString.toCharArray()) {
      map.remove(ch);
    }
    return map.isEmpty();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "bc\n" + "abc\n";
}
