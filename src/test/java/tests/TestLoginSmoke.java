package tests;

import config.Config;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import pages.BoardsPage;
import pages.LoggedOutPage;
import pages.LoginPage;

public class TestLoginSmoke extends AbstractTrelloSeleniumTest {

    private static final String admin = Config.getAdminName();
    private static final String password = Config.getAdminPass();

    @Test
    public void testCorrectLogin() {
        String expectedBoardPageTitle = "Boards | Trello";
        String expectedLoggedOutPage = "Logged out of Trello";

        LoginPage loginPage = new LoginPage();
        BoardsPage boards = loginPage.loginAs(admin, password);
        String title = boards.getTitle();
        AssertJUnit.assertEquals("Login was not successful1", expectedBoardPageTitle, title);

        LoggedOutPage loggedOutPage = loginPage.logout();
        title = loggedOutPage.getTitle();
        AssertJUnit.assertEquals("Logging out was not successful!", expectedLoggedOutPage, title);
    }

}
