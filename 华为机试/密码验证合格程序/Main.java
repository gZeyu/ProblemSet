import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    Map<String, Integer> count = new LinkedHashMap<>();
    while (scanner.hasNextLine()) {
      String password = scanner.nextLine();
      if (password.length() <= 8) {
        System.out.println("NG");
        continue;
      }
      byte[] type = new byte[4];
      for (char character : password.toCharArray()) {
        if (character >= 'a' && character <= 'z') {
          type[0] = 1;
        } else if (character >= 'A' && character <= 'Z') {
          type[1] = 1;
        } else if (character >= '0' && character <= '9') {
          type[2] = 1;
        } else {
          type[3] = 1;
        }
      }
      if (type[0] + type[1] + type[2] + type[3] < 3 || isRepeat(password)) {
        System.out.println("NG");
        continue;
      }

      System.out.println("OK");
    }
    scanner.close();
  }

  private static boolean isRepeat(String str) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < str.length() - 2; i++) {
      if (set.contains(str.substring(i, i + 3))) {
        return true;
      } else {
        set.add(str.substring(i, i + 3));
      }
    }
    return false;
  }

  private static final boolean TEST = true;
  private static final String INPUT =
      "021Abc9000\n" + "021Abc9Abc1\n" + "021ABC9000\n" + "021$bc9000\n";
}
