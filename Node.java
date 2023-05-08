// The Node class contains the information of a single node for our linked list
package phonebook;

public class Node {
    Node next;
    Entry entry;

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
