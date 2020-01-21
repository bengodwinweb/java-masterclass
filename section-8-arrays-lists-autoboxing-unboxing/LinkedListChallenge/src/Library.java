import java.util.ArrayList;

public class Library {
    private ArrayList<Album> albums;

    public Library(Album album) {
        albums = new ArrayList<>();
        if (!addAlbum(album)) {
            System.out.println("Could not add album: " + album.getName() + " - album with that name already exists in library");
        }
    }

    public boolean addAlbum(Album album) {
        if (albums.contains(album)) {
            return false;
        }
        albums.add(album);
        return true;
    }

    public boolean hasSong(String albumName, String songTitle) {
        int index = getIndex(albumName);
        if (index >= 0) {
            if (albums.get(index).hasSong(songTitle)) return true;
        }
        return false;
    }

    public Album getAlbum(String albumName) {
        int index = getIndex(albumName);
        if (index >= 0) return albums.get(getIndex(albumName));
        return null;
    }

    public void printLibrary() {
        System.out.println("==================");
        System.out.println("Full Library - " + albums.size() + " Album" + (albums.size() != 1 ? "s" : ""));
        for (Album album : albums) album.printAlbum();
    }

    private int getIndex(String name) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getName().equals(name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    private int getIndex(Album album) {
        return albums.indexOf(album);
    }
}
