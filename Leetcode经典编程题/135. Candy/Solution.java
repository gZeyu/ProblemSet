class Solution {

  public int candy(int[] ratings) {
    int[] left2Right = new int[ratings.length];
    int[] right2Left = new int[ratings.length];
    left2Right[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      left2Right[i] = ratings[i] > ratings[i - 1] ? left2Right[i - 1] + 1 : 1;
    }
    right2Left[ratings.length - 1] = 1;
    for (int i = ratings.length - 2; i > -1; i--) {
      right2Left[i] = ratings[i] > ratings[i + 1] ? right2Left[i + 1] + 1 : 1;
    }
    int sum = 0;
    for (int i = 0; i < ratings.length; i++) {
      sum += left2Right[i] > right2Left[i] ? left2Right[i] : right2Left[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.candy(new int[] { 1, 0, 2 }));
    System.out.println(s.candy(new int[] { 1, 2, 2 }));
  }
}
