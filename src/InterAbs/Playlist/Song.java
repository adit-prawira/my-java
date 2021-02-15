package InterAbs.Playlist;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration){
        this.title = title;
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "'"+this.title+"'" + " - " + this.duration;
    }
}
