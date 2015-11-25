import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;


public class AlertBox {
	
	public static void display(String title, String message){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL); //blocks any user interaction until this window is closed
		window.setTitle(title);
		
		Label label = new Label(message);
		Button closeButton = new Button("close");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
}
