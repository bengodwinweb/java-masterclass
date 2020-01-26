public class Main {
    public static void main(String[] args) {
        League<Team<BasketballPlayer>> nba = new League<>("NBA");

        Team<BasketballPlayer> sixers = new Team<>("Philadelphia 76ers");
        Team<BasketballPlayer> lakers = new Team<>("LA Lakers");
        Team<BasketballPlayer> celtics = new Team<>("Boston Celtics");
        Team<BasketballPlayer> heat = new Team<>("Miami Heat");

        Team<BaseballPlayer> phillies = new Team<>("Philadelphia Phillies");

        nba.addTeam(sixers);
        nba.addTeam(lakers);
        nba.addTeam(celtics);
        nba.addTeam(heat);
//        nba.addTeam(phillies);

        sixers.matchResult(lakers, 108, 104);
        sixers.matchResult(heat, 99, 96);
        sixers.matchResult(celtics, 120, 92);
        lakers.matchResult(celtics, 132, 109);
        lakers.matchResult(heat, 112, 112);
        heat.matchResult(celtics, 110, 107);
        System.out.println();

        nba.showLeagueTable();
    }
}
