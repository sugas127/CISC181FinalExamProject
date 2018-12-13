package pkgEmpty;
import static org.junit.Assert.*;
import org.junit.Test;
import pkgCore.Retirement;
public class RetirementTest {
	@Test
	public void TestPMT() {
		double dAnnualReturnWorking = 0.07;
		int iYearsToWork = 40;
		int iYearsRetired = 20; 
		double dAnnualReturnRetired = 0.02;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		double ExpectedPay = -554.13;
		double ExpectedTotal = -1454485.55;

		Retirement rtm = new Retirement(iYearsToWork, dAnnualReturnWorking,iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
		
		double PV = rtm.TotalAmountSaved();
		double PMT = rtm.AmountToSave();
		
		assertEquals(ExpectedTotal, PV, 0.01);
		assertEquals(ExpectedPay, PMT, 0.01);
		
		System.out.println(PV);
		System.out.println(PMT);
	}

}
