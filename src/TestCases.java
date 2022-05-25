import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class TestCases {
    MyLibs myLibs;
    public TestCases(){
        myLibs = new MyLibs();
        myLibs.startLogFile();
    }
    public void testCasesLogin(WebDriver driver) throws IOException {

        System.out.println("STARTING TEST AND LOGS :LOGIN:");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        myLibs.Log("STARTING TEST :LOGIN:" +  dtf.format(now) + "\n");
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
        myLibs.Log("\nENDING TEST :LOGIN:\n");
        System.out.println("...ENDING TEST :LOGIN :...");
    }//testCases

    public void testCasesLabels(WebDriver driver)
    {
        System.out.println("...STARTING TEST AND LOGS :NEW LABEL:...");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        myLibs.Log("STARTING TEST :NEW LABEL:" +  dtf.format(now) + "\n");

        //Create New Label
        WebElement button = driver.findElement(By.xpath("//*[@id=\":4g\"]"));
        button.click();

        //New label button
        button = driver.findElement(By.xpath("//*[@id=\":43\"]/div[5]/a"));
        button.click();

        //Waiting to display of New Label Window
        try{ synchronized ( driver ){ driver.wait(5000); } }catch (Exception e){}

        try {
            WebDriverWait waiting =  new WebDriverWait(driver, 10);
            //Write tha Label Name
            WebElement input = driver.findElement(By.className("xx"));
            input.sendKeys("My New Label");

            //Create Button
            button = driver.findElement(By.className("J-at1-auR"));
            button.click();
        }catch (Exception e){
            System.out.println("Label: " + e);
        }

        System.out.println("...New Label Created...");
        myLibs.Log("New Label Created" + "\n");

        System.out.println("...ENDING TEST AND LOGS :NEW LABEL:...");
        myLibs.Log("\nENDING TEST :NEW LABEL:" + "\n");
    }//testCasesLabels

    public void testCasesSpam(WebDriver driver)
    {
        System.out.println("...STARTING TEST AND LOGS :SPAM:...");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        myLibs.Log("STARTING TEST :SPAM:" +  dtf.format(now) + "\n");

        //Waiting to display
        try{ synchronized ( driver ){ driver.wait(5000); } }catch (Exception e){}

        System.out.println("...Click over Spam Link...");
        myLibs.Log("Click over Spam Link");
        WebElement button = driver.findElement(By.xpath("//*[@id=\":4v\"]"));
        button.click();

        //Waiting to display of New Label Window
        try{ synchronized ( driver ){ driver.wait(5000); } }catch (Exception e){}

        System.out.println("...Click over Checkbox All Spam...");
        myLibs.Log("Click over Checkbox All Spam");
        button = driver.findElement(By.xpath("//*[@id=\":69\"]/div[1]/span"));
        button.click();

        //Waiting to display of New Label Window
        try{ synchronized ( driver ){ driver.wait(5000); } }catch (Exception e){}

        try{
            System.out.println("...Click over Delete forever...");
            myLibs.Log("Click over Delete forever");
            button = driver.findElement(By.xpath("//*[@id=\":4\"]/div[2]/div[2]/div[1]/div/div/div[2]/div/div"));
            button.click();
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("...ENDING TEST AND LOGS :SPAM:...");
        myLibs.Log("\nENDING TEST :SPAM:" + "\n");
    }//testCasesSpam

    public void testCasesLogout(WebDriver driver)
    {
        System.out.println("...STARTING TEST AND LOGS :LOGOUT:...");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        myLibs.Log("STARTING TEST :SPAM:" +  dtf.format(now) + "\n");

        //Waiting to display
        try{ synchronized ( driver ){ driver.wait(5000); } }catch (Exception e){}

        System.out.println("Click over Profile button");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a"));
        button.click();
        myLibs.Log("Click over Profile button");

        driver.switchTo().frame(driver.findElements(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[3]/iframe")).get(0));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div/div[2]/div[3]/span/a/div"))).click();
        myLibs.Log("Click over Sign out button");
        myLibs.Log("\nENDING TEST :LOGOUT:" + "\n");
    }//testCasesLogout
}//TestCases
