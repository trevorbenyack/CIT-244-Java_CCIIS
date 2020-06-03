import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

// this pane contains the data entry nodes
public class CciisDataEntryPane extends GuiComponents {




    @Override
    public boolean isEditable() {
        return true;
    }

    // Creates upper portion of window
    HBox upperHalfPane = new HBox();
    GuiComponents.CcBranchDataEntryPane ccBranchDataEntryPane = new GuiComponents.CcBranchDataEntryPane();
    GuiComponents.CcCustomerDataEntryPane ccCustomerDataEntryPane = new GuiComponents.CcCustomerDataEntryPane();
    GuiComponents.CcCustAcctInfoDataEntryPane ccCustAcctInfoDataEntryPane = new GuiComponents.CcCustAcctInfoDataEntryPane();

    // creates lower portion of window
    BorderPane lineItemsPane = new BorderPane();
    LineItemEntryPane lineItemEntryPane = new LineItemEntryPane();
    GuiComponents.RecentLedgerItems recentLedgerItems = new GuiComponents.RecentLedgerItems();

    Button btSave = new Button("Save");

    // constructor
    public CciisDataEntryPane() {

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
    } // end CciisDataEntryPane() constructor

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

} // end CciisDataEntryPane class


