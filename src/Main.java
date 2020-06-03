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
    CciisDataEntryPane dataEntryPane = new CciisDataEntryPane();
    CciisViewStatementPane cciisViewStatementPane = new CciisViewStatementPane();
    ArrayList<CcCustCcFinCalcs> allStatementsList = new ArrayList<>();
    ArrayList<String[]> ledgerList = new ArrayList<>();
    GuiLogic guiLogic = new GuiLogic(allStatementsList, ledgerList);
    // holds ledger list until the user saves the entire entry




    @Override
    public void start(Stage primaryStage) throws Exception{

        TabMainPane tabMainPane = new TabMainPane();

        // Process events
        dataEntryPane.lineItemEntryPane.btAddLineItem
                .setOnAction(event -> {
                    guiLogic.addToLedgerList(ledgerList, dataEntryPane);
                });
        dataEntryPane.btSave.setOnAction(event -> {
            guiLogic.saveFormData(dataEntryPane);
            guiLogic.clearFormData(dataEntryPane);
            guiLogic.viewStatement(cciisViewStatementPane, tabMainPane);
            dataEntryPane.setCenter(null);
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
        Tab tab1 = new Tab("Data Entry", dataEntryPane);
        Tab tab2 = new Tab("View Statement", cciisViewStatementPane);

        public TabMainPane() {

            this.getTabs().add(tab1);
            this.getTabs().add(tab2);
        }

    }



}
