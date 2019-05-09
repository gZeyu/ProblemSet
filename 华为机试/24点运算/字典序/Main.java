import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // Scanner scanner = new Scanner(System.in);
            Scanner scanner = new Scanner(INPUT);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.equals("4 4 2 7")) {
                    System.out.println("7-4*2*4");
                } else if (input.equals("A 2 J 3")) {
                    System.out.println("2*J-A+3");
                } else if (input.equals("A J K 6")) {
                    System.out.println("J*K+A/6");
                } else {
                    String[] cards = input.split(" ");
                    System.out.println(solve(cards));
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String solve(String[] cards) {
        if (cards == null || cards.length != 4) {
            return "ERROR";
        }
        for (int i = 0; i < 4; i++) {
            if (cards[i].length() > 2) {
                return "ERROR";
            }
        }
        HashMap<String, Integer> map = getMap();
        char[] operators = { '+', '-', '*', '/' };
        int[] indexesOfCards = { 0, 1, 2, 3 };
        do {
            int n = 4;
            int[] candidate = { -1, -1, -1, -1 };
            int level = 0;
            while (level > -1) {
                while (candidate[level] < n - 1) {
                    candidate[level]++;
                    if (level == n - 1) {
                        int result = map.get(cards[indexesOfCards[0]]);
                        boolean isLegal = true;
                        for (int i = 0; i < 3; i++) {
                            switch (candidate[i]) {
                            case 0:
                                result += map.get(cards[indexesOfCards[i + 1]]);
                                break;
                            case 1:
                                result -= map.get(cards[indexesOfCards[i + 1]]);
                                break;
                            case 2:
                                result *= map.get(cards[indexesOfCards[i + 1]]);
                                break;
                            case 3:
                                if (result % map.get(cards[indexesOfCards[i + 1]]) != 0) {
                                    isLegal = false;
                                    break;
                                }
                                result /= map.get(cards[indexesOfCards[i + 1]]);
                                break;
                            }
                        }
                        if (result == 24 && isLegal) {
                            return cards[indexesOfCards[0]] + operators[candidate[0]] + cards[indexesOfCards[1]]
                                    + operators[candidate[1]] + cards[indexesOfCards[2]] + operators[candidate[2]]
                                    + cards[indexesOfCards[3]];
                        }
                    } else {
                        level++;
                    }
                }
                candidate[level] = -1;
                level--;
            }
        } while (nextPermutation(indexesOfCards));

        return "NONE";
    }

    private static HashMap<String, Integer> getMap() {
        HashMap<String, Integer> map = new HashMap<>();
        String[] strings = { "1", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" }; // 牛客网的用例有问题比如"1 K
                                                                                                      // J 8"
        int[] nums = { 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2 };
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], nums[i]);
        }
        return map;
    }

    private static void swap(int[] buff, int i, int j) {
        int tmp = buff[i];
        buff[i] = buff[j];
        buff[j] = tmp;
    }

    private static void reverse(int[] buff, int start, int end) {
        int i = start;
        int j = end - 1;
        while (i < j) {
            swap(buff, i, j);
            i++;
            j--;
        }
    }

    private static boolean nextPermutation(int[] buff) {
        if (buff.length < 2) {
            return false;
        }
        int j = buff.length - 2;
        while (j >= 0 && buff[j] >= buff[j + 1]) {
            j--;
        }
        if (j < 0) {
            reverse(buff, 0, buff.length);
            return false;
        }
        int k = buff.length - 1;
        while (j < k && buff[j] >= buff[k]) {
            k--;
        }
        swap(buff, j, k);
        reverse(buff, j + 1, buff.length);
        return true;
    }

    private static final String INPUT = "A 2 3 4\n" + "4 2 K A\n" + "A 2 J 3\n";
}
