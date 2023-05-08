// The EntryList class is a linked list designed to hold the entries of our phonebook
package phonebook;

public class EntryList {
    Node head;
    int size;

    public EntryList() {
        head = null;
        size = 0;
    }

    // Adds an entry to the end of the linked list
    public void add(Entry newData) {
        if (size == 0) {
            head = new Node(newData);
        } else {
            Node buffer = new Node(newData);
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(buffer);
        }
        size++;
    }

    // Returns a specified entry from the linked list
    public Entry get(int index) {
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        return current.getEntry();
    }

    // Returns the size of the linked list
    public int size() {
        return size;
    }

    // Removes a specified entry from the linked list
    public void remove(int index) {
        moveToLast(index);
        removeLast();
    }

    // Removes the last entry of the linked list
    public void removeLast() {
        Node current = head;
        if (current.getNext() == null) {
            head = null;
        } else {
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
        size--;
    }

    // Moves a specified entry to the end of the linked list
    public void moveToLast(int index) {
        Node current = head;
        for (int i = 1; i < (index); i++) {
            current = current.getNext();
        }
        Entry buffer = current.getEntry();
        while (current.getNext() != null) {
            current.setEntry(current.getNext().getEntry());
            current = current.getNext();
        }
        current.setEntry(buffer);
    }

}
