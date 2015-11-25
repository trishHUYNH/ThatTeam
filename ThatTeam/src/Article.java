import java.util.ArrayList;

public class Article {
    
    private String title;
    private String text;
    private ArrayList<String> keywords;

    public Article(String theTitle) {
        // TODO Auto-generated constructor stub
        this.title = theTitle;
        this.text = "";
    }
    
    public Article(String theTitle, String theText) {
        this.title = theTitle;
        this.text = theText;
    }
    
    public String getText() {
        return text;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void editText(String newText) {
        this.text = newText;
    }
    
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    
    public boolean searchText(String theKeyword) {
        return keywords.contains(theKeyword);
    }

}
