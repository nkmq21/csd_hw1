public class Node {
    int value;
    Node next;

    public Node() {
    }

    public Node(int value) { //them 1 gia tri vao node
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
