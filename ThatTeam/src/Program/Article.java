package Program;


/**
 * The Article Class. Stores an article and it's text.
 * 
 * @author James Brewer
 * @version 12_17_2015
 */
public class Article {

    /**
     * Article title.
     */
    private String title;
    
    /**
     * Article text.
     */
    private String text;
    
    /**
     * Constructs a new Article object with only the title.
     *
     * @author James Brewer
     * @param theTitle the title
     */
    public Article(String theTitle) {
        this.title = theTitle;
        this.text = "";
    }

    /**
     * Constructs a new Article object with title and text.
     *
     * @author James Brewer
     * @param theTitle the title
     * @param theText the text
     */
    public Article(String theTitle, String theText) {
        this.title = theTitle;
        this.text = theText;
    }

    /**
     * Gets text.
     *
     * @author James Brewer
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Gets title of an Article.
     *
     * @author James Brewer
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Edits the text.
     *
     * @author James Brewer
     * @param newText new text
     */
    public void editText(String newText) {
        this.text = newText;
    }

    /**
     * Sets title.
     *
     * @author James Brewer
     * @param newTitle becomes the new title.
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    
    /**
     * Give article title for toString
     * 
     * @author James Brewer
     * @return the article title
     */
    public String toString(){
    	return getTitle();
    }

}
