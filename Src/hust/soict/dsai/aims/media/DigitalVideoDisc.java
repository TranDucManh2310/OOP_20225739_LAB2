package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

public class MovieDisc extends Disc implements Playable {
    public MovieDisc(int discId, String discTitle, String discCategory, float discCost , String directorName, float discLength){
        super(discId, discTitle, discCategory, discCost, directorName, discLength);
    }

    public MovieDisc(int discId, String discTitle, String discCategory, float discCost){
        super(discId, discTitle, discCategory, discCost);
    }

    public void play() throws PlayerException {
        if (this.getLength() < 0){
            throw new PlayerException("ERROR: Movie-disc length is non-positive!");
        } else {
            System.out.println("Playing movie disc: " + this.getTitle());
            System.out.println("Movie disc length: " + this.getLength());
        }
    }
}
