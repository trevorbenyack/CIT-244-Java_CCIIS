/**
 * Name: Trevor Benyack
 * Date: 2020-05-30
 * Project: Credit Card Information Inquiry System
 */

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        CciisDataEntryPane dataEntryPane = new CciisDataEntryPane();
        GuiLogic guiLogic = new GuiLogic();

        // holds ledger list until the user saves the entire entry
        ArrayList<String[]> tempLedgerList = new ArrayList<>();

        dataEntryPane.lineItemEntryPane.btAddLineItem
                .setOnAction(event -> guiLogic.addToLedgerList(
                        tempLedgerList,
                        dataEntryPane.lineItemEntryPane.tfDescription.getText(),
                        dataEntryPane.lineItemEntryPane.tfAmount.getText(),
                        dataEntryPane.lineItemEntryPane.debitCreditToggle,
                        dataEntryPane
                ));
        dataEntryPane.btSave.setOnAction(event -> guiLogic.saveFormData(dataEntryPane));

//        // This will probably need to go into the final pane to get around private modifiers of TextFields
//        Button btSave = new Button("Save");
//        dataEntryPane.add(btSave, 1, 9);
//        gridPane.setHalignment(btSave, HPos.RIGHT);

//        // DELETE
//        TextField tfTest = new TextField();
//        gridPane.add(new Label("Branch Name Test:"), 0, 10);
//        gridPane.add(tfTest, 1, 10);
//        tfTest.setEditable(false);
//        tfTest.setAlignment(Pos.BOTTOM_RIGHT);


        // Process events
        //dataEntryPane.setOnAction(e -> saveData(gridPane, tfTest));

        Scene scene = new Scene(dataEntryPane, 400, 250);
        primaryStage.setTitle("CCIIS Data Entry"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }


    public static void main(String[] args) {
        launch(args);
    }

//    private void saveData(CcCustFinDataPane gridPane, TextField tfTest) {
//        // Get values from text fields
//
//        CcCompany ccCompany = new CcCompany();
//
//        ccCompany.setbranchName(gridPane.tfBranchName.getText());
//        tfTest.setText("hello");
//
//    }
}
