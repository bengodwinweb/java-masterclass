import java.util.ArrayList;

public class Album {
    String name;
    ArrayList<Song> songs;

    public Album(String name, Song song) {
        this.name = name.toLowerCase();
        songs = new ArrayList<>();
        if (!addSong(song)) {
            System.out.println("Could not add song: " + song.getTitle() + " - song with that name already exists in album");
        }
    }

    public String getName() {
        return name;
    }

    public boolean hasSong(String songTitle) {
        return getIndex(songTitle) >= 0 ? true : false;
    }

    public boolean addSong(Song song) {
        if (songs.contains(song)) {
            return false;
        }
        songs.add(song);
        return true;
    }

    public Song getSong(String songTitle) {
        int index = getIndex(songTitle);
        if (index >= 0) return songs.get(index);
        return null;
    }

    public void printAlbum() {
        System.out.println(toTitleCase(name) + " - " + songs.size() + " Song" + (songs.size() != 1 ? "s" : ""));
        for (int i = 0; i < songs.size(); i++) {
            System.out.print((i + 1) + ". ");
            songs.get(i).printSong();
        }
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
