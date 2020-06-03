import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

// this pane contains the data entry nodes
public class CciisViewStatementPane extends GuiComponents {

    @Override
    public boolean isEditable() {
        return false;
    }

    // Creates upper portion of window
    HBox upperHalfPane = new HBox();
    GuiComponents.CcBranchDataEntryPane ccBranchDataEntryPane = new GuiComponents.CcBranchDataEntryPane();
    GuiComponents.CcCustomerDataEntryPane ccCustomerDataEntryPane = new GuiComponents.CcCustomerDataEntryPane();
    GuiComponents.CcCustAcctInfoDataEntryPane ccCustAcctInfoDataEntryPane = new GuiComponents.CcCustAcctInfoDataEntryPane();

    // creates lower portion of window
    BorderPane lineItemsPane = new BorderPane();
    GuiComponents.RecentLedgerItems recentLedgerItems = new GuiComponents.RecentLedgerItems();


    // constructor
    public CciisViewStatementPane() {

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
    } // end CciisDataEntryPane() constructor

} // end CciisDataEntryPane class


