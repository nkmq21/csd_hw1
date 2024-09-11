public class MyList {
    Node head;
    Node tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    Integer getFirst() {
        if (isEmpty()) {
            return -1;
        } else {
            return head.value;
        }
    }

    int getLast() {
            if (isEmpty()) {
                return -1;
        } else {
            return tail.value;
        }
    }

    int getIndex(int index) {
        if (index < 0) {
            return -1;
        } else {
            if (isEmpty()) {
                return -1;
            } else {
                int i = 0;
                Node cur = head;
                while (cur != null) {
                    if (i == index) {
                        return cur.value;
                    }
                    i++;
                    cur = cur.next;
                }
            }
        }
        return -1;
    }

    void updateAtPos(int x, int index) {
        if (isEmpty() || index < 0) {
            System.out.println("ERR");
            return;
            //neu if thuc hien thi xong la thoat luon
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (i == index) {
                cur.value = x;
                return;
            }
            i++;
            cur = cur.next;
        }
        System.out.println("ERR");
    }

    int find(int x) {
        if (isEmpty()) {
            return -1;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (cur.value == x) {
                return i;
            }
            i++;
            cur = cur.next;
        }
        //neu chay het list ma khong tim thay x thi return -1
        return -1;
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.next = null;
            tail = node;
        }
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addIndex(int value, int index) {
        int p = 0;
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        Node cur = head;
        while (cur != null && p < index - 1) {
            cur = cur.next;
            p++;
        }
        if (cur == null) {
            return;
        }
        node.next = cur.next;
        cur.next = node;
    }

    void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Danh sach rong khong the xoa");
        } else {
            head = head.next;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            System.out.println("Danh sach rong khong the xoa");
        } else {
            Node cur = head;
            while (cur.next != tail) {
                cur = cur.next;
            }
            cur.next = null;
            tail = cur;
        }
    }

    Integer delLast() {
        if (isEmpty()) {
            System.out.println("Danh sach rong khong the xoa");
            return null;
        }
        int value = tail.value;
        if (head == tail) { //neu list chi co 1 phan tu
            head = tail = null;
        } else {
            Node cur = head;
            //vong while de tim gia tri ap chot
            while (cur.next != tail) {
                cur = cur.next;
            }
            //xoa gia tri cuoi cung, gan gia tri ap chot thanh gia tri cuoi cung
            cur.next = null;
            tail = cur;
        }
        return value;
    }

    void deleteAnyWhere(int pos) {
        if (isEmpty()) {
            System.out.println("Danh sach rong khong the xoa");
        }
        if (pos < 0) {
            System.out.println("Vi tri khong hop le");
        } else {
            int index = 0;
            Node cur = head;
            while (cur.next != null) {
                if (index == pos - 1) {
                    cur.next = cur.next.next;
                    return;
                }
                cur = cur.next;
                index++;
            }
        }
    }

    Integer delIndex(int pos) {
        if (isEmpty()) {
            System.out.println("Danh sach rong khong the xoa");
            return null;
        }
        if (pos < 0) {
            System.out.println("Vi tri khong hop le");
            return null;
        }
        int index = 0;
        Node cur = head;
        if (pos == 1) {
            int value = head.value;
            if (head == null) {
                tail = null;
            }
            return value;
        }
        while (cur.next != null) {
            //index == pos -1 vi pos bat dau tu 1
            if (index == pos - 1) {
                int value = cur.next.value;
                cur.next = cur.next.next;
                if (cur.next == null) {
                    tail = cur;
                }
                return value;
            }
            cur = cur.next;
            index++;
        }
        //neu pos is out of bound thi vong lap se tra ve null
        System.out.println("Vi tri khong hop le");
        return null;
    }

    void display() {
        Node cur = head;
        if (isEmpty()) {
            System.out.println("Danh sach rong lam sao hien thi");
        } else {
            while (cur != null) {
                System.out.println(cur.value + " ");
                cur = cur.next;
            }
        }
    }

    void accSort() {
        for (Node i = head; i != tail; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.value > j.value) {
                    int t = i.value;
                    i.value = j.value;
                    j.value = t;
                }
            }
        }
    }

    int getSize() {
        if (isEmpty()) {
            return 0;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        return i;
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(9);
        list.addIndex(10, 2);
        list.display();
        System.out.println("the first: " + list.getFirst());
//        list.deleteFirst();
//        list.deleteLast();
//        list.deleteAnyWhere(2);
//        list.delLast();
//        list.delIndex(2);
//        list.display();
        list.updateAtPos(100, 4);
        System.out.println("Vi tri cua 10 la: " + list.find(10));
        list.accSort();
        list.display();
    }

}
