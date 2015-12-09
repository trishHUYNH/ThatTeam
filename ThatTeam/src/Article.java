import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Article.
 */
public class Article {

    /**
     * title.
     */
    private String title;
    
    /**
     * text.
     */
    private String text;
    
    /**
     * keywords.
     */
    private ArrayList<String> keywords;

    /**
     * Constructs a new Article object with only the title.
     *
     * @param theTitle the title
     */
    public Article(String theTitle) {
        // TODO Auto-generated constructor stub
        this.title = theTitle;
        this.text = "";
    }

    /**
     * Constructs a new Article object with title and text.
     *
     * @param theTitle the title
     * @param theText the text
     */
    public Article(String theTitle, String theText) {
        this.title = theTitle;
        this.text = theText;
    }
    
    /*
     * Copy constructor for Article object. Used for saving articles.
     */
    public Article(Article copyArticle) {
    	this.title = copyArticle.title;
    	this.text = copyArticle.text;
    }

    /**
     * Gets text.
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Gets title.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Edits the text.
     *
     * @param newText new text
     */
    public void editText(String newText) {
        this.text = newText;
    }

    /**
     * Sets title.
     *
     * @param newTitle becomes the new title.
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    //TODO: Add/Remove search function in program as extra feature
    /**
     * Search text.
     *
     * @param theKeyword the keyword
     * @return true, if successful
     */
    public boolean searchText(String theKeyword) {
        return keywords.contains(theKeyword);
    }

}
