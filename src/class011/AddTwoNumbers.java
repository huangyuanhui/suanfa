package class011;

// 给你两个 非空 的链表，表示两个非负的整数
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
// 测试链接：https://leetcode.cn/problems/add-two-numbers/
public class AddTwoNumbers {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {

        /**
         * @param head1
         * @param head2
         * @return
         */
        public static ListNode addTwo(ListNode head1, ListNode head2) {
            ListNode head = null;
            ListNode nextNode = null;
            int sum = 0;
            int value1, value2, value;
            while (head1 != null || head2 != null) {
                value1 = head1 == null ? 0 : head1.val;
                value2 = head2 == null ? 0 : head2.val;
                value = (value1 + value2 + sum) % 10;
                if (head == null) {
                    head = new ListNode(value);
                    nextNode = head;
                } else {
                    nextNode.next = new ListNode(value);
                    nextNode = nextNode.next;
                }
                // 计算进位
                sum = (value1 + value2 + sum) / 10;

                if (head1 != null) {
                    head1 = head1.next;
                }
                if (head2 != null) {
                    head2 = head2.next;
                }
            }
            return head;
        }


        // 也可以复用老链表
        // 不过这个实现没有这么做，都是生成的新节点(为了教学好懂)
        public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
            ListNode ans = null, cur = null;
            int carry = 0;
            for (int sum, val; // 声明变量
                 h1 != null || h2 != null; // 终止条件
                 h1 = h1 == null ? null : h1.next, // 每一步h1的跳转
                         h2 = h2 == null ? null : h2.next // 每一步h2的跳转
            ) {

                sum = (h1 == null ? 0 : h1.val)
                        + (h2 == null ? 0 : h2.val)
                        + carry;

                val = sum % 10;
                carry = sum / 10;
                if (ans == null) {
                    ans = new ListNode(val);
                    cur = ans;
                } else {
                    cur.next = new ListNode(val);
                    cur = cur.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return ans;
        }

    }

}
