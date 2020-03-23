package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public enum SORT_ORDER{NONE, DESC, ASC}

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/bgodwin/Local Files/Development Projects/java-programming-masterclass/section-19-databases/Music/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALDUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ARTIST_NAME + " FROM " + TABLE_ALBUMS +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " + TABLE_ARTISTS + "." +
            COLUMN_ARTIST_NAME + " = ";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTISTS_BY_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." +
            COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " +
            TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM +
            " = " + TABLE_ALBUMS + "." + COLUMN_ALDUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTISTS_BY_SONG_ORDER =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS +
            "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";


    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Artist> queryArtists() {
        return queryArtists(SORT_ORDER.ASC);
    }

    public List<Artist> queryArtists(SORT_ORDER sortOrder) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != SORT_ORDER.NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == SORT_ORDER.DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();
            while(results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName) {
        return queryAlbumsForArtist(artistName, SORT_ORDER.ASC);
    }

    public List<String> queryAlbumsForArtist(String artistName, SORT_ORDER sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append("\"");
        sb.append(artistName);
        sb.append("\"");
        if (sortOrder != SORT_ORDER.NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == SORT_ORDER.DESC) {
                sb.append("DESC");
            }
        }

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {

            List<String> albums = new ArrayList<>();
            while(results.next()) {
                albums.add(results.getString(1));
            }
            return albums;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songTitle) {
        return queryArtistsForSong(songTitle, SORT_ORDER.ASC);
    }

    public List<SongArtist> queryArtistsForSong(String songTitle, SORT_ORDER sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ARTISTS_BY_SONG_START);
        sb.append(songTitle);
        sb.append("\"");
        if (sortOrder != SORT_ORDER.NONE) {
            sb.append(QUERY_ARTISTS_BY_SONG_ORDER);
            if (sortOrder == SORT_ORDER.DESC) {
                sb.append("DESC");
            }
        }

        System.out.println(sb.toString());

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtistList = new ArrayList<>();
            while(results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setSongTrack(results.getInt(3));
                songArtistList.add(songArtist);
            }

            return songArtistList;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            System.out.println("--- SONGS TABLE METADATA ---");
            for (int i = 1; i <= numColumns; i++) {
                System.out.printf("Column %d - %s%n", i, meta.getColumnName(i));
            }
            System.out.println();

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) FROM " + table;

        try (Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sql);) {

            return results.getInt(1);

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
}
