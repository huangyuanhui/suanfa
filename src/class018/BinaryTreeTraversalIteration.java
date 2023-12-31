package class018;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树三序遍历的非递归实现
 */
// 不用递归，用迭代的方式实现二叉树的三序遍历
public class BinaryTreeTraversalIteration {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    private static List<Integer> xianX(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            // 头节点先压入栈
            stack.push(head);
            while (!stack.empty()) {
                // 弹出栈顶节点
                head = stack.pop();
                System.out.print(head.val + " ");
                ans.add(head.val);
                // 先压入右子节点
                if (head.right != null) {
                    stack.push(head.right);
                }
                // 再压入左子节点
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        return ans;
    }

    /**
     * 使用一个栈来实现二叉树的先序遍历：利用栈先进后出 后进先出的特性
     * <p>
     * 思路：
     * 从栈中弹出节点后，先压入弹出节点的右子节点、再压入左子节点；
     *
     * @param head
     */
    private static void preventOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            // 头节点先押入栈
            stack.push(head);
            while (!stack.empty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }


    /**
     * 中序遍历
     */
    private static List<Integer> zhongX(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    ans.add(head.val);
                    head = head.right;
                }
            }
        }
        return ans;
    }

    /**
     * 用栈来实现二叉树的中序遍历：都可以三个节点的完全二叉树来理解
     * 思路：
     * 1：树的左边界子节点一直入栈，直到为空；
     * 2：弹出栈顶节点，达到弹出节点的右子节点，重复1步骤
     * 3：直到树为空或者栈为空
     *
     * @param head
     */
    private static void middleOder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (head != null || !stack.empty()) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    // 先序打印所有节点，非递归版
    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    // 中序打印所有节点，非递归版
    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    // 后序打印所有节点，非递归版
    // 这是用两个栈的方法
    public static void posOrderTwoStacks(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val + " ");
            }
            System.out.println();
        }
    }

    // 后序打印所有节点，非递归版
    // 这是用一个栈的方法
    public static void posOrderOneStack(TreeNode h) {
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            // 如果始终没有打印过节点，h就一直是头节点
            // 一旦打印过节点，h就变成打印节点
            // 之后h的含义 : 上一次打印的节点
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right) {
                    // 有左树且左树没处理过
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    // 有右树且右树没处理过
                    stack.push(cur.right);
                } else {
                    // 左树、右树 没有 或者 都处理过了
                    System.out.print(cur.val + " ");
                    h = stack.pop();
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        preOrder(head);
        System.out.println("先序遍历非递归版");
        inOrder(head);
        System.out.println("中序遍历非递归版");
        posOrderTwoStacks(head);
        System.out.println("后序遍历非递归版 - 2个栈实现");
        posOrderOneStack(head);
        System.out.println("后序遍历非递归版 - 1个栈实现");
    }

    // 用一个栈完成先序遍历
    // 测试链接 : https://leetcode.cn/problems/binary-tree-preorder-traversal/
    public static List<Integer> preorderTraversal(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                ans.add(head.val);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        return ans;
    }

    // 用一个栈完成中序遍历
    // 测试链接 : https://leetcode.cn/problems/binary-tree-inorder-traversal/
    public static List<Integer> inorderTraversal(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    ans.add(head.val);
                    head = head.right;
                }
            }
        }
        return ans;
    }

    // 用两个栈完成后序遍历
    // 提交时函数名改为postorderTraversal
    // 测试链接 : https://leetcode.cn/problems/binary-tree-postorder-traversal/
    public static List<Integer> postorderTraversalTwoStacks(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                ans.add(collect.pop().val);
            }
        }
        return ans;
    }

    /**
     * 栈实现二叉树的后序遍历：可以用三节点的完全二叉树来想象
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();

            stack.push(root);
            while (!stack.empty()) {
                root = stack.pop();
                collect.push(root);
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
            }
            while (!collect.empty()) {
                ans.add(collect.pop().val);
            }
        }
        return ans;
    }

    // 用一个栈完成后序遍历
    // 提交时函数名改为postorderTraversal
    // 测试链接 : https://leetcode.cn/problems/binary-tree-postorder-traversal/
    public static List<Integer> postorderTraversalOneStack(TreeNode h) {
        List<Integer> ans = new ArrayList<>();
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    stack.push(cur.right);
                } else {
                    ans.add(cur.val);
                    h = stack.pop();
                }
            }
        }
        return ans;
    }

}
