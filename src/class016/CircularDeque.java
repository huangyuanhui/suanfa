package class016;

import java.util.Deque;
import java.util.LinkedList;

// 设计循环双端队列
// 测试链接 : https://leetcode.cn/problems/design-circular-deque/
public class CircularDeque {

    /**
     * 双端队列
     */
    class MyCircularDeque {

        private Deque<Integer> deque = new LinkedList<>();
        // 双端队列数据量限制
        private int limit;
        // 双端队列数据量
        private int size;

        public Deque<Integer> getDeque() {
            return deque;
        }

        public void setDeque(Deque<Integer> deque) {
            this.deque = deque;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public MyCircularDeque(int k) {
            limit = k;
        }

        /**
         * 头部加入
         *
         * @param value
         * @return
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerFirst(value);
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerLast(value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            deque.pollFirst();
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            deque.pollLast();
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }


    // 提交时把类名、构造方法改成 : MyCircularDeque
    // 其实内部就是双向链表
    // 常数操作慢，但是leetcode数据量太小了，所以看不出劣势
    class MyCircularDeque1 {

        // Dequeue双端队列接口 LinkedList双端队列实现
        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerFirst(value);
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerLast(value);
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                size--;
                deque.pollFirst();
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                size--;
                deque.pollLast();
                return true;
            }
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekFirst();
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekLast();
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

    }

    // 提交时把类名、构造方法改成 : MyCircularDeque
    // 自己用数组实现，常数操作快，但是leetcode数据量太小了，看不出优势
    class MyCircularDeque2 {

        public int[] deque;
        public int l, r, size, limit;

        public MyCircularDeque2(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    l = l == 0 ? (limit - 1) : (l - 1);
                    deque[l] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    r = r == limit - 1 ? 0 : (r + 1);
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                l = (l == limit - 1) ? 0 : (l + 1);
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                r = r == 0 ? (limit - 1) : (r - 1);
                size--;
                return true;
            }
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[l];
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[r];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

    }


    class CircularQueue {
        // 数组模拟双端队列
        private int[] queue;
        // 左端
        private int left;
        // 右端
        private int right;
        // 队列元素长度
        private int size;
        // 数组长度
        private int limit;

        public int[] getQueue() {
            return queue;
        }

        public void setQueue(int[] queue) {
            this.queue = queue;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public CircularQueue(int k) {
            queue = new int[k];
            limit = k;
        }

        /**
         * 头部加入
         *
         * @param value
         * @return
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            // 队列空，left、right回到0位置
            if (isEmpty()) {
                left = 0;
                right = 0;
            } else {
                left = left == 0 ? limit - 1 : left - 1;
            }
            queue[left] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                left = right = 0;
            } else {
                right = right == limit - 1 ? 0 : right + 1;
            }
            queue[right] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            left = left == limit - 1 ? 0 : left + 1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            right = right == 0 ? limit - 1 : right - 1;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return queue[left];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[right];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

}
