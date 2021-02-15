package InterAbs.Playlist;

import java.util.*;

public class MainPlaylist {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
        /*
        * Modify the Album class that uses an inner class.
        * Instead of utilizing ArrayList to hold its tracks, create an inner class called SongList.
        * The inner SongList class will use an ArrayList and will provide a method to add a song.
        * Neither the Song class or the Main class should be changed.
        */

        Album album = new Album("Within the Mist", "Azure Gaze");
        album.addSong("within the mist", 2.13);
        album.addSong("sanpo", 2.18);
        album.addSong("by your side", 2.08);
        albums.add(album);

        album = new Album("Hana-Bi", "Huey Daze");
        album.addSong("Sai", 2.18);
        album.addSong("Hikaru", 2.07);
        album.addSong("Yotsuba", 2.35);
        album.addSong("Sweet Nothings", 2.23);
        album.addSong("Stay Close", 2.26);
        album.addSong("Salo's Message", 2.15);
        album.addSong("Hibaru", 2.09);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylistByTitle("within the mist", playlist);
        albums.get(0).addToPlaylistByTitle("sanpo", playlist);
        albums.get(0).addToPlaylistByTitle("Hey There", playlist); // Does not exist
        albums.get(0).addToPlaylist(3, playlist);

        albums.get(1).addToPlaylist(5, playlist);
        albums.get(1).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(3, playlist);

        play(playlist);
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goToNext = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("Sorry there are no songs to play in this playlist");
            return;
        }else{
            printMenu();
            System.out.println("Playing " + listIterator.next().toString());
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Quitting playlist");
                    quit = true;
                    break;
                case 1: // Go to next song
                    if(!goToNext){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goToNext = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Playing " + listIterator.next().toString());
                    }else{
                        System.out.println("Reached the end of the playlist");
                        goToNext = false;
                    }
                    break;
                case 2: // Go to previous song
                    if(goToNext){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goToNext = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("At the start of the playlist");
                        goToNext = true;
                    }
                    break;
                case 3: // replay current song
                    if(goToNext){
                        if(listIterator.hasPrevious()){
                            System.out.println("Replaying " + listIterator.previous().toString());
                            goToNext = false;
                        }else{
                            System.out.println("At the start of the playlist");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Replaying " + listIterator.next().toString());
                            goToNext = true;
                        }else{
                            System.out.println("Reached the end of the playlist");
                        }
                    }

                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    if(playlist.size() > 0){
                        // After removing the current song, then the system will
                        // automartically play the next existing song in the entry
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Playing " + listIterator.next().toString());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Playing " + listIterator.previous().toString());
                        }
                    }
                    break;
                case 6:
                    printMenu();
                    break;
                default:
                    System.out.println("Error: Plese enter a valid command");
                    break;
            }
        }
    }

    private static void printList(LinkedList<Song> linkedList) {
        Iterator<Song> i= linkedList.iterator();

        System.out.println("===================PLAYLIST===================");
        while(i.hasNext()){
            System.out.println(i.next().toString());
        }
        System.out.println("==============================================");
    }

    private static void printMenu() {
        System.out.println("0 - To quit");
        System.out.println("1 - Go to next song");
        System.out.println("2 - Go to previous song");
        System.out.println("3 - Replay current song");
        System.out.println("4 - Show list of songs in playlist");
        System.out.println("5 - Delete current song from playlist");
        System.out.println("6 - Show menu options");
    }
}
