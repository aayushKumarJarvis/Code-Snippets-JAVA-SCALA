
class LinkedList {

    /*
    Construct Node class to create a structure of a node
     */
    private class Node {

        Node next;
        Object data;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }

    /*
    Using Node class construct a structure of LinkedList

    @Methods basic methods of add, remove, size are implemented
     */
    private Node head;
    private int listCount;

    public LinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public void addNode(Object data) {

        Node temporaryNode = new Node(data);
        Node currentNode = head;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(temporaryNode);
        listCount++;
    }

    public void addNode(Object data, int index) {

        Node temporaryNode = new Node(data);
        Node currentNode = head;

        for (int i = 1; i < index && currentNode.getNext() != null; i++) {
            currentNode = currentNode.getNext();
        }

        temporaryNode.setNext(currentNode.getNext());

        currentNode.setNext(temporaryNode);
        listCount++;
    }

    public Object getNode(int index) {

        if (index <= 0)
            return null;

        Node currentNode = head.getNext();
        for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null)
                return null;

            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public boolean removeNode(int index) {

        if (index < 1 || index > sizeOfLinkedList())
            return false;

        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null)
                return false;

            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        listCount--; // decrement the number of elements variable
        return true;
    }

    public int sizeOfLinkedList() {

        return listCount;
    }

}