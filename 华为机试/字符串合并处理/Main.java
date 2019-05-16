import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    char[] map1 = "084C2A6E195D3B7F".toCharArray();
    while (scanner.hasNextLine()) {
      char[] str = scanner.nextLine().replace(" ", "").toCharArray();
      char[] str1 = new char[str.length - str.length / 2];
      char[] str2 = new char[str.length / 2];
      for (int i = 0; i < str1.length; i++) {
        str1[i] = str[i * 2];
      }
      for (int i = 0; i < str2.length; i++) {
        str2[i] = str[i * 2 + 1];
      }
      Arrays.sort(str1);
      Arrays.sort(str2);
      for (int i = 0; i < str1.length; i++) {
        str[i * 2] = str1[i];
      }
      for (int i = 0; i < str2.length; i++) {
        str[i * 2 + 1] = str2[i];
      }
      for (int i = 0; i < str2.length; i++) {
        str[i * 2 + 1] = str2[i];
      }
      for (int i = 0; i < str.length; i++) {
        if (str[i] >= '0' && str[i] <= '9') {
          str[i] = map1[str[i] - '0'];
        } else if (str[i] >= 'A' && str[i] <= 'F') {
          str[i] = map1[str[i] - 'A' + 10];
        } else if (str[i] >= 'a' && str[i] <= 'f') {
          str[i] = map1[str[i] - 'a' + 10];
        }
      }
      System.out.println(str);
    }

    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "DKSq8qykpgKIZxiRKmQ9QkZt909PffE6Gyfc57dBx7p20D42bWJRzKqGGCzzQ4p7Z32Dsx2Cf8G2841lPuAZNb K0fHodOVFlbl220ov260TPOrmZ328d1E89OatcL88EXr622RdklXtXazO7wMoc6DEKU45eQ5VBUy2YFjgJX\n";
}
