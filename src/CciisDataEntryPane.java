import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

// this pane contains the data entry nodes
public class CciisDataEntryPane extends BorderPane {

    // Creates upper portion of window
    HBox upperHalfPane = new HBox();
    CcBranchDataEntryPane ccBranchDataEntryPane = new CcBranchDataEntryPane();
    CcCustomerDataEntryPane ccCustomerDataEntryPane = new CcCustomerDataEntryPane();
    CcCustAcctInfoDataEntryPane ccCustAcctInfoDataEntryPane = new CcCustAcctInfoDataEntryPane();

    // creates lower portion of window
    BorderPane lineItemsPane = new BorderPane();
    LineItemEntryPane lineItemEntryPane = new LineItemEntryPane();
    RecentLedgerItems recentLedgerItems = new RecentLedgerItems();

    Button btSave = new Button();

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

    public class CcBranchDataEntryPane extends GridPane {
        private TextField tfBranchName = new TextField();
        private TextField tfRoutingNum = new TextField();
        private TextField tfBranchNum = new TextField();
        private TextField tfBranchAddress = new TextField();
        private TextField tfBranchCity = new TextField();
        private TextField tfBranchState = new TextField();
        private TextField tfBranchZip = new TextField();
        private TextField tfBranchEmail = new TextField();
        private TextField tfBranchPhone = new TextField();

        public CcBranchDataEntryPane() {
            this.setHgap(5);
            this.setVgap(5);

            this.add(new Label("Branch Name:"), 0, 0);
            this.add(tfBranchName, 1, 0);
            this.add(new Label("Branch Routing Number:"), 0, 1);
            this.add(tfRoutingNum, 1, 1);
            this.add(new Label("Branch ID Number:"), 0, 2);
            this.add(tfBranchNum, 1, 2);
            this.add(new Label("Branch Address:"), 0, 3);
            this.add(tfBranchAddress, 1, 3);
            this.add(new Label("Branch City:"), 0, 4);
            this.add(tfBranchCity, 1, 4);
            this.add(new Label("Branch State"), 0, 5);
            this.add(tfBranchState, 1, 5);
            this.add(new Label("Branch Zip:"), 0, 6);
            this.add(tfBranchZip, 1, 6);
            this.add(new Label("Branch Email:"), 0, 7);
            this.add(tfBranchEmail, 1, 7);
            this.add(new Label("Branch Phone:"), 0, 8);
            this.add(tfBranchPhone, 1, 8);

            this.setStyle("-fx-background-color: lightyellow;");

            // Set properties for UI
            this.setAlignment(Pos.TOP_LEFT);
            tfBranchName.setAlignment(Pos.BOTTOM_RIGHT);
            tfRoutingNum.setAlignment(Pos.BOTTOM_RIGHT);
            tfBranchNum.setAlignment(Pos.BOTTOM_RIGHT);
            tfBranchAddress.setAlignment(Pos.BOTTOM_RIGHT);
            tfBranchCity.setAlignment(Pos.BOTTOM_RIGHT);
            tfBranchState.setAlignment(Pos.BOTTOM_RIGHT);
            tfBranchZip.setAlignment(Pos.BOTTOM_RIGHT);
            tfBranchEmail.setAlignment(Pos.BOTTOM_RIGHT);
            tfBranchPhone.setAlignment(Pos.BOTTOM_RIGHT);

        } // end CcBranchDataEntryPane constructor
    } // end CcBranchDataEntryPane class

    public class CcCustomerDataEntryPane extends GridPane {
        private TextField tfCustomerName = new TextField();
        private TextField tfCustomerAddress = new TextField();
        private TextField tfCustomerCity = new TextField();
        private TextField tfCustomerState = new TextField();
        private TextField tfCustomerZip = new TextField();
        private TextField tfCustomerEmail = new TextField();
        private TextField tfCustomerPhone = new TextField();

        public CcCustomerDataEntryPane() {
            this.setHgap(5);
            this.setVgap(5);

            this.add(new Label("Customer Name:"), 0, 0);
            this.add(tfCustomerName, 1, 0);
            this.add(new Label("Customer Address:"), 0, 1);
            this.add(tfCustomerAddress, 1, 1);
            this.add(new Label("Customer City:"), 0, 2);
            this.add(tfCustomerCity, 1, 2);
            this.add(new Label("Customer State:"), 0, 3);
            this.add(tfCustomerState, 1, 3);
            this.add(new Label("Customer Zip"), 0, 4);
            this.add(tfCustomerZip, 1, 4);
            this.add(new Label("Customer Email:"), 0, 5);
            this.add(tfCustomerEmail, 1, 5);
            this.add(new Label("Customer Phone:"), 0, 6);
            this.add(tfCustomerPhone, 1, 6);

            this.setStyle("-fx-background-color: lightpink;");

            // Set properties for UI
            this.setAlignment(Pos.TOP_LEFT);
            tfCustomerName.setAlignment(Pos.BOTTOM_RIGHT);
            tfCustomerAddress.setAlignment(Pos.BOTTOM_RIGHT);
            tfCustomerCity.setAlignment(Pos.BOTTOM_RIGHT);
            tfCustomerState.setAlignment(Pos.BOTTOM_RIGHT);
            tfCustomerZip.setAlignment(Pos.BOTTOM_RIGHT);
            tfCustomerEmail.setAlignment(Pos.BOTTOM_RIGHT);
            tfCustomerPhone.setAlignment(Pos.BOTTOM_RIGHT);

        } // end CcCustomerDataEntryPane constructor
    } // end CcCustomerDataEntryPane class

    public class CcCustAcctInfoDataEntryPane extends GridPane {
        private TextField tfAccountNum = new TextField();
        private TextField tfAccountType = new TextField();
        private TextField tfCreditLimit = new TextField();
        private TextField tfPrevBalance = new TextField();

        public CcCustAcctInfoDataEntryPane() {
            this.setHgap(5);
            this.setVgap(5);

            this.add(new Label("Account Number:"), 0, 0);
            this.add(tfAccountNum, 1, 0);
            this.add(new Label("Account Type:"), 0, 1);
            this.add(tfAccountType, 1, 1);
            this.add(new Label("Account Credit Limit:"), 0, 2);
            this.add(tfCreditLimit, 1, 2);
            this.add(new Label("Account Prev Balance:"), 0, 3);
            this.add(tfPrevBalance, 1, 3);

            this.setStyle("-fx-background-color: lightblue;");

            // Set properties for UI
            this.setAlignment(Pos.TOP_LEFT);
            tfAccountNum.setAlignment(Pos.BOTTOM_LEFT);
            tfAccountType.setAlignment(Pos.BOTTOM_LEFT);
            tfCreditLimit.setAlignment(Pos.BOTTOM_LEFT);
            tfPrevBalance.setAlignment(Pos.BOTTOM_LEFT);

        } // end CcCustAcctInfoDataEntryPane constructor
    }  // end CcCustAcctInfoDataEntryPane class

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

    public class RecentLedgerItems extends VBox {
        public RecentLedgerItems(){
        }

        GridPane ledgerGrid = new GridPane();

        public void printLedgerList(ArrayList<String[]> ledgerList) {
            int i = 1;

            for (String[] lineItem : ledgerList) {
                for (String element :lineItem) {
                    this.getChildren().remove(ledgerGrid);
                    ledgerGrid.add(new Text("Line Item Description: "), 0, 0);
                    ledgerGrid.add(new Text("Amount: "), 1, 0);
                    ledgerGrid.add(new Text(lineItem[0]), 0, i);
                    ledgerGrid.add(new Text(lineItem[1]), 1, i);
                    this.getChildren().add(ledgerGrid);
                }
                i++;
            }

        }

    } // end RecentLedgerItems

    public class TwoRadioButtons extends ToggleGroup {

        HBox twoRadioButtonsPane = new HBox();
        ToggleGroup twoRadioButtons = new ToggleGroup();
        RadioButton rbLabel01;
        RadioButton rbLabel02;

        public TwoRadioButtons(String label01, String label02){
            this.rbLabel01 = new RadioButton(label01);
            this.rbLabel02 = new RadioButton(label02);

            rbLabel01.setToggleGroup(twoRadioButtons);
            rbLabel02.setToggleGroup(twoRadioButtons);

            rbLabel01.setSelected(true);

            twoRadioButtonsPane.getChildren().addAll(rbLabel01, rbLabel02);

        }

        public HBox getTwoRadioButtonsPane() {
            twoRadioButtonsPane.setSpacing(5);
            return twoRadioButtonsPane;
        }
    }

} // end CciisDataEntryPane class


