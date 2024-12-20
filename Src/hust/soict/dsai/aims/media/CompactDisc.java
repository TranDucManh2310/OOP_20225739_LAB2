package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import hust.soict.dsai.aims.exception.*;

public class MusicDisc extends Disc implements Playable {
    private String artistName;
    private ArrayList<Track> trackList;

    public MusicDisc(int discId, String discTitle, String discCategory, float discCost, String artist, ArrayList<Track> tracks) {
        super(discId, discTitle, discCategory, discCost);
        this.trackList = tracks;
        this.artistName = artist;
        this.setLength(getLength());
    }

    public MusicDisc(int discId, String discTitle, String discCategory, float discCost) {
        super(discId, discTitle, discCategory, discCost);
    }

    public String getArtistName() {
        return artistName;
    }

    public void addTrackToDisc(Track track) {
        if(trackList.contains(track)) {
            System.out.println(track.getTitle() + " is already on the disc.");
        } else {
            trackList.add(track);
        }
    }

    public void removeTrackFromDisc(Track track) {
        if(trackList.contains(track)) {
            trackList.remove(track);
        } else {
            System.out.println(track.getTitle() + " is not on the disc.");
        }
    }

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    @Override
    public float getLength() {
        float totalLength = 0;
        for(Track track : trackList) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() throws PlayerException {
        if(this.getLength() < 0){
            throw new PlayerException("ERROR: CD-length is non-positive!");
        } else {
            System.out.println("\nTitle: " + getTitle() + '\n' + "Artist: " + getArtistName() + "\n\n" + "Tracks:");
            for(Track track : trackList) {
                track.play();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder printDetails = new StringBuilder("Music Disc: " +
                " [id = "  + getId() +
                ", artist: " + artistName +
                ", title = '" + getTitle() + '\'' +
                ", category = '" + getCategory() + '\'' +
                ", length : " + getLength() + " min" +
                ", cost= " + getCost() + "$]" + '\n' + "Tracks: \n"
                + "===================" + '\n');
        for (Track track : trackList) {
            printDetails.append(track.getTitle());
            printDetails.append('\t');
            printDetails.append(track.getLength());
            printDetails.append(" min");
            printDetails.append('\n');
        }
        return printDetails.toString();
    }
}
