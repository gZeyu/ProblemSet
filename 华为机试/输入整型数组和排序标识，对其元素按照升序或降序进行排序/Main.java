import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST == 1 ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = scanner.nextInt();
      }
      int iSortFlag = scanner.nextInt();
      quickSort(array, 0, array.length - 1, iSortFlag);
      for (int i : array) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    scanner.close();
  }

  private static void quickSort(int[] array, int left, int right, int iSortFlag) {
    if (left < right) {
      int pivot = partition(array, left, right, iSortFlag);
      quickSort(array, left, pivot - 1, iSortFlag);
      quickSort(array, pivot + 1, right, iSortFlag);
    }
  }

  private static int partition(int[] array, int left, int right, int iSortFlag) {
    int i = left;
    for (int j = left; j < right; j++) {
      if (compare(array[j], array[right], iSortFlag) < 0) {
        swap(array, i++, j);
      }
    }
    swap(array, i, right);
    return i;
  }

  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  private static int compare(int i, int j, int iFlag) {
    return iFlag == 0 ? Integer.compare(i, j) : Integer.compare(j, i);
  }

  private static byte TEST = 1;
  private static final String INPUT = "8 1 2 4 9 3 55 64 25 1\n";
}
