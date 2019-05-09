import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.valueOf(scanner.nextLine().trim());
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine().trim();
            }
            quickSort(words, 0, words.length - 1);
            for (String word : words) {
                System.out.println(word);
            }
        }
        scanner.close();
    }

    private static void quickSort(String[] array, int left, int right) {
        if (left < right) {
            int indexOfPivot = partition(array, left, right);
            quickSort(array, left, indexOfPivot - 1);
            quickSort(array, indexOfPivot + 1, right);
        }
    }

    private static int partition(String[] array, int left, int right) {
        int i = left;
        for (int j = left; j < right; j++) {
            if (compare(array[j], array[right]) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);
        return i;
    }

    private static void swap(String[] array, int left, int right) {
        String tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    private static int compare(String str1, String str2) {
        int minLength = str1.length() < str2.length() ? str1.length() : str2.length();
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) - str2.charAt(i);
            }
        }
        return str1.length() - str2.length();
    }

    private static final boolean TEST = true;
    private static final String INPUT = "9\n" + "cap\n" + "to\n" + "cat\n" + "card\n" + "two\n" + "too\n" + "up\n"
            + "boat\n" + "boot";
}
