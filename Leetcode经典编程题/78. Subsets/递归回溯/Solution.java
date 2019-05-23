import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    subsets.add(new ArrayList<>(set));
    subsetsCore(nums, 0, set, subsets);
    return subsets;
  }

  private void subsetsCore(int[] nums, int i, List<Integer> set, List<List<Integer>> subsets) {
    if (i >= nums.length) {
      return;
    }
    for (int j = i; j < nums.length; j++) {
      set.add(nums[j]);
      subsets.add(new ArrayList<>(set));
      subsetsCore(nums, j + 1, set, subsets);
      set.remove(set.size() - 1);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subsets(new int[] { 1, 2, 3 }));
  }
}