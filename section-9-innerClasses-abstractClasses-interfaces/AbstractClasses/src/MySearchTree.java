public class MySearchTree implements NodeList {
    private ListItem root;

    public MySearchTree() {
        setRoot(null);
    }

    private void setRoot(ListItem item) {
        root = item;
    }

    public ListItem getRoot() {
        return root;
    }

    public void traverse() {
        if (getRoot() == null) System.out.println("Empty tree");
        else traverse(getRoot());
    }

    private void traverse(ListItem node) {
        if (node != null) {
            traverse(node.previous());
            System.out.println(node.getValue());
            traverse(node.next());
        }
    }

    private boolean traverseAdd(ListItem node) {
        if (node != null) {
            traverseAdd(node.previous());
            traverseAdd(node.next());
            addItem(new Node(node.getValue()));
            return true;
        }
        return false;
    }

    public boolean addItem(ListItem addNode) {
        if (getRoot() != null) return addItem(getRoot(), addNode);
        setRoot(addNode);
        return true;
    }

    private boolean addItem(ListItem currentNode, ListItem newNode) {
        if (currentNode.compareTo(newNode) < 0) {
            // move to the right child or set newNode as right child and return true
            if (currentNode.next() == null) {
                currentNode.setNext(newNode);
                return true;
            } else {
                return addItem(currentNode.next(), newNode);
            }
        } else if (currentNode.compareTo(newNode) > 0) {
            // move to the left child or set newNode as left child and return true
            if (currentNode.previous() == null) {
                currentNode.setPrevious(newNode);
                return true;
            } else {
                return addItem(currentNode.previous(), newNode);
            }
        } else {
            // node equals current node, return false
            return false;
        }
    }

    public boolean removeItem(ListItem removeNode) {
        if (getRoot() != null) return removeItem(getRoot(), removeNode, null, false);
        return false;
    }

    private boolean removeItem(ListItem currentNode, ListItem removeNode, ListItem lastNode, Boolean movingRight) {
        if (currentNode.compareTo(removeNode) == 0) {
            // if lastNode exists, remove reference to currentNode from lastNode
            if (lastNode == null) {
                setRoot(null);
                traverseAdd(currentNode.previous());
                traverseAdd(currentNode.next());
            } else {
                // if movingRight, remove right child, else remove Left Child
                if (movingRight) lastNode.setNext(null);
                else lastNode.setPrevious(null);
                if (currentNode.previous() != null) traverseAdd(currentNode.previous());
                if (currentNode.next() != null) traverseAdd(currentNode.next());
            }
            return true;
        } else if (currentNode.compareTo(removeNode) > 0) {
            // move to left child, if no left child return false
            if (currentNode.previous() == null) return false;
            else return removeItem(currentNode.previous(), removeNode, currentNode, false);
        } else {
            // mode to right child, if no right child return false
            if (currentNode.next() == null) return false;
            else return removeItem(currentNode.next(), removeNode, currentNode, true);
        }
    }
}
