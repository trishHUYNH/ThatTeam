import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.TableColumn.CellEditEvent;

// TODO: Add author names when complete
/**
 * Window class. Creates GUI for the program.
 * 
 * @author Mika Kaur
 * @version A
 *
 */
public class Window extends Application {

	/**
	 * JavaFX stage for the main window.
	 */
	Stage window;

	/**
	 * Library class to hold departments.
	 */
	Library library;

	/**
	 * JavaFX table to hold departments.
	 */
	TableView<Department> deptTable;

	/**
	 * JavaFX table to hold articles.
	 */
	TableView<Article> articleTable;

	/**
	 * Window layout.
	 */
	BorderPane mainLayout;

	/**
	 * Text fields for department and article additions.
	 */
	TextField deptInput, articleInput;
	
	//DanDan
    TextArea articleTextArea;

	public Window() {
		super();
		library = new Library();
	}

	public void runWindow() {
		launch();
	}

	/**
	 * Starts the GUI
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	public void start(Stage primaryStage) throws Exception {

		// Assign primary stage to window
		window = primaryStage;

		// Close window request
		window.setOnCloseRequest(e -> {
			e.consume();

			boolean answer = ConfirmBox.display("Close Program",
					"Are you sure you want to close the program?");
			if (answer)
				window.close();
		});

		/*
		 * TODO: Decide on menu bar functionality The menu section of code may
		 * become unused and will be ignored for now.
		 * 
		 * If we decide to use the menu bar and items, we will have to assign
		 * handlers to each item.
		 */

		/******* New Menu **********/
		Menu fileMenu = new Menu("File");
		// Menu newMenu = new Menu("New");
		// Menu editMenu = new Menu("Edit");

		/******* File menu items **********/
		// MenuItem newFile = new MenuItem("New...");
		// newFile.setOnAction(e -> System.out.println("Create a new File"));
		// fileMenu.getItems().add(newFile);
		//
		// MenuItem openFile = new MenuItem("Open...");
		// openFile.setOnAction(e -> System.out.println("Open a new File"));
		// fileMenu.getItems().add(openFile);
		//
		// MenuItem saveFile = new MenuItem("Save...");
		// saveFile.setOnAction(e -> System.out.println("Save new File"));
		// fileMenu.getItems().add(saveFile);
		//
		// fileMenu.getItems().add(new SeparatorMenuItem());
		//
		MenuItem settings = new MenuItem("Settings");
		settings.setOnAction(e -> System.out
				.println("Open some setting functions"));
		fileMenu.getItems().add(settings);

		fileMenu.getItems().add(new SeparatorMenuItem());

		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e -> {
			Boolean answer = ConfirmBox.display("Close Program",
					"Are you sure you want to close the program?");
			if (answer)
				window.close();
		});
		fileMenu.getItems().add(exit);

		/******* NewMenu item **********/
		// MenuItem newDept = new MenuItem("New Department");
		// newDept.setOnAction(e -> System.out.println("Creates new Dept"));
		// newMenu.getItems().add(newDept);
		//
		// MenuItem newArt = new MenuItem("New Article");
		// newArt.setOnAction(e -> System.out.println("Creates new Article"));
		// newMenu.getItems().add(newArt);

		/******* Edit menus **********/
		// MenuItem dept = new MenuItem("dept");
		// dept.setOnAction(e -> System.out.println("edit department"));
		// editMenu.getItems().add(dept);
		//
		// MenuItem article = new MenuItem("article");
		// article.setOnAction(e -> System.out.println("edit article"));
		// editMenu.getItems().add(article);
		//
		// MenuItem text = new MenuItem("text");
		// text.setOnAction(e -> System.out.println("edit text"));
		// editMenu.getItems().add(text);

		/******* Main MenuBar **********/
		MenuBar menubar = new MenuBar();
		// menubar.getMenus().addAll(fileMenu, newMenu, editMenu);
		menubar.getMenus().add(fileMenu);

		/**
		 * GRID PANE
		 */

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); // individual cells
		grid.setHgap(10);

		/**
		 * DEPARTMENT TABLE VIEW
		 */

		deptTable = new TableView<Department>();
		deptTable.setEditable(true);

		TableColumn<Department, String> deptName = new TableColumn<>(
				"Departments");

		// Sets the departments to be displayed in the table by their field
		// "title"
		deptName.setCellValueFactory(new PropertyValueFactory<>("title"));

		// Implement department table cell editing
		deptName.setCellFactory(TextFieldTableCell.forTableColumn());

		// The event handler for editing
		deptName.setOnEditCommit(new EventHandler<CellEditEvent<Department, String>>() {

			// Editing a cell changes the title of the department
			@Override
			public void handle(CellEditEvent<Department, String> d) {
				((Department) d.getTableView().getItems()
						.get(d.getTablePosition().getRow())).setTitle(d
						.getNewValue());

			}
		});

		// Set the table items here
//		deptTable.setItems(getDepartments());

		// switches between the selected departments and displays the list of
		// articles related ot department
		deptTable.getSelectionModel().selectedIndexProperty()
				.addListener(new ChangeListener<Object>() {

					@Override
					public void changed(
							@SuppressWarnings("rawtypes") ObservableValue arg0,
							Object arg1, Object arg2) {
						// TODO Auto-generated method stub
						articleTable.getItems().clear(); // clears the current
															// list
						articleTable.setItems(getArticles()); // populates the
																// articleTable
																// with selected
																// department
					}
				});

		// Table width must be set to the same as the column (or other columns
		// will show)
		deptTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		deptTable.setMinWidth(200); // Keeps table from compressing
		deptTable.getColumns().add(deptName);
		GridPane.setConstraints(deptTable, 0, 0);

		/**
		 * DEPARTMENT ADD/DELETE
		 */

		// Department name input
		deptInput = new TextField();
		deptInput.setPromptText("New Department Title...");
		GridPane.setConstraints(deptInput, 0, 2);

		// Add Department Button
		Button addDept = new Button("Add Dept");
		addDept.setOnAction(e -> {

			// Prompt if name field is empty
			if (deptInput.getText().isEmpty()) {
				AlertBox.display("Empty Department Field",
						"Please enter a department title!");
			} else {
				// Prompts user for new name of dept to add
				boolean result = ConfirmBox.display("Add Department",
						"Are you sure you would like to add \"" + ""
								+ deptInput.getText() + "\"?");
				if (result)
					deptAddButtonClicked();
			}
		});

		// Set button width to match the column width
		addDept.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(addDept, 0, 3); // Set grid space

		// Delete Department button
		Button delDept = new Button("Delete Dept");
		delDept.setOnAction(e -> {
			// Alert box if no dept is chosen to delete
			if (deptTable.getSelectionModel().isEmpty()) {
				AlertBox.display("No Department Chosen",
						"Please choose a department you would like to delete");
			} else {
				// Prompt with department name asking to delete
				boolean result = ConfirmBox.display("Delete Department",
						"Are you sure you want to delete \""
								+ deptTable.getSelectionModel()
										.getSelectedItem().getTitle() + "\"?");
				if (result)
					deptDelButtonClicked();
			}
		});

		delDept.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(delDept, 0, 4);

		/**
		 * ARTICLE TABLE VIEW
		 */

		articleTable = new TableView<Article>();
		articleTable.setEditable(true);

		TableColumn<Article, String> articleName = new TableColumn<>("Articles");

		// Sets articles to be displayed in the table by their field "title"
		articleName
				.setCellValueFactory(new PropertyValueFactory<Article, String>(
						"title"));

		// Implements Article table cell editing
		articleName.setCellFactory(TextFieldTableCell.forTableColumn());

		//DanDan
        //If one of the articles is clicked, show the article text
        articleTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	//articleTable = new TableView<Article>();
                TableView<Article> articleTable = (TableView<Article>) event.getSource();
                Article highlightedArticle = articleTable.getSelectionModel().getSelectedItem();
                articleTextArea.setText(highlightedArticle.getText());
                //System.out.println("I got it"); 
            }
        });
        
		// Event handler for editing similar to
		articleName
				.setOnEditCommit(new EventHandler<CellEditEvent<Article, String>>() {

					@Override
					public void handle(CellEditEvent<Article, String> d) {

						((Article) d.getTableView().getItems()
								.get(d.getTablePosition().getRow())).setTitle(d
								.getNewValue());
					}
				});

		// articleTable.setPrefWidth(200);
		articleTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		articleTable.setMinWidth(200);
		articleTable.getColumns().add(articleName);
		GridPane.setConstraints(articleTable, 1, 0);

		/**
		 * ARTICLE ADD/DELETE
		 */

		articleInput = new TextField();
		articleInput.setPromptText("New Article Title...");
		GridPane.setConstraints(articleInput, 1, 2);

		// Add Article Button
		Button addArticle = new Button("Add article");
		addArticle
				.setOnAction(e -> {

					Department curr = deptTable.getSelectionModel()
							.getSelectedItem();

					if (articleInput.getText().isEmpty()) {
						AlertBox.display("Empty Article Field",
								"Please enter the name of the article");
					} else if (curr == null) {
						AlertBox.display("no deparment selcted",
								"Select a department to add article or add new Department");
					} else {
						// Prompts user with new article name to add
						boolean result = ConfirmBox.display("Add Article",
								"Are you sure you would like to add \"" + ""
										+ articleInput.getText() + "\"?");
						if (result)
							artAddButtonClicked();
					}
				});

		// Set button width to match the column width
		addArticle.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(addArticle, 1, 3); // Set grid space

		// Delete Article button
		Button delArticle = new Button("Delete article");
		delArticle
				.setOnAction(e -> {
					// Alert box if no dept is chosen to delete
					if (articleTable.getSelectionModel().isEmpty()) {
						AlertBox.display("No Article Chosen",
								"Please choose an article you would like to delete");
					} else {
						// Prompt with department name asking to delete
						boolean result = ConfirmBox.display("Delete Article",
								"Are you sure you want to delete \""
										+ articleTable.getSelectionModel()
												.getSelectedItem().getTitle()
										+ "\"?");

						if (result)
							artDelButtonClicked();
					}
				});

		delArticle.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(delArticle, 1, 4);

		/**
		 * ARTICLE DISPLAY
		 */

		// Article Text Area
		// TODO: Change text area in the event of deleting an article being
		// displayed
		// TODO: Enable text editing with an "Edit Article" button, and disable
		// editing when needed
		// TODO: Set min/max height
		//TextArea artTextarea = new TextArea();
		articleTextArea = new TextArea();
		articleTextArea.setPrefHeight(700);
		articleTextArea.setMinWidth(300);
		articleTextArea.setText("Please select an article from a department.");
		articleTextArea.setWrapText(true);
		articleTextArea.setEditable(true);
		GridPane.setConstraints(articleTextArea, 2, 0);

		// Save article button
		// TODO: Implement save function
		Button saveArticle = new Button("Save Article");
        saveArticle.setOnAction(e -> {
        	if(articleTable.getSelectionModel().isEmpty()) {
        		AlertBox.display("No Article Chosen", "Please choose an article you would like to edit and save");
        	} 
        	else {
        		boolean result = ConfirmBox.display("Save Article", "Are you sure you want to save article \""
                 	  			+ articleTable.getSelectionModel().getSelectedItem().getTitle() + "\"?");
    		if (result) 
    			saveButtonClicked(deptTable.getSelectionModel().getSelectedItem(), articleTable.getSelectionModel().getSelectedItem(), articleTextArea.getText());
    		}

        });

		saveArticle.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(saveArticle, 2, 2);

		/**
		 * PUTTING THE WINDOW TOGETHER
		 */

		// Add all of the elements to the grid
		grid.getChildren().addAll(deptTable, deptInput, addDept, delDept,
				articleTable, articleInput, addArticle, delArticle,
				saveArticle, articleTextArea);

		// Create the layout and add the menu and grid
		mainLayout = new BorderPane();
		mainLayout.setTop(menubar);
		mainLayout.setCenter(grid);

		// Create the scene and add it to the window
		// TODO: Choose proper default/min/max window size
		Scene scene = new Scene(mainLayout, 750, 550);
		window.setScene(scene);

		// TODO: Pick a program title/name
		window.setTitle("That Team: Language Library");
		window.setMinWidth(750);
		window.setMinHeight(550);
		window.show();

	}

	/**
	 * BUTTON HANDLER METHODS
	 */

	/**
	 * Delete article button clicked.
	 */
	// TODO: Decide whether to compress table stuff into one line
	// TODO: Delete article(s) from the department
	private void artDelButtonClicked() {

		Article artSelected = articleTable.getSelectionModel()
				.getSelectedItem();
		articleTable.getItems().remove(artSelected);
		System.out.println("Article to delete: " + artSelected.toString());
		Department temp = null;
		List<Department> tempDept = library.getDepartment();
		for (int i = 0; i < tempDept.size(); i++) {
			temp = tempDept.get(i);
		}
		temp.removeArticle(artSelected);

	}

	/**
	 * Article add button clicked.
	 */
	// TODO: Add article to the selected department
	private void artAddButtonClicked() {

		Department curr = deptTable.getSelectionModel().getSelectedItem();
		Article article = new Article(articleInput.getText());

		articleTable.getItems().add(article);
		articleInput.clear();

		System.out.println("department name: " + curr.getTitle().toString());
		curr.getArticle();

		curr.addArticle(article);

	}

	/**
	 * Delete department button clicked.
	 */
	// TODO: Delete the department(s) from the library
	private void deptDelButtonClicked() {

		Department deptToDelete = deptTable.getSelectionModel()
				.getSelectedItem();
		deptTable.getItems().remove(deptToDelete);
		System.out.println("Department to delete: " + deptToDelete.toString());
		library.removeDepartment(deptToDelete);

	}

	/**
	 * Department add button clicked.
	 */
	private void deptAddButtonClicked() {

		Department dept = new Department(deptInput.getText());
		deptTable.getItems().add(dept);
		library.addDepartment(dept);
		deptInput.clear();

	}

	/**
	 * Gets list of articles for the selected department.
	 *
	 * @return list of articles for the selected department.
	 */
	// TODO: Get the articles from a specific department (add department
	// argument)
	private ObservableList<Article> getArticles() {
		ObservableList<Article> artList = FXCollections.observableArrayList();

		Department curr = deptTable.getSelectionModel().getSelectedItem();

		if (curr != null) {
			artList.addAll(curr.getArticle());

			for (Article art : artList) {
				articleTable.getItems().add(art);
				// System.out.println("CHECK: " + art);
			}
		}

		return artList;
	}

	/**
	 * Gets departments.
	 *
	 * @return departments
	 */
	// TODO: Get departments from the library (no method argument)
	private ObservableList<Department> getDepartments() {
		ObservableList<Department> deptList = FXCollections
				.observableArrayList();
		return deptList;
	}

    private void saveButtonClicked(Department thisDepartment, Article thisArticle, String text) {
    	int departmentIndex;
    	int articleIndex;
    	//Copies previous article title and adds new text
    	Article newArticle = new Article(thisArticle.getTitle(), text);
    	
    	if (library.departments.contains(thisDepartment)) {
    		departmentIndex = library.departments.indexOf(thisDepartment);
    		articleIndex = library.departments.get(departmentIndex).articles.indexOf(thisArticle);
    		library.departments.get(departmentIndex).articles.set(articleIndex, newArticle);
    	}
    	
    	/*
    	 * Console testing
    	 */
        System.out.println("\n----->SAVING ARTICLE<-----");
    	for(int i = 0; i < thisDepartment.articles.size(); i++) {
    	    System.out.print(thisDepartment.articles.get(i).getTitle() + " : ");
    	    System.out.println(thisDepartment.articles.get(i).getText());
    	}
    }


}
