import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    private ArrayList<T> roster = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (roster.contains(player)) return false;
        roster.add(player);
        return true;
    }

    public int rosterSize() {
        return roster.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;

        if (ourScore > theirScore) {
            won++;
            message = " beat";
        } else if (theirScore > ourScore) {
            lost++;
            message = " lost to ";
        } else {
            tied++;
            message = " drew with ";
        }
        played++;
        if (opponent != null) {
            System.out.println(name + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int points() {
        return won * 3 + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (points() > team.points()) return -1;
        else if (points() < team.points()) return 1;
        return 0;
    }
}
