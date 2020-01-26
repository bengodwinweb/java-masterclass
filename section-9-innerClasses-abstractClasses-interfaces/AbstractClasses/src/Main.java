public class Main {
    public static void main(String[] args) {
        MyLinkedList citiesList = new MyLinkedList();
        MyLinkedList numbersList = new MyLinkedList();

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for ( String s : data ) {
            citiesList.addItem(new Node(s));
        }
        citiesList.traverse();
        System.out.println();

        citiesList.removeItem(new Node("Sydney"));
        citiesList.removeItem(new Node("Canberra"));
        citiesList.traverse();
        System.out.println();

        String numbersData = "15 11 8 92 46 2";
        String[] numbers = numbersData.split(" ");
        for (String s : numbers ) {
            numbersList.addItem(new Node(s));
        }
        numbersList.traverse();
        System.out.println();

        numbersList.removeItem(new Node("15"));
        numbersList.traverse();
        System.out.println();

        MySearchTree tree = new MySearchTree();
        tree.traverse();
        System.out.println();

        tree.addItem(new Node("5"));
        tree.addItem(new Node("3"));
        tree.addItem(new Node("9"));
        tree.addItem(new Node("1"));
        tree.addItem(new Node("6"));
        tree.addItem(new Node("8"));
        tree.addItem(new Node("4"));
        tree.addItem(new Node("7"));
        tree.addItem(new Node("2"));
        tree.addItem(new Node("2"));

        tree.traverse();
        System.out.println();

        tree.removeItem(new Node("3"));
        tree.removeItem(new Node("7"));
        tree.removeItem(new Node("7"));
        tree.traverse();

    }
}
