import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        TestCases testCases = new TestCases();

        MyLibs myLibs = new MyLibs();
        WebDriver myDriver =myLibs.StartingBrowser();
        testCases.testCases(myDriver);

        try{ synchronized ( myDriver ){ myDriver.wait(5000); } }catch (Exception e){}

        myDriver.close();
    }//main
}//Main