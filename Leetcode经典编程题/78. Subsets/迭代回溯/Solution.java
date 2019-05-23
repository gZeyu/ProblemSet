import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    for (int num : nums) {
      int n = subsets.size();
      for (int i = 0; i < n; i++) {
        List<Integer> set = new ArrayList<>(subsets.get(i));
        set.add(num);
        subsets.add(set);
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subsets(new int[] { 1, 2, 3 }));
  }
}
