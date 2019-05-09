import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      int n = Integer.valueOf(scanner.nextLine().trim());
      ArrayList<String> words = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        words.add(scanner.nextLine().trim());
      }
      words.sort((str1, str2) -> {
        int minLength = str1.length() < str2.length() ? str1.length() : str2.length();
        for (int i = 0; i < minLength; i++) {
          if (str1.charAt(i) != str2.charAt(i)) {
            return str1.charAt(i) - str2.charAt(i);
          }
        }
        return str1.length() - str2.length();
      });
      for (String word : words) {
        System.out.println(word);
      }
    }

    scanner.close();
  }

  private static final boolean TEST = false;
  private static final String INPUT = "9\n" + "cap\n" + "to\n" + "cat\n" + "card\n" + "two\n" + "too\n" + "up\n"
      + "boat\n" + "boot";}