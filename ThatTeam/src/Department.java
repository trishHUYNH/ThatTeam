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
    private ArrayList<Article> articles;

    /**
     * Constructs a new Department object.
     *
     * @param theTitle the title
     */
    public Department(String theTitle) {
        this.title = theTitle;
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

//    /**
//     * Edits the article title.
//     *
//     * @param newTitle new title
//     */
//    public void editArticleTitle(String newTitle) {
//
//    }

}
