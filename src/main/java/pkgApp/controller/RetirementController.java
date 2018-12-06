package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturn1;
	
	@FXML
	private TextField txtAnnualReturn2;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private Label lblNeedToSave;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		//	Clearing all the text inputs
		lblSaveEachMonth.setText("");
		lblNeedToSave.setText("");
		
		txtYearsToWork.setText("");
		txtAnnualReturn1.setText("");
		txtAnnualReturn2.setText("");
		txtYearsRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		int iYearsToWork = Integer.parseInt(txtYearsToWork.getText());
		double dAnnualReturnWorking = Double.parseDouble(txtAnnualReturn1.getText());
		int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
		double dAnnualReturnRetired = Double.parseDouble(txtAnnualReturn2.getText());
		double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
		double dMonthlySSI = Double.parseDouble(txtMonthlySSI.getText());
		
		Retirement rtm = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
		
		
		lblSaveEachMonth.setText(String.format("%.2f",Math.abs(rtm.AmountToSave())));
		lblNeedToSave.setText(String.format("%.2f", Math.abs(rtm.TotalAmountSaved())));
	}
	
}
