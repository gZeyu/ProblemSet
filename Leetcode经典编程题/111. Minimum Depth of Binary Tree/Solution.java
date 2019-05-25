class Solution {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = minDepth(root.left);
    int r = minDepth(root.right);
    if (l == 0 || r == 0) {
      return 1 + l + r;
    } else {
      return 1 + (l < r ? l : r);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode n0 = new TreeNode(3);
    TreeNode n1 = new TreeNode(9);
    TreeNode n2 = new TreeNode(20);
    TreeNode n3 = new TreeNode(15);
    TreeNode n4 = new TreeNode(7);
    n0.left = n1;
    n0.right = n2;
    n2.left = n3;
    n2.right = n4;
    System.out.println(s.minDepth(n0));
  }
}
