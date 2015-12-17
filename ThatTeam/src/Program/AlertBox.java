package Program;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/**
 * AlertBox prompt class.
 * @author Mika Kaur
 * @version 12_16_2015
 */
public class AlertBox {

    /**
     * Display the alert prompt.
     *
     * @param title title
     * @param message message
     */
    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // blocks any user interaction until
                                                         // this window is closed
        window.setTitle(title);

        Label label = new Label(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        // Set minimum size and don't allow resizing
        window.setMinHeight(100);
        window.setMinWidth(300);
        window.setResizable(false);

        window.showAndWait();

    }

}
