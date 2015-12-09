import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Department.
 */
public class Department {

    /**
     * title.
     */
    private String title;

    /**
     * articles.
     */
    public ArrayList<Article> articles;

    /**
     * Constructs a new Department object.
     *
     * @param theTitle the title
     */
    public Department(String theTitle) {
        this.title = theTitle;
        articles = new ArrayList<Article>();
    }

    /**
     * Sets title.
     *
     * @param newTitle becomes the new title.
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
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
     * Gets article.
     *
     * @param index index
     * @return article
     */
    public Article getArticle(int index) {
        return articles.get(index);
    }
    
    /*
     * Do this!
     */
    public void addArticle(Article newArticle) {
    	articles.add(newArticle);
    }

}
