import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GuiLogic{
    CciisDataEntryPane dataEntryPane;

    // adds a line item to ledgerList
    public void addToLedgerList(
            ArrayList<String[]> ledgerList,
            String description, String amount,
            CciisDataEntryPane.TwoRadioButtons debitCreditToggle,
            CciisDataEntryPane dataEntryPane) {

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

    }

    public void saveFormData(CciisDataEntryPane dataEntryPane){

    }



}
