package class014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用栈实现队列
 * 用两个栈实现队列
 * 出栈空的时候，才能继续从入栈倒数据
 * 入栈倒数据就要一次性都倒完
 */
// 用队列实现栈
public class ConvertQueueAndStack {


    class MyQueue1 {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public Stack<Integer> getInStack() {
            return inStack;
        }

        public void setInStack(Stack<Integer> inStack) {
            this.inStack = inStack;
        }

        public Stack<Integer> getOutStack() {
            return outStack;
        }

        public void setOutStack(Stack<Integer> outStack) {
            this.outStack = outStack;
        }

        public MyQueue1() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        /**
         * 数据入队列
         *
         * @param x
         */
        public void push(int x) {
            inStack.push(x);
            inStackToOutStack();
        }

        /**
         * 数据出队列
         *
         * @return
         */
        public int pop() {
            inStackToOutStack();
            return outStack.pop();
        }

        public int peek() {
            inStackToOutStack();
            return outStack.peek();
        }

        /**
         * 队列是否为空
         *
         * @return
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        /**
         * 倒数据：
         * outStack为空才能倒数据；
         * inStack倒数据时，必须一起性倒完！
         */
        private void inStackToOutStack() {
            if (outStack.empty()) {
                while (inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }


    // 测试链接 : https://leetcode.cn/problems/implement-queue-using-stacks/
    class MyQueue {

        // java的栈
        public Stack<Integer> in;
        // java的栈
        public Stack<Integer> out;

        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        // 倒数据
        // 从in栈，把数据倒入out栈
        // 1) out空了，才能倒数据
        // 2) 如果倒数据，in必须倒完
        private void inToOut() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
        }

        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

    }

    // 测试链接 : https://leetcode.cn/problems/implement-stack-using-queues/
    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        // O(n)
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

}
