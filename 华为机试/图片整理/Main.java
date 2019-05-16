import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] cards = scanner.nextLine().toCharArray();
      quickSort(cards, 0, cards.length - 1);
      System.out.println(String.valueOf(cards));
    }

    scanner.close();
  }

  private static void swap(char[] array, int left, int right) {
    char tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }

  private static int partition(char[] array, int left, int right) {
    int i = left;
    for (int j = left; j < right; j++) {
      if (array[j] <= array[right]) {
        swap(array, j, i++);
      }
    }
    swap(array, right, i);
    return i;
  }

  private static void quickSort(char[] array, int left, int right) {
    if (left < right) {
      int pivot = partition(array, left, right);
      quickSort(array, left, pivot - 1);
      quickSort(array, pivot + 1, right);
    }
  }

  private static final boolean TEST = true;
  private static final String INPUT = "Ihave1nose2hands10fingers\n";
}
