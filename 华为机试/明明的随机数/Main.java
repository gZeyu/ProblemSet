import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    while (scanner.hasNext()) {
      int[] map = new int[1001];
      int n = scanner.nextInt();
      for (int i = 0; i < n; i++) {
        int number = scanner.nextInt();
        map[number]++;
      }
      for (int i = 1; i < 1001; i++) {
        if (map[i] != 0) {
          System.out.println(i);
        }
      }
    }
    scanner.close();
  }

  private static String INPUT = "11\n" + "10\n" + "20\n" + "40\n" + "32\n" + "67\n" + "40\n" + "20\n" + "89\n" + "300\n"
      + "400\n" + "15";
}
