import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TestCases {
    public TestCases(){}
    public void testCases(WebDriver driver) throws IOException {
        MyLibs myLibs = new MyLibs();
        myLibs.startLogFile();
        System.out.println("STARTING TEST AND LOGS");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        myLibs.Log("STARTING TEST - " +  dtf.format(now) + "\n");
        myLibs.Log("STARTING: 1st Scenario - ");
        System.out.println("STARTING: 1st Scenario");
        // 1st Scenario { Username and Password are blank }
        try{
            WebElement email = driver.findElement(By.name("identifier"));
            System.out.println("...Email field exists...");
            email.sendKeys("");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button"));
            button.click();
            WebDriverWait waiting =  new WebDriverWait(driver, 5);
            WebElement GmailText = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":1w\"]")));
            String text = GmailText.getText();
            //Check it if the "Principal" tab exist, if exists the login was correctly
            if(text.equals("Principals"))
            {
                System.out.println("...Successful Login...");
            }else
            {
                System.out.println("...Failure Login...");
                dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                now = LocalDateTime.now();
                myLibs.TakeEvidence ("Failure Login "+dtf.format(now),driver);
                myLibs.Log("Failure Login");
            }
        } catch (Exception e) {
            System.out.println("...Email field is BLANK..." );
            dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
            now = LocalDateTime.now();
            try {
                myLibs.TakeEvidence ("Email field is BLANK Failure Login "+dtf.format(now),driver);
                myLibs.Log("Email field is BLANK Failure Login");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println("STARTING: 2nd Scenario");
        myLibs.Log("STARTING: 2nd Scenario");
        //2nd Scenario { Identify email field is correct email and check if the password is blank. }
        try{
            WebElement email = driver.findElement(By.name("identifier"));
            System.out.println("...Email field exists...");
            myLibs.Log("Email field exists");
            email.sendKeys("rafaelsecops@gmail.com");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button"));
            button.click();


            WebDriverWait waiting =  new WebDriverWait(driver, 5);
            WebElement password = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            System.out.println("...Password field exists...");
            myLibs.Log("Password field exists");
            //password.sendKeys("@?78S=W^~'yXDgAF");
            password.sendKeys("");
            button = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
            button.click();

            waiting =  new WebDriverWait(driver, 5);
            WebElement GmailText = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":1w\"]")));
            String text = GmailText.getText();
            //Check it if the "Principal" tab exist, if exists the login was correctly
            if(text.equals("Principal"))
            {
                System.out.println("...Successful Login...");
                dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                now = LocalDateTime.now();
                myLibs.TakeEvidence ("Failure Login "+dtf.format(now),driver);
                myLibs.Log("Successful Log");
            }else
            {
                System.out.println("...Failure Login...");
                dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                now = LocalDateTime.now();
                myLibs.TakeEvidence ("Failure Login "+dtf.format(now),driver);
                myLibs.Log("Failure Login");
            }
        } catch (Exception e) {
            System.out.println("...Password field is BLANK..." );
            myLibs.Log("Password field is BLANK");
            dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
            now = LocalDateTime.now();
            try {
                myLibs.TakeEvidence ("Email field is BLANK "+dtf.format(now),driver);
                myLibs.Log("Email field is BLANK");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println("STARTING: 3rd Scenario");
        myLibs.Log("STARTING: 3rd Scenario");
        //3th Scenario {Identify the email isn't exists. }
        try {
            WebElement email = driver.findElement(By.name("identifier"));
            System.out.println("...Email field exists...");
            dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
            now = LocalDateTime.now();
            myLibs.Log("Email exists");
            email.sendKeys("rafaelsecopss@gmail.com");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button"));
            button.click();
        } catch (Exception e) {
            System.out.println("...Email isn't exists..." );
            dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
            now = LocalDateTime.now();
            myLibs.TakeEvidence ("Email isn't exists "+dtf.format(now),driver);
            myLibs.Log("Email isn't exists");
        }

        System.out.println("STARTING: 4th Scenario");
        myLibs.Log("STARTING: 4th Scenario");

        //4th Scenario { Identify if the email exists and wrong password. }
        try{
            WebDriverWait waiting =  new WebDriverWait(driver, 15);
            WebElement password = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            System.out.println("...Password field exists...");
            myLibs.Log("Password field exists");
            password.sendKeys("WRONG_PASSWORD");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
            button.click();
            waiting =  new WebDriverWait(driver, 5);
            WebElement GmailText = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":1w\"]")));
            String text = GmailText.getText();
            //Check it if the "Principal" tab exist, if exists the login was correctly
            if(text.equals("Principal"))
            {
                System.out.println("...Successful Login...");
                myLibs.Log("Successful Login");
            }else
            {
                System.out.println("...Failure Login...");
                myLibs.Log("Failure Login");
                dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                now = LocalDateTime.now();
                myLibs.TakeEvidence ("Failure Login "+dtf.format(now),driver);
            }
        } catch (Exception e){
            System.out.println("...Wrong Password..." );
            myLibs.Log("Wrong Password");
        }

        System.out.println("STARTING: 5th Scenario");
        myLibs.Log("STARTING: 5th Scenario");
        //5th Scenario { Correct login with Email exists & Password is correct. }
        try{
            WebDriverWait waiting =  new WebDriverWait(driver, 5);
            WebElement password = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            System.out.println("...Password field exists...");
            myLibs.Log("Password field exists");
            password.sendKeys("@?78S=W^~'yXDgAF");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
            button.click();

            waiting =  new WebDriverWait(driver, 10);
            WebElement GmailText = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":1w\"]")));
            String text = GmailText.getText();
            //Check it if the "Principal" tab exist, if exists the login was correctly
            if(text.equals("Principal"))
            {
                System.out.println("...Successful Login...");
                myLibs.Log("Successful Login");
            }else
            {
                System.out.println("...Failure Login...");
                dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                now = LocalDateTime.now();
                myLibs.TakeEvidence ("Failure Login "+dtf.format(now),driver);
                myLibs.Log("Failure Login");
            }
        } catch (Exception e){
            System.out.println("...Failure Login...");
            try {
                dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                now = LocalDateTime.now();
                myLibs.TakeEvidence ("Failure Login "+dtf.format(now),driver);
                myLibs.Log("Failure Login");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        myLibs.Log("ENDING TEST");
        System.out.println("...ENDING TEST...");
    }//testCases
}//TestCases
