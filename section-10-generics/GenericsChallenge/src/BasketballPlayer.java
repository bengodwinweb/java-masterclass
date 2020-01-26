public class BasketballPlayer extends Player {
    public BasketballPlayer(String name, int number) {
        super(name, number);
    }

    @Override
    public void action() {
        super.action();
        System.out.println(super.getName() + " dunks the ball!");
    }
}
