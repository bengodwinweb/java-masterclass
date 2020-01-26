public class Player {
    private String name;
    private int number;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void printPlayer() {
        System.out.println("#" + number + " - " + name);
    }

    public void action() {
        System.out.println(name + " is getting ready to play!");
    }
}
