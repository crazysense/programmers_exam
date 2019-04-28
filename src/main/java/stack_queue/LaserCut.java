package stack_queue;

public class LaserCut {
    public static void main(String[] args) {
        LaserCut sol = new LaserCut();
        String arrangement = "()(((()())(())()))(())";
        System.out.println(sol.solution(arrangement));
    }

    public int solution(String arrangement) {
        final Stack pipe = new Stack(arrangement.length());
        final Prev prev = new Prev();
        return arrangement.chars().map(c -> {
            int res = 0;
            if (c == '(') {
                pipe.push((char) c);
            } else {
                pipe.pop();
                res = prev.getPrev() == '(' ? pipe.size() : 1;
            }
            prev.setPrev((char) c);
            return res;
        }).sum();
    }

    class Prev {
        private char c;

        public char getPrev() {
            return c;
        }

        public void setPrev(char c) {
            this.c = c;
        }
    }

    class Stack {
        private final char[] stack;
        private int sp;

        public Stack(int size) {
            stack = new char[size];
            sp = 0;
        }

        public void push(char c) {
            if (sp == stack.length) throw new RuntimeException("Stack is full.");
            stack[sp++] = c;
        }

        public char pop() {
            if (sp == 0) throw new RuntimeException("Stack is empty.");
            return stack[--sp];
        }

        public int size() {
            return sp;
        }
    }
}
