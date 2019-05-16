import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNextLine()) {
      char[] input = scanner.nextLine().toCharArray();
      String str = "^#";
      for (char ch : input) {
        str += ch + "#";
      }
      str += "$";
      int[] len = new int[str.length()];
      int center = 0;
      int right = 0;
      int lenOfLongest = 0;
      for (int i = 1; i < str.length() - 1; i++) {
        len[i] = i <= right ? Math.min(len[2 * center - i], right - i) : 0;
        while (str.charAt(i + 1 + len[i]) == str.charAt(i - 1 - len[i])) {
          len[i]++;
        }
        if (i + len[i] > right) {
          center = i;
          right = i + len[i];
        }
        if (lenOfLongest < len[i]) {
          lenOfLongest = len[i];
        }
      }
      System.out.println(lenOfLongest);
    }

    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "51233214\n5123214\n";
}
