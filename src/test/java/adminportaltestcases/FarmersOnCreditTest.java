package adminportaltestcases;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import excelClasses.Menu;
import excelClasses.MenuFactory;
import excelClasses.TestInputsMenu;
import utilities.DriverType;
import utilities.ElementManager;

public class FarmersOnCreditTest extends ElementManager {

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	@Parameters({ "browser" })
	@BeforeClass
	public void setup(String browser) throws IOException, InterruptedException {
		driver = getDriver(DriverType.valueOf(browser));
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	public void inputLedger() throws Exception {

		try {

			try {
				userStoryDescription = "Jiva Web Portal - Login";
				logUserStoryStart(userStoryDescription, "Jiva Web Portal - Login");

				Menu menu = MenuFactory.getTestInputsMenuByTitle(TestInputsMenu.WEBPORTALLOGIN);
				loginPages.jivaPortalLogin(menu);

				successMsgDesc = logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}
			
			try {
				userStoryDescription = "Jiva Web Portal - View the Farmers Credit Details";
				logUserStoryStart(userStoryDescription, "Jiva Web Portal - Search and View the Farmers Credit Details");

				farmeroncredit.farmersOnCredit();

				successMsgDesc = logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

		} catch (Throwable e) {
			displayExecutionResults(successMsgDesc, failMsgDesc);
		}
		displayExecutionResults(successMsgDesc, failMsgDesc);

	}
}