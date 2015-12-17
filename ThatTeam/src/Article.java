

/**
 * The Article Class. Stores an article and it's text.
 * 
 * @author James Brewer
 * @version 12_16_2015
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
     * @param theTitle the title
     */
    public Article(String theTitle) {
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

    /**
     * Gets text.
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Gets title of an Article.
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
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString(){
    	return getTitle();
    }

}
