import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

// this pane contains the data entry nodes
public class GUI_Pane_DataEntry extends GUI_Components {


    @Override
    public boolean isEditable() {
        return true;
    }

    // Creates upper portion of window
    HBox upperHalfPane = new HBox();
    GUI_Components.CcBranchDataEntryPane ccBranchDataEntryPane = new GUI_Components.CcBranchDataEntryPane();
    GUI_Components.CcCustomerDataEntryPane ccCustomerDataEntryPane = new GUI_Components.CcCustomerDataEntryPane();
    GUI_Components.CcCustAcctInfoDataEntryPane ccCustAcctInfoDataEntryPane = new GUI_Components.CcCustAcctInfoDataEntryPane();

    // creates lower portion of window
    BorderPane lineItemsPane = new BorderPane();
    LineItemEntryPane lineItemEntryPane = new LineItemEntryPane();
    GUI_Components.RecentLedgerItems recentLedgerItems = new GUI_Components.RecentLedgerItems();

    Button btSave = new Button("Generate Statement");

    // constructor
    public GUI_Pane_DataEntry() {

        // adds branch/customer/account data entry panes to upper half of the window
        upperHalfPane.getChildren().add(ccBranchDataEntryPane);
        upperHalfPane.getChildren().add(ccCustomerDataEntryPane);
        upperHalfPane.getChildren().add(ccCustAcctInfoDataEntryPane);

        // Upper UI: sets the three horizontal top elements to a third of the width of their parent
        ccBranchDataEntryPane.prefWidthProperty().bind(upperHalfPane.widthProperty().divide(3));
        ccCustomerDataEntryPane.prefWidthProperty().bind(upperHalfPane.widthProperty().divide(3));
        ccCustAcctInfoDataEntryPane.prefWidthProperty().bind(upperHalfPane.widthProperty().divide(3));

        // adds the ledger-item-entry pane and the recent-ledgers pane to the bottom half of the window
        lineItemsPane.setTop(lineItemEntryPane);
        lineItemsPane.setCenter(recentLedgerItems);

        this.setTop(upperHalfPane);
        this.setCenter(lineItemsPane);
        this.setBottom(btSave);
    } // end GUI_Pane_DataEntry() constructor

    public class LineItemEntryPane extends GridPane {
        TextField tfDescription = new TextField();
        TextField tfAmount = new TextField();
        TwoRadioButtons debitCreditToggle = new TwoRadioButtons("Credit", "Debit");
        HBox debitCreditPane;
        Button btAddLineItem = new Button("+");

        public LineItemEntryPane() {

            this.setHgap(10);
            this.add(new Label("Add recent ledger item:"), 0, 0);
            this.add(new Label("Description:"), 1, 0);
            this.add(tfDescription, 2, 0);
            this.add(new Label("Amount:"), 3, 0);
            this.add(tfAmount, 4, 0);
            debitCreditPane = debitCreditToggle.getTwoRadioButtonsPane();
            this.add(debitCreditPane, 5, 0);
            this.add(btAddLineItem, 6, 0);

            // UI Properties
            debitCreditPane.setAlignment(Pos.CENTER);



        } // end LineItemEntryPane() constructor

    } // end LineItemEntryPane class

    public void setNewLineItemsPane(){
        recentLedgerItems = new GUI_Components.RecentLedgerItems();
        // adds the ledger-item-entry pane and the recent-ledgers pane to the bottom half of the window
        lineItemsPane.setCenter(recentLedgerItems);
        this.setCenter(lineItemsPane);


    }

} // end GUI_Pane_DataEntry class


