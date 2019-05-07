import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //    Scanner input = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    char[] array = scanner.nextLine().toLowerCase().toCharArray();
    char ch = scanner.nextLine().toLowerCase().charAt(0);
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == ch) {
        count++;
      }
    }
    System.out.println(count);
    scanner.close();
  }

  private static String INPUT = "ABCDEF\nA\n";
}


