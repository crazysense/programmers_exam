package cracking_the_coding_interview.ch_02_linked_list;

// 리스트중간노드삭제
public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.add(2);
        Node deleteNode = n.add(3);
        n.add(4);

        Node.printNode(n);

        Solution01 sol01 = new Solution01();
        sol01.deleteNode(deleteNode);
        System.out.println("====>");
        Node.printNode(n);
    }

    static class Solution01 {
        // 자기 자신을 지우는 대신, 뒤 노드의 데이터를 자신의 데이터로 복사한 뒤, 뒤 노드를 지운다.
        boolean deleteNode(Node node) {
            if (node == null || node.next == null) return false;
            node.data = node.next.data;
            node.next = node.next.next;
            return true;
        }
    }
}
