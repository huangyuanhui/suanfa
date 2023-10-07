package class012;

// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.cn/problems/partition-list/
public class PartitionList {

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
        public static ListNode partition1(ListNode head, int x) {

            ListNode minHead = null, minTail = null;    // 小头 小尾
            ListNode maxHead = null, maxTail = null;  // 大头 大尾
            ListNode next = null;
            while (head != null) {
                next = head.next;
                // head与原链表断联
                head.next = null;
                // < x
                if (head.val < x) {
                    if (minHead == null) {
                        minHead = head;
                        // minTail = head;
                    } else {
                        minTail.next = head;
                        // minTail = head;
                    }
                    minTail = head;
                }
                // >= x
                else {
                    if (maxHead == null) {
                        maxHead = head;
                    } else {
                        maxTail.next = head;
                    }
                    maxTail = head;
                }
                head = next;
            }
            if (minHead == null) {
                return maxHead;
            }
            minTail.next = maxHead;
            return minHead;
        }

        public static ListNode partition(ListNode head, int x) {
            ListNode leftHead = null, leftTail = null; // < x的区域
            ListNode rightHead = null, rightTail = null; // >=x的区域
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = null;
                if (head.val < x) {
                    if (leftHead == null) {
                        leftHead = head;
                    } else {
                        leftTail.next = head;
                    }
                    leftTail = head;
                } else {
                    if (rightHead == null) {
                        rightHead = head;
                    } else {
                        rightTail.next = head;
                    }
                    rightTail = head;
                }
                head = next;
            }
            if (leftHead == null) {
                return rightHead;
            }
            // < x的区域有内容！
            leftTail.next = rightHead;
            return leftHead;
        }

    }

}
