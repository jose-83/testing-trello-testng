package tests;

import config.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import pages.BoardPage;
import pages.BoardsPage;
import pages.LoginPage;

public class TestBoardCreation extends AbstractTrelloSeleniumTest {

    private static final String admin = Config.getAdminName();
    private static final String password = Config.getAdminPass();
    private static final String boardName = "New Board";
    private static BoardsPage homepage;

    @BeforeMethod
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        homepage = loginPage.loginAs(admin, password);
    }

    @AfterMethod
    public void tearDown() {
        homepage.logout();
    }

    @Test
    public void testCreation() {
        BoardPage boardPage = homepage.createBoard(boardName);
        AssertJUnit.assertEquals("Creation process was not completely successful.", boardName, boardPage.getBoardName());

        boardPage.goToHomepage();
        AssertJUnit.assertTrue("The created board is not available on homepage.", homepage.isBoardAvailable(boardName));
    }

    @Test
    public void testDeletion() {
        BoardPage boardPage = homepage.createBoard(boardName);
        boardPage.deleteBoard();
        AssertJUnit.assertFalse("The board was not deleted.", homepage.isBoardAvailable(boardName));
    }

}
