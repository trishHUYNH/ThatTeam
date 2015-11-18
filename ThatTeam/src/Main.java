import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.TableColumn.CellEditEvent;

public class Main extends Application {
	Stage window;
	TableView<Library> deptTable;
	TableView<Department> articleTable;
	BorderPane mainLayout;
	TextField deptInput, articleInput;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		// confirm to close window
		window.setOnCloseRequest(e -> {
			e.consume(); // user request to close but we going to take care of
			// it so it doesn't close even if you say no to exit

			Boolean answer = ConfirmBox.display("Close Program",
					"Are you sure you want to close the program?");
			if (answer)
				window.close();
		});

		/******* New Menu **********/
		Menu fileMenu = new Menu("File");
		Menu newMenu = new Menu("New");
		Menu editMenu = new Menu("Edit");

		/******* File menu items **********/
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a new File"));
		fileMenu.getItems().add(newFile);

		MenuItem openFile = new MenuItem("Open...");
		openFile.setOnAction(e -> System.out.println("Open a new File"));
		fileMenu.getItems().add(openFile);

		MenuItem saveFile = new MenuItem("Save...");
		saveFile.setOnAction(e -> System.out.println("Save new File"));
		fileMenu.getItems().add(saveFile);

		fileMenu.getItems().add(new SeparatorMenuItem());

		MenuItem settings = new MenuItem("settings...");
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
		MenuItem newDept = new MenuItem("New Department...");
		newDept.setOnAction(e -> System.out.println("Creates new Dept"));
		newMenu.getItems().add(newDept);

		MenuItem newArt = new MenuItem("New Article...");
		newArt.setOnAction(e -> System.out.println("Creates new Article"));
		newMenu.getItems().add(newArt);

		/******* Edit menus **********/
		MenuItem dept = new MenuItem("dept");
		dept.setOnAction(e -> System.out.println("edit department"));
		editMenu.getItems().add(dept);

		MenuItem article = new MenuItem("article");
		article.setOnAction(e -> System.out.println("edit article"));
		editMenu.getItems().add(article);

		MenuItem text = new MenuItem("text");
		text.setOnAction(e -> System.out.println("edit text"));
		editMenu.getItems().add(text);

		/******* Main MenuBar **********/
		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(fileMenu, newMenu, editMenu);

		/********* GRID PANE *************/
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); // individual cells
		grid.setHgap(10);

		/********** Display list of articles *********/
//
//		// article text field
//		TextField listOfArticles = new TextField();
//		listOfArticles.setPrefHeight(400);
//		listOfArticles.setAlignment(Pos.TOP_LEFT);
//		listOfArticles.setPromptText("List of articles");
//		GridPane.setConstraints(listOfArticles, 1, 0);
//
//		Button addArt = new Button("Add article");
//		GridPane.setConstraints(addArt, 1, 1);


		/********** DEPARTMENT TABLE VIEW ***********/
		deptTable = new TableView<Library>();
		deptTable.setEditable(true);

		TableColumn<Library, String> deptName = new TableColumn<>("Departments");
		deptName.setMinWidth(200);
		deptName.setCellValueFactory(new PropertyValueFactory<>("department"));
		
		//Implement department table cell editing
		deptName.setCellFactory(TextFieldTableCell.forTableColumn());
		deptName.setOnEditCommit(new EventHandler<CellEditEvent<Library, String>>() {

			@Override
			public void handle(CellEditEvent<Library, String> d) {
				((Library) d.getTableView().getItems()
						.get(d.getTablePosition().getRow())).setDepartment(d
								.getNewValue());
			}

		});

		deptTable.setItems(getLibrary());
		deptTable.setPrefWidth(200);
		deptTable.getColumns().add(deptName);
		GridPane.setConstraints(deptTable, 0, 0);
		
		// department name input;
		deptInput = new TextField();
		deptInput.setPromptText("Department");
		GridPane.setConstraints(deptInput, 0, 2);

		// Add Department Button
		Button addDept = new Button("Add Dept");
		addDept.setOnAction(e -> {
			if (deptInput.getText().isEmpty()) {
				AlertBox.display("Empty Field",
						"Please enter the name of the Dept");
			} else {
				boolean result = ConfirmBox.display("Add Department",
						"Are you sure?");
				if (result)
					addDeptButtonClicked();
			}
		});
		addDept.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(addDept, 0, 3);

		// Delete Department button
		Button delDept = new Button("Delete Dept");
		delDept.setOnAction(e -> {
			boolean result = ConfirmBox.display("Delete Department",
					"Are you sure?");
			if (result)
				delDeptButtonClicked();
		});
		
		delDept.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(delDept, 0, 4);

		/********** ARTICLE TABLE VIEW ***********/
		articleTable = new TableView<Department>();
		articleTable.setEditable(true);

		TableColumn<Department, String> articleName = new TableColumn<>(
				"Articles");
		articleName.setMinWidth(200);
		articleName
		.setCellValueFactory(new PropertyValueFactory<Department, String>(
				"article"));

		//Implements Article table cell editing
		articleName.setCellFactory(TextFieldTableCell.forTableColumn());
		articleName
		.setOnEditCommit(new EventHandler<CellEditEvent<Department, String>>() {

			@Override
			public void handle(CellEditEvent<Department, String> d) {
				((Department) d.getTableView().getItems()
						.get(d.getTablePosition().getRow()))
						.setArticle(d.getNewValue());
			}

		});

		articleTable.setItems(getArticles());
		articleTable.setPrefWidth(200);
		articleTable.getColumns().add(articleName);
		GridPane.setConstraints(articleTable, 1, 0);

		// article name input;
		articleInput = new TextField();
		articleInput.setPromptText("Article");
		GridPane.setConstraints(articleInput, 1, 2);
		
		// Add Article Button
		Button addArticle = new Button("Add article");
		addArticle.setOnAction(e -> {

			if (articleInput.getText().isEmpty()) {
				AlertBox.display("Empty Field",
						"Please enter the name of the article");
			} else {
				boolean result = ConfirmBox.display("Add Article",
						"Are you sure?");
				if (result)
					addArtButtonClicked();
			}
		});

		addArticle.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(addArticle, 1, 3);

		// Delete Article button
		Button delArticle = new Button("Delete article");
		delArticle.setOnAction(e -> {
			boolean result = ConfirmBox.display("Delete Article",
					"Are you sure?");
			if (result)
				delArtButtonClicked();
		});
		delArticle.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(delArticle, 1, 4);

		/************* Display Selected Article *********/

		// article text field
		TextField artTextfield = new TextField();
		artTextfield.setPrefHeight(400);
		artTextfield.setAlignment(Pos.TOP_LEFT);
		artTextfield.setPromptText("Seletected Article");
		GridPane.setConstraints(artTextfield, 2, 0);
		
		
		// Save article button
		Button saveArticle = new Button("Copy/Save Article??");
		saveArticle.setOnAction(e -> {
			AlertBox.display("Delete Article", "It should copy or save,"
					+ " i forgot what exactly we wanted to do with it");

		});
		saveArticle.setMaxWidth(Double.MAX_VALUE);
		GridPane.setConstraints(saveArticle, 2, 2);

		grid.getChildren().addAll(deptTable, deptInput, addDept, delDept,
				articleTable, articleInput, addArticle, delArticle,
				artTextfield, saveArticle);

		mainLayout = new BorderPane();
		mainLayout.setTop(menubar);
		mainLayout.setCenter(grid);

		Scene scene = new Scene(mainLayout, 600, 600);
		window.setScene(scene);
		window.setTitle("ThatTeam");
		window.show();

	}

	// delete article button
	private void delArtButtonClicked() {
		ObservableList<Department> artSelected;
		ObservableList<Department> allArts;
		allArts = articleTable.getItems();
		artSelected = articleTable.getSelectionModel().getSelectedItems();

		artSelected.forEach(allArts::remove); // remove selected from all depts
	}

	// add article button
	private void addArtButtonClicked() {
		Department article = new Department();
		article.setArticle(articleInput.getText());
		articleTable.getItems().add(article);
		articleInput.clear();
	}

	// delete department button
	private void delDeptButtonClicked() {
		ObservableList<Library> deptSelected, allDepts;
		allDepts = deptTable.getItems();
		deptSelected = deptTable.getSelectionModel().getSelectedItems();

		deptSelected.forEach(allDepts::remove); // remove selected from all
		// depts
	}

	// add department button
	private void addDeptButtonClicked() {
		Library library = new Library();
		library.setDepartment(deptInput.getText());
		deptTable.getItems().add(library);
		deptInput.clear();
	}

	// get list of articles and adds it to the table
	private ObservableList<Department> getArticles() {
		ObservableList<Department> articles = FXCollections
				.observableArrayList();
		articles.add(new Department("abc"));
		articles.add(new Department("efg"));
		return articles;
	}

	// get list of departments and adds it to the table
	public ObservableList<Library> getLibrary() {
		ObservableList<Library> library = FXCollections.observableArrayList();
		library.add(new Library("Hr"));
		library.add(new Library("legal"));
		return library;
	}
}
