package hacker_rank;

public class HuffmanDecoding {
    abstract class Node implements Comparable<Node> {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
        public Node(int freq) {
            frequency = freq;
        }

        // compares on the frequency
        public int compareTo(Node tree) {
            return frequency - tree.frequency;
        }
    }

    class HuffmanLeaf extends Node {


        public HuffmanLeaf(int freq, char val) {
            super(freq);
            data = val;
        }
    }

    class HuffmanNode extends Node {

        public HuffmanNode(Node l, Node r) {
            super(l.frequency + r.frequency);
            left = l;
            right = r;
        }

    }

    public class State {
        public char data;
        public int index = 0;
    }

    void decode(String s, Node root) {
        StringBuffer sb = new StringBuffer();
        State state = new State();
        while (state.index < s.length()) {
            state = decodeHelper(root, s, state);
            sb.append(state.data);
        }
        System.out.println(sb.toString());
    }

    State decodeHelper(Node n, String s, State state) {
        if (n.data != '\0') {
            state.data = n.data;
            return state;
        }
        if (s.charAt(state.index++) == '0') {
            return decodeHelper(n.left, s, state);
        } else {
            return decodeHelper(n.right, s, state);
        }
    }
}
