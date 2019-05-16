import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      int[] height = new int[n];
      for (int i = 0; i < n; i++) {
        height[i] = scanner.nextInt();
      }
      int[] dp1 = new int[n];
      int[] dp2 = new int[n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (height[i] > height[j]) {
            dp1[i] = dp1[j] + 1 > dp1[i] ? dp1[j] + 1 : dp1[i];
          }
        }
      }
      for (int i = n - 1; i > -1; i--) {
        for (int j = n - 1; j > i; j--) {
          if (height[i] > height[j]) {
            dp2[i] = dp2[j] + 1 > dp2[i] ? dp2[j] + 1 : dp2[i];
          }
        }
      }
      int max = 0;
      for (int i = 0; i < n; i++) {
        max = dp1[i] + dp2[i] > max ? dp1[i] + dp2[i] : max;
      }
      System.out.println(n - max - 1);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "8\n" + "186 186 150 200 160 130 197 200\n";
}
