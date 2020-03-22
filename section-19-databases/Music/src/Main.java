import model.Artist;
import model.Datasource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists();
        if (artists == null) {
            System.out.println("no artists");
            return;
        }

        for (Artist artist : artists) {
            System.out.printf("ID = %d, Name = %s%n", artist.getId(), artist.getName());
        }

        datasource.close();
    }
}
