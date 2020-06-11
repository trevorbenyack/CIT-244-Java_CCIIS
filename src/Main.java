/**
 * Name: Trevor Benyack
 * Date: 2020-05-30
 * Project: Credit Card Information Inquiry System
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    GUI_Pane_DataEntry guiPaneDataEntry = new GUI_Pane_DataEntry();
    GUI_Pane_Statement guiPaneStatement = new GUI_Pane_Statement();

    // This array holds all of the Statement instances. It's here for future expansion of the program (e.g. retrieving
    // individual past statements).
    ArrayList<CcStatement> allStatementsList = new ArrayList<>();

    // holds the ledger list during data entry. Once the user presses "save", the data is then added to the Statement
    // instance and tempLedgerList is cleared so it can be used for the next statement entry.
    ArrayList<String[]> tempLedgerList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{

        // creates tabbed interface for the program
        TabMainPane tabMainPane = new TabMainPane();

        // Processes events
        guiPaneDataEntry.lineItemEntryPane.btAddLineItem
                .setOnAction(event -> {
                    GUI_Logic.addToLedgerList(tempLedgerList, guiPaneDataEntry);
                });
        guiPaneDataEntry.btSave.setOnAction(event -> {
            GUI_Logic.saveFormData(guiPaneDataEntry, allStatementsList, tempLedgerList);
            GUI_Logic.clearFormData(guiPaneDataEntry);
            GUI_Logic.viewStatement(guiPaneStatement, tabMainPane, allStatementsList);
            guiPaneDataEntry.setNewLineItemsPane();
            tempLedgerList = new ArrayList<>();
        });


        Scene scene = new Scene(tabMainPane, 1000, 1000);
        primaryStage.setTitle("Credit Card Information Data Entry"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    public static void main(String[] args) {
        launch(args);
    }

    public class TabMainPane extends TabPane {
        Tab tab1 = new Tab("Data Entry", guiPaneDataEntry);
        Tab tab2 = new Tab("View CcStatement", guiPaneStatement);

        public TabMainPane() {

            this.getTabs().add(tab1);
            this.getTabs().add(tab2);
        }

    }
}
