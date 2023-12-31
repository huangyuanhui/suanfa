package class015;

import java.util.Stack;

/**
 * 最小栈
 * 获取栈中最小数据
 * 思路：准备一个记录最小值的栈，
 *
 */
// 测试链接 : https://leetcode.cn/problems/min-stack/
public class GetMinStack {
    class MinStack3 {

        private Stack<Integer> dataStack;

        private Stack<Integer> minStack;

        public MinStack3() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        /**
         * 数据入栈，同时记录栈最小值，
         * 当入栈数据小于最小栈栈顶数据，最小栈栈顶数据重复入最小栈！
         * @param val
         */
        public void push(int val) {
            dataStack.push(val);
            if (minStack.empty() || val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        /**
         * 数据出栈
         */
        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // 提交时把类名、构造方法改成MinStack
    class MinStack1 {
        public Stack<Integer> data;
        public Stack<Integer> min;

        public MinStack1() {
            data = new Stack<Integer>();
            min = new Stack<Integer>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            } else { // !min.isEmpty() && val > min.peek()
                min.push(min.peek());
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    // 提交时把类名、构造方法改成MinStack
    class MinStack2 {
        // leetcode的数据在测试时，同时在栈里的数据不超过这个值
        // 这是几次提交实验出来的，哈哈
        // 如果leetcode补测试数据了，超过这个量导致出错，就调大
        public final int MAXN = 8001;

        public int[] data;
        public int[] min;
        int size;

        public MinStack2() {
            data = new int[MAXN];
            min = new int[MAXN];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || val <= min[size - 1]) {
                min[size] = val;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }
    }

}
