import java.math.BigDecimal;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GuiLogic{

    CciisDataEntryPane dataEntryPane;
    ArrayList<CcCustCcFinCalcs> allStatementsList;
    ArrayList<String[]> ledgerList = new ArrayList<>();

    public GuiLogic(ArrayList<CcCustCcFinCalcs> allStatementsList, ArrayList<String[]> ledgerList){
        this.allStatementsList = allStatementsList;
        this.ledgerList = ledgerList;
    }

    private int lastStatementId = 0;

    // adds a line item to ledgerList
    public void addToLedgerList(
            ArrayList<String[]> ledgerList,
            CciisDataEntryPane dataEntryPane) {

        String description = dataEntryPane.lineItemEntryPane.tfDescription.getText();
        String amount = dataEntryPane.lineItemEntryPane.tfAmount.getText();
        CciisDataEntryPane.TwoRadioButtons debitCreditToggle = dataEntryPane.lineItemEntryPane.debitCreditToggle;

        String[] lineItem = new String[2];
        lineItem[0] = description;

        if (debitCreditToggle.rbLabel01.isSelected() ) {
            lineItem[1] = amount;
            System.out.println("credit");
        }
        if (debitCreditToggle.rbLabel02.isSelected()) {
            lineItem[1] = "-" + amount;
            System.out.println("debit");

        }

        ledgerList.add(lineItem);
        System.out.println(ledgerList.get(0)[0] + " " + ledgerList.get(0)[0]);

        dataEntryPane.recentLedgerItems.printLedgerList(ledgerList);

    } //end addToLedgerList method

    public void saveFormData(CciisDataEntryPane dataEntryPane){

        if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel01.isSelected()) {
            allStatementsList.add(new CcCustCcFinCalcs(new CcCustBusinessRatesFees(), ledgerList));
        } else if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel02.isSelected()) {
            allStatementsList.add(new CcCustCcFinCalcs(new CcCustPersonalRatesFees(), ledgerList));
        }
        lastStatementId = allStatementsList.size() - 1;
        CcCustFinData statementFormData = allStatementsList.get(lastStatementId);

        statementFormData.setRoutingNum(dataEntryPane.ccBranchDataEntryPane.tfRoutingNum.getText());
        statementFormData.setBranchNum(dataEntryPane.ccBranchDataEntryPane.tfBranchNum.getText());
        statementFormData.setCompanyName(dataEntryPane.ccBranchDataEntryPane.tfBranchName.getText());
        statementFormData.setbranchAddress(dataEntryPane.ccBranchDataEntryPane.tfBranchAddress.getText());
        statementFormData.setbranchCity(dataEntryPane.ccBranchDataEntryPane.tfBranchCity.getText());
        statementFormData.setbranchState(dataEntryPane.ccBranchDataEntryPane.tfBranchState.getText());
        statementFormData.setbranchZip(dataEntryPane.ccBranchDataEntryPane.tfBranchZip.getText());
        statementFormData.setbranchEmail(dataEntryPane.ccBranchDataEntryPane.tfBranchEmail.getText());
        statementFormData.setbranchPhone(dataEntryPane.ccBranchDataEntryPane.tfBranchPhone.getText());

        statementFormData.setCustomerName(dataEntryPane.ccCustomerDataEntryPane.tfCustomerName.getText());
        statementFormData.setCustomerAddress(dataEntryPane.ccCustomerDataEntryPane.tfCustomerAddress.getText());
        statementFormData.setCustomerCity(dataEntryPane.ccCustomerDataEntryPane.tfCustomerCity.getText());
        statementFormData.setCustomerState(dataEntryPane.ccCustomerDataEntryPane.tfCustomerState.getText());
        statementFormData.setCustomerZip(dataEntryPane.ccCustomerDataEntryPane.tfCustomerZip.getText());
        statementFormData.setCustomerEmail(dataEntryPane.ccCustomerDataEntryPane.tfCustomerEmail.getText());
        statementFormData.setCustomerPhone(dataEntryPane.ccCustomerDataEntryPane.tfCustomerPhone.getText());

        statementFormData.setAccountNum(dataEntryPane.ccCustAcctInfoDataEntryPane.tfAccountNum.getText());
        if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel01.isSelected()) {
            statementFormData.setAccountType("0");
        } else if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel02.isSelected()) {
            statementFormData.setAccountType("1");
        }
        statementFormData.setCreditLimit(dataEntryPane.ccCustAcctInfoDataEntryPane.tfCreditLimit.getText());
        statementFormData.setPrevBalance(dataEntryPane.ccCustAcctInfoDataEntryPane.tfPrevBalance.getText());



        System.out.println(allStatementsList.get(lastStatementId).getbranchName());

    }

    public int getLastStatementId(){
        return lastStatementId;
    }

    public void clearFormData(CciisDataEntryPane dataEntryPane){

        dataEntryPane.ccBranchDataEntryPane.tfRoutingNum.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchName.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchNum.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchName.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchAddress.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchCity.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchState.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchZip.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchEmail.clear();
        dataEntryPane.ccBranchDataEntryPane.tfBranchPhone.clear();

        dataEntryPane.ccCustomerDataEntryPane.tfCustomerName.clear();
        dataEntryPane.ccCustomerDataEntryPane.tfCustomerAddress.clear();
        dataEntryPane.ccCustomerDataEntryPane.tfCustomerCity.clear();
        dataEntryPane.ccCustomerDataEntryPane.tfCustomerState.clear();
        dataEntryPane.ccCustomerDataEntryPane.tfCustomerZip.clear();
        dataEntryPane.ccCustomerDataEntryPane.tfCustomerEmail.clear();
        dataEntryPane.ccCustomerDataEntryPane.tfCustomerPhone.clear();

        dataEntryPane.ccCustAcctInfoDataEntryPane.tfAccountNum.clear();
        dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel01.setSelected(true);
        dataEntryPane.ccCustAcctInfoDataEntryPane.tfCreditLimit.clear();
        dataEntryPane.ccCustAcctInfoDataEntryPane.tfPrevBalance.clear();



    }

    public void viewStatement(CciisViewStatementPane cciisViewStatementPane,
                              Main.TabMainPane tabMainPane){


        CcCustCcFinCalcs dataAndFees = allStatementsList.get(getLastStatementId());
        dataAndFees.runCalcs();
        // changes tab to View Statement
        tabMainPane.getSelectionModel().select(tabMainPane.tab2);

        cciisViewStatementPane.ccBranchDataEntryPane.tfRoutingNum.setText(dataAndFees.getRoutingNum());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchName.setText(dataAndFees.getbranchName());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchNum.setText(dataAndFees.getAccountNum());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchName.setText(dataAndFees.getbranchName());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchAddress.setText(dataAndFees.getbranchAddress());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchCity.setText(dataAndFees.getbranchCity());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchState.setText(dataAndFees.getbranchState());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchZip.setText(dataAndFees.getbranchZip());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchEmail.setText(dataAndFees.getbranchEmail());
        cciisViewStatementPane.ccBranchDataEntryPane.tfBranchPhone.setText(dataAndFees.getbranchPhone());

        cciisViewStatementPane.ccCustomerDataEntryPane.tfCustomerName.setText(dataAndFees.getCustomerName());
        cciisViewStatementPane.ccCustomerDataEntryPane.tfCustomerAddress.setText(dataAndFees.getCustomerAddress());
        cciisViewStatementPane.ccCustomerDataEntryPane.tfCustomerCity.setText(dataAndFees.getCustomerCity());
        cciisViewStatementPane.ccCustomerDataEntryPane.tfCustomerState.setText(dataAndFees.getCustomerState());
        cciisViewStatementPane.ccCustomerDataEntryPane.tfCustomerZip.setText(dataAndFees.getCustomerZip());
        cciisViewStatementPane.ccCustomerDataEntryPane.tfCustomerEmail.setText(dataAndFees.getCustomerEmail());
        cciisViewStatementPane.ccCustomerDataEntryPane.tfCustomerPhone.setText(dataAndFees.getCustomerPhone());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfAccountNum.setText(dataAndFees.getAccountNum());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfAccountType.setText(dataAndFees.getAccountType());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfCreditLimit.setText(dataAndFees.getCreditLimit());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfPrevBalance.setText(dataAndFees.getPrevBalance());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfInterestCharge.setText(dataAndFees.getInterestCharge().toString());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfFinalStatementBalance
                .setText(dataAndFees.getFinalStatementBalance().toString());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfNewMinPaymentAmt.setText(dataAndFees.getNewMinPaymentAmt().toString());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfRemainingCredit.setText(dataAndFees.getRemainingCreditAmt().toString());

//        if (dataAndFees.isOverCreditLimit()) {
//            cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfOverLimitFee.setText((CcCustBusinessRatesFees) dataAndFees);
//        }

    }

//    public void saveConfirmation() {
//        Stage stage = new Stage();
//
//        VBox box = new VBox();
//        box.setPadding(new Insets(10));
//
//        // How to center align content in a layout manager in JavaFX
//        box.setAlignment(Pos.CENTER);
//
//        Text confirmation = new Text("Your entry has been saved.");
//
//        Button btCloseWindow = new Button();
//        btCloseWindow.setText("Close This Window");
//
//        btCloseWindow.setOnAction(e -> stage.close());
//
//        box.getChildren().add(confirmation);
//        box.getChildren().add(btCloseWindow);
//        Scene scene = new Scene(box, 250, 150);
//        stage.setScene(scene);
//        stage.show();
//    }





}
