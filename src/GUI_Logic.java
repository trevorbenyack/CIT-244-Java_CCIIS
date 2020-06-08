import java.util.ArrayList;


public class GUI_Logic {

    GUI_Pane_DataEntry dataEntryPane;
    ArrayList<CcStatement> allStatementsList;
    ArrayList<String[]> ledgerList = new ArrayList<>();

    public GUI_Logic(ArrayList<CcStatement> allStatementsList, ArrayList<String[]> ledgerList){
        this.allStatementsList = allStatementsList;
        this.ledgerList = ledgerList;
    }

    // adds a line item to ledgerList
    public void addToLedgerList(
            ArrayList<String[]> ledgerList,
            GUI_Pane_DataEntry dataEntryPane) {

        String description = dataEntryPane.lineItemEntryPane.tfDescription.getText();
        String amount = dataEntryPane.lineItemEntryPane.tfAmount.getText();
        GUI_Pane_DataEntry.TwoRadioButtons debitCreditToggle = dataEntryPane.lineItemEntryPane.debitCreditToggle;

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

    public void saveFormData(GUI_Pane_DataEntry dataEntryPane){

        if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel01.isSelected()) {
            allStatementsList.add(new CcStatement(new RatesFees(AccountType.BUSINESS), ledgerList));
        } else if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel02.isSelected()) {
            allStatementsList.add(new CcStatement(new RatesFees(AccountType.PERSONAL), ledgerList));
        }

        CcAccount statementFormData = allStatementsList.get(allStatementsList.size() - 1);

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
            statementFormData.setAccountType(AccountType.BUSINESS);
        } else if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel02.isSelected()) {
            statementFormData.setAccountType(AccountType.PERSONAL);
        }
        statementFormData.setCreditLimit(dataEntryPane.ccCustAcctInfoDataEntryPane.tfCreditLimit.getText());
        statementFormData.setPrevBalance(dataEntryPane.ccCustAcctInfoDataEntryPane.tfPrevBalance.getText());

    }

    public void clearFormData(GUI_Pane_DataEntry dataEntryPane){

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

    public void viewStatement(GUI_Pane_Statement cciisViewStatementPane,
                              Main.TabMainPane tabMainPane){


        CcStatement dataAndFees = allStatementsList.get(allStatementsList.size() - 1);
        // changes tab to View CcStatement
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
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfAccountType.setText(dataAndFees.getAccountType().toString());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfCreditLimit.setText(dataAndFees.getCreditLimit());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfPrevBalance.setText(dataAndFees.getPrevBalance());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfInterestCharge.setText(dataAndFees.getInterestCharge().toString());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfFinalStatementBalance
                .setText(dataAndFees.getFinalStatementBalance().toString());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfNewMinPaymentAmt.setText(dataAndFees.getNewMinPaymentAmt().toString());
        cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfRemainingCredit.setText(dataAndFees.getRemainingCreditAmt().toString());

//        if (dataAndFees.isOverCreditLimit()) {
//            cciisViewStatementPane.ccCustAcctInfoDataEntryPane.tfOverLimitFee.setText((CustBusinessRatesFees) dataAndFees);
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
