package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Department class. Stores a group of articles under that department.
 * @author Mika Kaur, James Brewer
 * @version 12_17_2015
 */
public class Department {

	/**
	 * Title of the department.
	 */
	private String title;

	/**
	 * List of articles.
	 */
	public ArrayList<Article> articles;

	/**
	 * Constructs a new Department object.
	 *
	 * @author James Brewer
	 * @param theTitle
	 *            the title
	 */
	public Department(String theTitle) {
		this.title = theTitle;
		articles = new ArrayList<Article>();
	}

	/**
	 * Sets title.
	 *
	 * @author James Brewer
	 * @param newTitle
	 *            becomes the new title.
	 */
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	/**
	 * Gets title.
	 * 
	 * @author James Brewer
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets article.
	 *
	 * @author James Brewer
	 * @param index
	 *            index
	 * @return article
	 */
	public Article getArticle(int index) {
		return articles.get(index);
	}

	/**
	 * Gets the list of all articles within the department.
	 *
	 * @author James Brewer
	 * @return the article
	 */
	public List<Article> getArticle() {
		List<Article> list = (ArrayList<Article>) articles.stream().collect(
				Collectors.toList());

		return list;

	}

	/**
	 * Adds an article.
	 *
	 * @author James Brewer
	 * @param article
	 *            the article
	 */
	public void addArticle(Article article) {

		articles.add(article);

	}
	
	/**
	 * Removes the article from selected department.
	 *
	 * @author Mika Kaur
	 * @param article the article to remove
	 */
	public void removeArticle(Article article) {

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).equals(article)) {
				articles.remove(article);
				break;
			}
		}

	}
	
	/**
	 * When called on as a string, return the title
	 * 
	 * @return department title
	 */
	public String toString() {
	    return title;
	}

}
