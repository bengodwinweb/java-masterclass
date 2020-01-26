public class SoccerPlayer extends Player {
    public SoccerPlayer(String name, int number) {
        super(name, number);
    }

    @Override
    public void action() {
        super.action();
        System.out.println(super.getName() + " dribbles down the field!");
    }
}
