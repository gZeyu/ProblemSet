import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    Arrays.sort(nums);
    int begin = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] != nums[i - 1]) {
        begin = 0;
      }
      int n = subsets.size();
      for (int j = begin; j < n; j++) {
        List<Integer> set = new ArrayList<>(subsets.get(j));
        set.add(nums[i]);
        subsets.add(set);
      }
      begin = n;
    }
    return subsets;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subsetsWithDup(new int[] { 1, 2, 2 }));
  }
}
