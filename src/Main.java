import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        TestCases testCases = new TestCases();

        WebDriver myDriver =testCases.myLibs.StartingBrowser();
        testCases.testCasesLogin(myDriver);
        testCases.testCasesLabels(myDriver);
        testCases.testCasesSpam(myDriver);
        testCases.testCasesLogout(myDriver);

        try{ synchronized ( myDriver ){ myDriver.wait(5000); } }catch (Exception e){}

        //myDriver.close();
    }//main
}//Main