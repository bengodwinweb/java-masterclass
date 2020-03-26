package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public enum SORT_ORDER{NONE, DESC, ASC}

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/bgodwin/Local Files/Development Projects/java-programming-masterclass/section-19-databases/Music/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
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
            " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTISTS_BY_SONG_ORDER =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS +
            "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW =
            "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " (" + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ") AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME +
            ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." +
            COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " +
            TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS
            + "." + COLUMN_ARTIST_ID + " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", "
            + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE, " + TABLE_SONGS + "." +
            COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO = "SELECT * FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT * FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + '(' + COLUMN_ARTIST_NAME +
            ") VALUES(?)";

    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS + '(' + COLUMN_ALBUM_NAME +
            ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS + '(' + COLUMN_SONG_TRACK +
            ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS +
            " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    public static final String QUERY_SONG = "SELECT * FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS +
            " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = ? AND " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
            " = ?";

    private Connection conn;

    private PreparedStatement querySongInfoView;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement querySong;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONG);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
            querySong = conn.prepareStatement(QUERY_SONG);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (querySongInfoView != null) querySongInfoView.close();
            if (insertIntoArtists != null) insertIntoArtists.close();
            if (insertIntoAlbums != null) insertIntoAlbums.close();
            if (insertIntoSongs != null) insertIntoSongs.close();
            if (queryArtist != null) queryArtist.close();
            if (queryAlbum != null) queryAlbum.close();
            if (conn != null) conn.close();
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
            System.out.println("--- SONGS TABLE METADATA ---");
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

    public boolean createViewForSongArtists() {
        try (Statement statement = conn.createStatement()) {
            System.out.println("SQL: " + CREATE_ARTIST_FOR_SONG_VIEW);
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<SongArtist> querySongInfoView(String title) {
        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
        sb.append(title).append("\"");

        try {
            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery();
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

    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();

        if (results.next()) return results.getInt(1);

        insertIntoArtists.setString(1, name);
        int affectedRows = insertIntoArtists.executeUpdate();

        if (affectedRows != 1) throw new SQLException("Couldn't insert artist");

        ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
        if(generatedKeys.next()) return generatedKeys.getInt(1);

        throw new SQLException("Couldn't get _id for artist");
    }

    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();

        if (results.next()) return results.getInt(1);

        insertIntoAlbums.setString(1, name);
        insertIntoAlbums.setInt(2, artistId);
        int affectedRows = insertIntoAlbums.executeUpdate();

        if (affectedRows != 1) throw new SQLException("Couldn't insert album");

        ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
        if(generatedKeys.next()) return generatedKeys.getInt(1);

        throw new SQLException("Couldn't get _id for album");
    }

    public void insertSong(String title, String artist, String album, int track) {
        try {
            querySong.setString(1, title);
            querySong.setString(2, album);
            ResultSet results = querySong.executeQuery();
            if (results.next()) {
                System.out.println("Song already in database at index " + results.getInt(1));
                return;
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return;
        }



        try {
            conn.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            System.out.println("new artistId = " + artistId);
            System.out.println("new albumId = " + albumId);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            int affectedRows = insertIntoSongs.executeUpdate();

            if (affectedRows == 1) conn.commit();
            else throw new SQLException("Song insert failed");

        } catch(Exception e) {
            System.out.println("Performing rollback");
            e.printStackTrace();
            try {
                conn.rollback();
            } catch(SQLException e2) {
                System.out.println("Error rolling back" + e.getMessage());
                e.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
