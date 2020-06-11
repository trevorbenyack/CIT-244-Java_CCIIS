import java.util.ArrayList;

// This holds all logic for how the GUI behaves. There should be nothing here that holds any class data.
public class GUI_Logic {

    public GUI_Logic(){
    }

    // adds a line item to tempLedgerList
    // This is invoked when the user presses the "+" in the interface. It takes the line-entry data they've entered
    // and adds it to the end of the running tempLedgerList that is passed to it.
    public static void addToLedgerList(
            ArrayList<String[]> tempLedgerList,
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

        tempLedgerList.add(lineItem);

        // REMOVE THIS LINE
        System.out.println(tempLedgerList.get(0)[0] + " " + tempLedgerList.get(0)[0]);

        // clears data fields
        dataEntryPane.lineItemEntryPane.tfDescription.clear();
        dataEntryPane.lineItemEntryPane.tfAmount.clear();

        dataEntryPane.recentLedgerItems.printLedgerList(tempLedgerList);

    } // end addToLedgerList method

    public static void saveFormData(GUI_Pane_DataEntry dataEntryPane,
                                    ArrayList<CcStatement> allStatementsList,
                                    ArrayList<String[]> tempLedgerList
                                    ){

        // sends an enum AccountType when creating new CcStatement instance to determine rates and fees for statement.
        if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel01.isSelected()) {
            allStatementsList.add(new CcStatement(new RatesFees(AccountType.BUSINESS)));
        } else if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel02.isSelected()) {
            allStatementsList.add(new CcStatement(new RatesFees(AccountType.PERSONAL)));
        }

        // retrieves the current statement being added for easier reference throughout the method
        CcStatement ccStatement = allStatementsList.get(allStatementsList.size() - 1);

        // adds the current tempLedgerList to the CcStatement instance.
        ccStatement.setLedgerList(tempLedgerList);


        // retrieves the data from the form and saves it the current CcStatement instance.
        ccStatement.setRoutingNum(dataEntryPane.ccBranchDataEntryPane.tfRoutingNum.getText());
        ccStatement.setBranchNum(dataEntryPane.ccBranchDataEntryPane.tfBranchNum.getText());
        ccStatement.setCompanyName(dataEntryPane.ccBranchDataEntryPane.tfBranchName.getText());
        ccStatement.setbranchAddress(dataEntryPane.ccBranchDataEntryPane.tfBranchAddress.getText());
        ccStatement.setbranchCity(dataEntryPane.ccBranchDataEntryPane.tfBranchCity.getText());
        ccStatement.setbranchState(dataEntryPane.ccBranchDataEntryPane.tfBranchState.getText());
        ccStatement.setbranchZip(dataEntryPane.ccBranchDataEntryPane.tfBranchZip.getText());
        ccStatement.setbranchEmail(dataEntryPane.ccBranchDataEntryPane.tfBranchEmail.getText());
        ccStatement.setbranchPhone(dataEntryPane.ccBranchDataEntryPane.tfBranchPhone.getText());
        ccStatement.setCustomerName(dataEntryPane.ccCustomerDataEntryPane.tfCustomerName.getText());
        ccStatement.setCustomerAddress(dataEntryPane.ccCustomerDataEntryPane.tfCustomerAddress.getText());
        ccStatement.setCustomerCity(dataEntryPane.ccCustomerDataEntryPane.tfCustomerCity.getText());
        ccStatement.setCustomerState(dataEntryPane.ccCustomerDataEntryPane.tfCustomerState.getText());
        ccStatement.setCustomerZip(dataEntryPane.ccCustomerDataEntryPane.tfCustomerZip.getText());
        ccStatement.setCustomerEmail(dataEntryPane.ccCustomerDataEntryPane.tfCustomerEmail.getText());
        ccStatement.setCustomerPhone(dataEntryPane.ccCustomerDataEntryPane.tfCustomerPhone.getText());
        ccStatement.setAccountNum(dataEntryPane.ccCustAcctInfoDataEntryPane.tfAccountNum.getText());
        if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel01.isSelected()) {
            ccStatement.setAccountType(AccountType.BUSINESS);
        } else if (dataEntryPane.ccCustAcctInfoDataEntryPane.rbAccountType.rbLabel02.isSelected()) {
            ccStatement.setAccountType(AccountType.PERSONAL);
        }
        ccStatement.setCreditLimit(dataEntryPane.ccCustAcctInfoDataEntryPane.tfCreditLimit.getText());
        ccStatement.setPrevBalance(dataEntryPane.ccCustAcctInfoDataEntryPane.tfPrevBalance.getText());

    }

    public static void clearFormData(GUI_Pane_DataEntry dataEntryPane){

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

    public static void viewStatement(GUI_Pane_Statement guiPaneStatement,
                                     Main.TabMainPane tabMainPane,
                                     ArrayList<CcStatement> allStatementsList){

        // changes tab to View CcStatement
        tabMainPane.getSelectionModel().select(tabMainPane.tab2);

        // retrieves the current statement being added for easier reference throughout the method
        CcStatement ccStatement = allStatementsList.get(allStatementsList.size() - 1);

        // retrieves the data from the CcStatment instance and displays it in the current Statement view pane.
        guiPaneStatement.ccBranchDataEntryPane.tfRoutingNum.setText(ccStatement.getRoutingNum());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchName.setText(ccStatement.getbranchName());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchNum.setText(ccStatement.getAccountNum());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchName.setText(ccStatement.getbranchName());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchAddress.setText(ccStatement.getbranchAddress());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchCity.setText(ccStatement.getbranchCity());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchState.setText(ccStatement.getbranchState());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchZip.setText(ccStatement.getbranchZip());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchEmail.setText(ccStatement.getbranchEmail());
        guiPaneStatement.ccBranchDataEntryPane.tfBranchPhone.setText(ccStatement.getbranchPhone());
        guiPaneStatement.ccCustomerDataEntryPane.tfCustomerName.setText(ccStatement.getCustomerName());
        guiPaneStatement.ccCustomerDataEntryPane.tfCustomerAddress.setText(ccStatement.getCustomerAddress());
        guiPaneStatement.ccCustomerDataEntryPane.tfCustomerCity.setText(ccStatement.getCustomerCity());
        guiPaneStatement.ccCustomerDataEntryPane.tfCustomerState.setText(ccStatement.getCustomerState());
        guiPaneStatement.ccCustomerDataEntryPane.tfCustomerZip.setText(ccStatement.getCustomerZip());
        guiPaneStatement.ccCustomerDataEntryPane.tfCustomerEmail.setText(ccStatement.getCustomerEmail());
        guiPaneStatement.ccCustomerDataEntryPane.tfCustomerPhone.setText(ccStatement.getCustomerPhone());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfAccountNum.setText(ccStatement.getAccountNum());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfAccountType.setText(ccStatement.getAccountType().toString());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfCreditLimit.setText(ccStatement.getCreditLimit());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfPrevBalance.setText(ccStatement.getPrevBalance());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfInterestCharge.setText(ccStatement.getInterestCharge().toString());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfFinalStatementBalance
                .setText(ccStatement.getFinalStatementBalance().toString());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfNewMinPaymentAmt.setText(ccStatement.getNewMinPaymentAmt().toString());
        guiPaneStatement.ccCustAcctInfoDataEntryPane.tfRemainingCredit.setText(ccStatement.getRemainingCreditAmt().toString());
        if (ccStatement.isOverCreditLimit()) {
            guiPaneStatement.ccCustAcctInfoDataEntryPane.lbOverLimitFee.setVisible(true);
            guiPaneStatement.ccCustAcctInfoDataEntryPane.tfOverLimitFee.setVisible(true);
            guiPaneStatement.ccCustAcctInfoDataEntryPane.tfOverLimitFee.setText(ccStatement.getOverLimitFee());
        }

        // NEEDS ADDED:
        //  Warning for being over limit
        //  list of line items for the current statement

//        if (ccStatement.isOverCreditLimit()) {
//            guiPaneStatement.ccCustAcctInfoDataEntryPane.tfOverLimitFee.setText((CustBusinessRatesFees) ccStatement);
//        }

    }

//    This is the code for a window pop-up. Used it for something else that was scrapped, but keeping it for now
//    in case I decide to use it for something later.

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
