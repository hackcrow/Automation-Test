import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLibs {
    String filePath;
    FileOutputStream fileOutputStream;
    public MyLibs(){}

    public WebDriver StartingBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/felipeandraderosales/Desktop/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.gmail.com");
        return  driver;
    }//StartingBrowser

    public void startLogFile(){
        // write the content in file
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
            LocalDateTime now = LocalDateTime.now();
            filePath  = "log/log_" + dtf.format(now);
            fileOutputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);        }
    }
    public void Log(String line){
        try {
            String fileContent = line + "\n";
            fileOutputStream.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void TakeEvidence(String FileName, WebDriver driver) throws IOException {
        File File = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(File, new File("evidences/" + FileName + ".jpeg"));
    }//TakeEvidence
}
