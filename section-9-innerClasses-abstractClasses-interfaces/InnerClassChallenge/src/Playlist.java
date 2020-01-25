import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private LinkedList<Song> songs;
    private Library library;

    public Playlist(Library library) {
        this.library = library;
        songs = new LinkedList<>();
    }

    public boolean addSong(String albumName, String songTitle) {
        Album album = library.getAlbum(albumName);
        if (album == null) return false;
        Song song = album.getSong(songTitle);
        if (song == null) return false;
        songs.add(song);
        return true;
    }

    public void printPlaylist() {
        for (Song song : songs) {
            song.printSong();
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> playlist = songs.listIterator();

        if(songs.isEmpty()) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Starting playlist");
            printMenu();
        }

        while (!quit) {
            System.out.println("Enter your choice:");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input - press 0 to print menu options");
                scanner.nextLine();
                continue;
            }
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    if (!goingForward) {
                        if (playlist.hasNext()) {
                            playlist.next();
                        }
                        goingForward = true;
                    }
                    if (playlist.hasNext()) {
                        System.out.print("Now playing ");
                        playlist.next().printSong();
                    } else {
                        System.out.println("End of playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (playlist.hasPrevious()) {
                            playlist.previous();
                        }
                        goingForward = false;
                    }
                    if (playlist.hasPrevious()) {
                        System.out.print("Now playing ");
                        playlist.previous().printSong();
                    } else {
                        System.out.println("Beginning of playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    System.out.print("Replaying ");
                    if (goingForward) {
                        if (playlist.hasPrevious()) {
                            playlist.previous().printSong();
                            goingForward = false;
                        } else {
                            playlist.next().printSong();
                            goingForward = true;
                        }
                    } else {
                        if (playlist.hasNext()) {
                            playlist.next().printSong();
                            goingForward = true;
                        } else {
                            playlist.previous().printSong();
                            goingForward = false;
                        }
                    }
                    break;
                case 4:
                    printPlaylist();
                    break;
                case 5:
                    quit = true;
                    System.out.println("Ending playlist");
                    break;
                default:
                    System.out.println("Invalid input - press 0 to print menu options");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\nPress");
        System.out.println("\t0 - Print menu options");
        System.out.println("\t1 - Jump forward to next song");
        System.out.println("\t2 - Jump backward to previous song");
        System.out.println("\t3 - Replay the current song");
        System.out.println("\t4 - List the songs in the playlist");
        System.out.println("\t5 - Quit");
    }

}
