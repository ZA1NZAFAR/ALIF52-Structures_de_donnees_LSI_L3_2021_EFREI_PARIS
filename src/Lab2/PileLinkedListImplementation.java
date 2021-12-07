public class PileLinkedListImplementation {
    Node list;

    public PileLinkedListImplementation() {
    }

    public void push(int n) {
        Node tmp = new Node(n);
        tmp.setNext(list);
        list = tmp;
    }

    public void pop() {
        list=list.next;
    }

    public int top() {
        return list.val;
    }

    @Override
    public String toString() {
        return "PileLinkedListImplementation{" +
                "list=" + list +
                '}';
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}