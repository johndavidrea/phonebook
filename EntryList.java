package phonebook;

public class EntryList {
    Node head;
    int size;

    public EntryList() {
        head = null;
        size = 0;
    }

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

    public Entry get(int index) {
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        return current.getEntry();
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        moveToLast(index);
        removeLast();
    }

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
