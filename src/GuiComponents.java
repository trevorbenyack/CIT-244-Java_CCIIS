import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GuiComponents extends BorderPane {
    
    public boolean isEditable() {
        return true;
    }

    public class CcBranchDataEntryPane extends GridPane {
        TextField tfBranchName = new TextField();
        TextField tfRoutingNum = new TextField();
        TextField tfBranchNum = new TextField();
        TextField tfBranchAddress = new TextField();
        TextField tfBranchCity = new TextField();
        TextField tfBranchState = new TextField();
        TextField tfBranchZip = new TextField();
        TextField tfBranchEmail = new TextField();
        TextField tfBranchPhone = new TextField();

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

            tfBranchName.setEditable(isEditable());
            tfRoutingNum.setEditable(isEditable());
            tfBranchNum.setEditable(isEditable());
            tfBranchAddress.setEditable(isEditable());
            tfBranchCity.setEditable(isEditable());
            tfBranchState.setEditable(isEditable());
            tfBranchZip.setEditable(isEditable());
            tfBranchEmail.setEditable(isEditable());
            tfBranchPhone.setEditable(isEditable());


        } // end CcBranchDataEntryPane constructor
    } // end CcBranchDataEntryPane class

    public class CcCustomerDataEntryPane extends GridPane {
        TextField tfCustomerName = new TextField();
        TextField tfCustomerAddress = new TextField();
        TextField tfCustomerCity = new TextField();
        TextField tfCustomerState = new TextField();
        TextField tfCustomerZip = new TextField();
        TextField tfCustomerEmail = new TextField();
        TextField tfCustomerPhone = new TextField();

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

            tfCustomerName.setEditable(isEditable());
            tfCustomerAddress.setEditable(isEditable());
            tfCustomerCity.setEditable(isEditable());
            tfCustomerState.setEditable(isEditable());
            tfCustomerZip.setEditable(isEditable());
            tfCustomerEmail.setEditable(isEditable());
            tfCustomerPhone.setEditable(isEditable());


        } // end CcCustomerDataEntryPane constructor
    } // end CcCustomerDataEntryPane class

    public class CcCustAcctInfoDataEntryPane extends GridPane {
        TextField tfAccountNum = new TextField();
        GuiComponents.TwoRadioButtons rbAccountType = new GuiComponents.TwoRadioButtons("Business", "Personal");
        HBox businessPersonalRbPane = rbAccountType.getTwoRadioButtonsPane();
        TextField tfAccountType = new TextField();
        TextField tfCreditLimit = new TextField();
        TextField tfPrevBalance = new TextField();

        // output fields
        TextField tfInterestCharge = new TextField();
        TextField tfFinalStatementBalance = new TextField();
        TextField tfNewMinPaymentAmt = new TextField();
        TextField tfRemainingCredit = new TextField();
        TextField tfOverLimitFee = new TextField();


        public CcCustAcctInfoDataEntryPane() {
            this.setHgap(5);
            this.setVgap(5);

            this.add(new Label("Account Number:"), 0, 0);
            this.add(tfAccountNum, 1, 0);
            this.add(new Label("Account Type:"), 0, 1);
            if (isEditable()) {
                this.add(businessPersonalRbPane, 1, 1);
            } else if (!isEditable()){
                this.add(tfAccountType, 1, 1);
                tfAccountType.setEditable(isEditable());
            }
            this.add(new Label("Account Credit Limit:"), 0, 2);
            this.add(tfCreditLimit, 1, 2);
            this.add(new Label("Account Prev Balance:"), 0, 3);
            this.add(tfPrevBalance, 1, 3);
            if(!isEditable()){
                // adds calculation output fields to view
                this.add(new Label("Interest Charge:"), 0, 4);
                this.add(tfInterestCharge, 1, 4);
                this.add(new Label("Statement Balance:"), 0, 5);
                this.add(tfFinalStatementBalance, 1, 5);
                this.add(new Label("Minimum Payment Due:"), 0, 6);
                this.add(tfNewMinPaymentAmt, 1, 6);
                this.add(new Label("Remaining Credit:"), 0, 7);
                this.add(tfRemainingCredit, 1, 7);
                this.add(new Label("Over-Limit Fee:"), 0, 8);
                this.add(tfOverLimitFee, 1, 8);
            }


            this.setStyle("-fx-background-color: lightblue;");

            // Set properties for UI
            this.setAlignment(Pos.TOP_LEFT);
            tfAccountNum.setAlignment(Pos.BOTTOM_LEFT);
            businessPersonalRbPane.setAlignment(Pos.BOTTOM_LEFT);
            tfCreditLimit.setAlignment(Pos.BOTTOM_LEFT);
            tfPrevBalance.setAlignment(Pos.BOTTOM_LEFT);

            tfAccountNum.setEditable(isEditable());
            tfCreditLimit.setEditable(isEditable());
            tfPrevBalance.setEditable(isEditable());
            tfInterestCharge.setEditable((isEditable()));
            tfFinalStatementBalance.setEditable((isEditable()));
            tfNewMinPaymentAmt.setEditable(isEditable());
            tfRemainingCredit.setEditable(isEditable());
            tfOverLimitFee.setEditable(isEditable());

            System.out.println(isEditable());


        } // end CcCustAcctInfoDataEntryPane constructor
    }  // end CcCustAcctInfoDataEntryPane class

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


}
