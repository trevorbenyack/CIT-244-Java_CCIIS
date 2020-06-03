import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class scratch extends Application {

    private String loggedInUser;

    public static void main(String[] args) {
        launch(args);
    }

    // JavaFX entry point
    // How to open a new window in JavaFX
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btnLogin = new Button();
        btnLogin.setText("Login");
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showLoginScreen();
            }
        });
        // A layout container for UI controls
        StackPane root = new StackPane();
        root.getChildren().add(btnLogin);

        // Top level container for all view content
        Scene scene = new Scene(root, 300, 250);

        // primaryStage is the main top level window created by platform
        primaryStage.setTitle("JavaFX Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setLoggedInUser(String user) {
        loggedInUser = user;

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Successful login");
        alert.setHeaderText("Successful login");
        String s = user + " logged in!";
        alert.setContentText(s);
        alert.show();
    }

    public void showLoginScreen() {
        Stage stage = new Stage();

        VBox box = new VBox();
        box.setPadding(new Insets(10));

        // How to center align content in a layout manager in JavaFX
        box.setAlignment(Pos.CENTER);

        Label label = new Label("Enter username and password");

        TextField textUser = new TextField();
        textUser.setPromptText("enter user name");
        TextField textPass = new TextField();
        textPass.setPromptText("enter password");

        Button btnLogin = new Button();
        btnLogin.setText("Login");

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Assume success always!
                setLoggedInUser(textUser.getText());
                stage.close(); // return to main window
            }
        });

        box.getChildren().add(label);
        box.getChildren().add(textUser);
        box.getChildren().add(textPass);
        box.getChildren().add(btnLogin);
        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.show();
    }
}