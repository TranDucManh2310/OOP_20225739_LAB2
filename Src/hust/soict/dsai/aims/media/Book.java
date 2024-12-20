package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Novel extends Media {
    private List<String> authorsList = new ArrayList<String>();

    public Novel(int bookId, String bookTitle, String bookCategory, float bookCost, List<String> authors) {
        super(bookId, bookTitle, bookCategory, bookCost);
        this.authorsList = authors;
    }

    public Novel(int bookId, String bookTitle, String bookCategory, float bookCost){
        super(bookId, bookTitle, bookCategory, bookCost);
    }

    public List<String> getAuthorsList(){
        return authorsList;
    }

    public void setAuthorsList(List<String> authors){
        this.authorsList = authors;
    }
    public void addAuthorToList(String authorName){
        if(authorsList.contains(authorName)){
            System.out.println(authorName + " is already in the author list.");
        }else{
            authorsList.add(authorName);
        }
    }

    public void removeAuthorFromList(String authorName){
        if(authorsList.contains(authorName)){
            authorsList.remove(authorName);
        } else{
            System.out.println(authorName + " is not in the author list.");
        }
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder("Novel: " +
                " [id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", authors: ");
        for(String author : authorsList){
            description.append(author);
            description.append(" ");
        }
        description.append(", cost:");
        description.append(getCost());
        description.append("$]");
        return description.toString();
    }
}
