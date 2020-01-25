public class Main {
    public static void main(String[] args) {
        // Start application
        Song song1 = new Song("A Beautiful Song", 792);
        Album album1 = new Album("Amazing Album", song1);
        Song song2 = new Song("Another great song!", 482);
        album1.addSong(song2);

        Song song3 = new Song("I love You", 235852);
        Album album2 = new Album("Classic Jazz Album", song3);

        Library library = new Library(album1);
        library.addAlbum(album2);
//        library.printLibrary();

        Song secretSong = new Song("Forbidden", 478220);
        Album notInLibraryAlbum = new Album("I'm not in the library!", secretSong);
//        notInLibraryAlbum.printAlbum();

        Playlist playlist = new Playlist(library);
        playlist.addSong(album1.getName(), song1.getTitle());
        playlist.addSong("Classic Jazz Album", "I Love You");
        playlist.addSong("I'm not in the library!", "Forbidden");

//        System.out.println();
//        System.out.println("-------------------------------");
//        playlist.printPlaylist();
        playlist.play();
    }
}
