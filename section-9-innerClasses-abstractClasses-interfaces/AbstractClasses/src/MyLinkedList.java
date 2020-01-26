public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList() {
        setRoot(null);
    }

    public ListItem getRoot() {
        return root;
    }

    private void setRoot(ListItem node) {
        root = node;
    }

    public void traverse() {
        if (getRoot() != null) print(root);
        else System.out.println("Empty list");
    }

    private void print(ListItem node) {
        System.out.println(node.value);
        if (node.next() != null) print(node.next());
    }

    public boolean addItem(ListItem newNode) {
        if (getRoot() == null) {
            setRoot(newNode);
            return true;
        }
        return addItem(root, newNode);
    }

    private boolean addItem(ListItem currentNode, ListItem newNode) {
        if (currentNode.compareTo(newNode) < 0) {
            // newNode is larger than currentNode, look to right
            if (currentNode.next() != null) {
                // node to right exists, run addItem with that node
                addItem(currentNode.next(), newNode);
            } else {
                // no node to right, sight pointer to newNode
                currentNode.setNext(newNode);
                newNode.setPrevious(currentNode);
                return true;
            }
        } else if (currentNode.compareTo(newNode) > 0) {
            // newNode is smaller than currentNode, look to left
            if (currentNode.previous() != null) {
                // current is not head, insert new between current and previous
                newNode.setPrevious(currentNode.previous());
                newNode.setNext(currentNode);
                currentNode.previous().setNext(newNode);
                currentNode.setPrevious(newNode);
            } else {
                // current is head, set new to be head
                currentNode.setPrevious(newNode);
                newNode.setNext(currentNode);
                setRoot(newNode);
            }
            return true;
        }
        // nodes match, do not add duplicate
        return false;
    }

    public boolean removeItem(ListItem item) {
        if (getRoot() == null) return false;
        return removeItem(root, item);
    }

    private boolean removeItem(ListItem currentNode, ListItem removeNode) {
        if (currentNode.compareTo(removeNode) > 0) {
            //
            return false;
        } else if (currentNode.compareTo(removeNode) < 0) {
            if (currentNode.next() != null) {
                return removeItem(currentNode.next(), removeNode);
            } else {
                return false;
            }
        } else {
            // nodes match, remove
            if (currentNode.next() == null) {
                // current is last node, set previous to be last
                currentNode.previous().setNext(null);
            } else {
                // set pointers on previous and next
                if (currentNode.previous() == null) {
                    // current is head, remove head and set next to head
                    if (currentNode.next() == null) setRoot(null);
                    else setRoot(currentNode.next());
                    return true;
                }
                currentNode.previous().setNext(currentNode.next());
            }
            return true;
        }
    }
}
