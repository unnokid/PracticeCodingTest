package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImplementQueueusingStacks {

    public static void main(String[] args) {

    }

    class MyQueue {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();
        public MyQueue() {

        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.pop();
        }

        public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            } else {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
