import java.util.ArrayList;

public class Album {
    String name;
    SongList songList;

    public Album(String name, Song song) {
        this.name = name.toLowerCase();
        songList = new SongList();
        if (!addSong(song)) {
            System.out.println("Could not add song: " + song.getTitle() + " - song with that name already exists in album");
        }
    }

    private static class SongList {

        ArrayList<Song> songs;

        public SongList() {
            songs = new ArrayList<>();
        }

        public boolean addSong(Song song) {
            if (songs.contains(song)) return false;
            songs.add(song);
            return true;
        }

        public Song getSong(String songTitle) {
            int index = getIndex(songTitle);
            if (index >= 0) return songs.get(index);
            return null;
        }

        public Song getSong(int index) {
            return (index >= 0 && index < songs.size()) ? songs.get(index) : null;
        }

        private int getIndex(String name) {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getTitle().equals(name.toLowerCase())) {
                    return i;
                }
            }
            return -1;
        }

        private int getIndex(Song song) {
            return songs.indexOf(song);
        }

        public int size() {
            return songs.size();
        }
    }


    public String getName() {
        return name;
    }

    public boolean hasSong(String songTitle) {
        return songList.getSong(songTitle) != null;
    }

    public boolean addSong(Song song) {
        return songList.addSong(song);
    }

    public Song getSong(String songTitle) {
        return songList.getSong(songTitle);
    }

    public void printAlbum() {
        System.out.println(toTitleCase(name) + " - " + songList.size() + " Song" + (songList.size() != 1 ? "s" : ""));
        for (int i = 0; i < songList.size(); i++) {
            System.out.print((i + 1) + ". ");
            songList.getSong(i).printSong();
        }
    }

    private String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
