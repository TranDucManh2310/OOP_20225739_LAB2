package hust.soict.dsai.test.polymorphism;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;
public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc(1,"hihi","Nhac tre", 18.5f,"Tran Duc Manh",97);
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("happy",3));
        tracks.add(new Track("i luv u",4));
        CompactDisc cd = new CompactDisc(2,"baby em o dau","that tinh",25.5f,"Nobody",tracks);
        List<String> authors = new ArrayList<String>();
        authors.add("Nobody");
        authors.add("Tran Manh");
        Book book   = new Book(3,"chuyen chung minh","teen",25.2f,authors);

        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for(Media item : mediae) {
            System.out.println(item);
        }
    }
}