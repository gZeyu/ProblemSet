import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    while (scanner.hasNextLine()) {
      String input = scanner.nextLine();
      char[] characters = input.toCharArray();
      reverse(characters, 0, characters.length - 1);
      System.out.println(String.valueOf(characters));
    }
    scanner.close();
  }

  private static void reverse(char[] array, int left, int right) {
    int l = left;
    int r = right;
    while (l < r) {
      swap(array, l++, r--);
    }
  }

  private static void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  private static final String INPUT = "abcd\n";
}
