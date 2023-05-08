package phonebook;

public class Node {
    Node next;
    Entry entry;

    // constructors
    public Node (Entry newEntry) {
        this.entry = newEntry;
        next = null;
    }

    // setters and getters
    public Entry getEntry() {
        return entry;
    }

    public Node getNext() {
        return next;
    }

    public void setEntry(Entry newEntry) {
        entry = newEntry;
    }

    public void setNext(Node newNode) {
        next = newNode;
    }
}
