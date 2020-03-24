import model.Artist;
import model.Datasource;
import model.SongArtist;

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

        String artist = "Iron Maiden";
        List<String> pinkFloydAlbums = datasource.queryAlbumsForArtist(artist);
        System.out.println("\n--- " + artist + " Albums ---");
        for (String a : pinkFloydAlbums) {
            System.out.println(a);
        }
        System.out.println("--- " + artist + " Albums ---\n");


        String song = "Go Your Own Way";
        List<SongArtist> songArtistList = datasource.queryArtistsForSong(song);
        System.out.println("\n--- " + song + " Artists ---");
        for (SongArtist songArtist : songArtistList) {
            System.out.println(songArtist);
        }
        System.out.println("--- " + song + " Artists ---\n");

        datasource.querySongsMetadata();

        int songsCount = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("songs total = " + songsCount + "\n");

        System.out.println("Creating artist_list... - " + datasource.createViewForSongArtists());

        songArtistList = datasource.querySongInfoView(song);
        System.out.println("\n--- " + song + " Artists from artist_view ---");
        for (SongArtist songArtist : songArtistList) {
            System.out.println(songArtist);
        }
        System.out.println("--- " + song + " Artists from artist_view ---\n");

        datasource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);

        datasource.close();
    }
}
