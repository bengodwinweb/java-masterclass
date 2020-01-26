public class BaseballPlayer extends Player {
    public BaseballPlayer(String name, int number) {
        super(name, number);
    }

    @Override
    public void action() {
        super.action();
        System.out.println(" swings at the pitch!");
    }
}
