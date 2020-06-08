import javafx.scene.layout.*;

// this pane contains the data entry nodes
public class GUI_Pane_Statement extends GUI_Components {

    @Override
    public boolean isEditable() {
        return false;
    }

    // Creates upper portion of window
    HBox upperHalfPane = new HBox();
    GUI_Components.CcBranchDataEntryPane ccBranchDataEntryPane = new GUI_Components.CcBranchDataEntryPane();
    GUI_Components.CcCustomerDataEntryPane ccCustomerDataEntryPane = new GUI_Components.CcCustomerDataEntryPane();
    GUI_Components.CcCustAcctInfoDataEntryPane ccCustAcctInfoDataEntryPane = new GUI_Components.CcCustAcctInfoDataEntryPane();

    // creates lower portion of window
    BorderPane lineItemsPane = new BorderPane();
    GUI_Components.RecentLedgerItems recentLedgerItems = new GUI_Components.RecentLedgerItems();


    // constructor
    public GUI_Pane_Statement() {

        // adds branch/customer/account data entry panes to upper half of the window
        upperHalfPane.getChildren().add(ccBranchDataEntryPane);
        upperHalfPane.getChildren().add(ccCustomerDataEntryPane);
        upperHalfPane.getChildren().add(ccCustAcctInfoDataEntryPane);

        // Upper UI: sets the three horizontal top elements to a third of the width of their parent
        ccBranchDataEntryPane.prefWidthProperty().bind(upperHalfPane.widthProperty().divide(3));
        ccCustomerDataEntryPane.prefWidthProperty().bind(upperHalfPane.widthProperty().divide(3));
        ccCustAcctInfoDataEntryPane.prefWidthProperty().bind(upperHalfPane.widthProperty().divide(3));

        // adds the ledger-item-entry pane and the recent-ledgers pane to the bottom half of the window
        lineItemsPane.setCenter(recentLedgerItems);

        this.setTop(upperHalfPane);
        this.setCenter(lineItemsPane);
    } // end GUI_Pane_DataEntry() constructor

} // end GUI_Pane_DataEntry class


