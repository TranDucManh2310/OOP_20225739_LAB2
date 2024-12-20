package hust.soict.dsai.aims.media;
public class VideoDisc extends Media {
    private String directorName;
    private float discLength;

    public VideoDisc(int discId, String discTitle, String discCategory, float discCost, String directorName, float discLength) {
        super(discId, discTitle, discCategory, discCost);
        this.directorName = directorName;
        this.discLength = discLength;
    }

    public VideoDisc(int discId, String discTitle, String discCategory, float discCost) {
        super(discId, discTitle, discCategory, discCost);
    }

    public String getDirectorName() { return directorName; }

    public float getDiscLength() { return discLength; }

    public void setDiscLength(float discLength) {
        this.discLength = discLength;
    }

    @Override
    public String toString() {
        return "Video Disc: " +
                " [id = "  + getId() +
                ", title = '" + getTitle() + '\'' +
                ", category = '" + getCategory() + '\'' +
                ", director: " + getDirectorName() +
                ", length = " + getDiscLength() + ", cost= " + getCost() + "$]";
    }
}
