package InterAbs.Playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        Song song = this.songs.findSongByTrackNumber(trackNumber);
        if(song != null){
            playlist.add(song);
            return true;
        }
        System.out.println("This album does not have a track "+ trackNumber );
        return false;
    }

    public boolean addToPlaylistByTitle(String title, LinkedList<Song> playlist){
        Song song = this.songs.findSongByTitle(title);
        if(song != null){
            playlist.add(song);
            return true;
        }
        System.out.println("The song with title under " + title+ " is not in this album");
        return false;
    }

    // SongList Inner class
    private class SongList{
        private ArrayList<Song> songs;
        public SongList(){
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){
            // ArrayList method .contains()
            if(songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }
        public Song findSongByTitle(String title) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        public Song findSongByTrackNumber(int trackNumber){
            int index = trackNumber - 1;
            if((index > 0) && (index < songs.size())){
                return songs.get(index);
            }
            return null;
        }

    }

}
