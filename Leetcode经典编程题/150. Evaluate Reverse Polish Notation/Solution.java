import java.util.Stack;

class Solution {

  int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    for (String token : tokens) {
      switch (token) {
      case "+": {
        int r = Integer.parseInt(stack.pop());
        int l = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(l + r));
        break;
      }
      case "-": {
        int r = Integer.parseInt(stack.pop());
        int l = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(l - r));
        break;
      }
      case "*": {
        int r = Integer.parseInt(stack.pop());
        int l = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(l * r));
        break;
      }
      case "/": {
        int r = Integer.parseInt(stack.pop());
        int l = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(l / r));
        break;
      }
      default: {
        stack.push(token);
        break;
      }
      }
    }
    return Integer.parseInt(stack.peek());
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
  }
}
