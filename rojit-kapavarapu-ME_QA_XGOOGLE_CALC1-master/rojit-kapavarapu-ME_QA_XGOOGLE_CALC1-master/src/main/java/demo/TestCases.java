package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases
 {
    ChromeDriver driver;


    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }






    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }



    
    public  void testCase01() throws InterruptedException
    {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.google.com";

        if (currentURL.contains(expectedURL)) 
        {
            System.out.println("URL verification successful. Test passed!");
           
        }
         else
         {
            System.out.println("URL verification failed. Test failed!");
          
        }
    

        //Type "calculator" in the Google search bar and press Enter.
        WebElement searchBar=driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchBar.sendKeys("calculator");
        searchBar.submit();
        Thread.sleep(1000);
        
        //Verify that the Google Calculator loads.
        WebElement page_Loading=driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div"));

        if(page_Loading.isDisplayed()){
            System.out.println("Google calculator loaded successfully");

        }else{
             System.out.println("Google calculator did not load successfully");
        }
        
                
        //Confirm that the initial display shows zero(0).
        WebElement calc_result=driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]/div/div/div[1]/div[2]"));
         String result=page_Loading.getText();
         Thread.sleep(2000);

         if( calc_result.isDisplayed()){

            System.out.println("Initial display shows zero");
         } else{

              System.out.println("Initial display does not show zero");
         }
              System.out.println("end Test case: testCase01");
        }






    
  
        //TestCase02: Verify Addition and Subtraction Operations
        //Description: Verify that the Google Calculator can perform addition and subtraction correctly.
        // Test Steps:
        //Perform an addition operation, 5 + 7.

         public void testCase02()
          {
        System.out.println("Start Test case: testCase02");

        WebElement number5 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[2]/div/div"));
        number5.click();

        WebElement plusButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[4]/div/div"));
        plusButton.click();

        WebElement number7 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[1]/div/div"));
        number7.click();

        WebElement equalsButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
        equalsButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Confirm that the displayed result is correct (in this case, 12).
        WebElement result = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        String resultValue = result.getText();

        if (result.isDisplayed()) {
            System.out.println(" Addition operation result is correct.");
        } else {
            System.out.println(" Addition operation result is incorrect.");
        }

        //Perform a subtraction operation, 15 - 8.
        //All clear the tab
        WebElement acButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[1]/td[4]/div/div[1]"));
        acButton.click();

        WebElement number1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[1]/div/div"));
        number1.click();

        WebElement number5Subtraction = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[2]/div/div"));
        number5Subtraction.click();

        WebElement minusButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[4]/div/div"));
        minusButton.click();

        WebElement number8 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[2]/div/div"));
        number8.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement equalButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
        equalButton.click();

        //Confirm that the displayed result is correct (in this case, 7).
        WebElement result1 = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        String result1Value = result.getText();

        if (result1.isDisplayed()) {
            System.out.println(" subtraction operation result is correct.");
        } else {
            System.out.println(" subtraction operation result is incorrect.");
        }

        //Expected Result: The Google Calculator should correctly perform the addition operation and the subtraction operation, and the displayed result should be 12 and 7.

        System.out.println("end Test case: testCase02");

    }












       public void testCase03()
        {
        System.out.println("Start Test case: testCase03");
        // TestCase03: Verify the Functionality of the All Clear (AC) Button and Multiplication Operation
        //Description: Verify that the Google Calculator's "All Clear" (AC) button clears the display, and the calculator remains functional for multiplication operation..
        //Test Steps:
        //All clear the tab
        WebElement acButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[1]/td[4]/div/div[1]"));
        acButton.click();
        // Perform a multiplication operation, 10 * 3.
        WebElement number1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[1]/div/div"));
        number1.click();

        WebElement number0multiplication = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[1]/div/div"));
        number0multiplication.click();

        WebElement multioperationButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[4]/div/div"));
        multioperationButton.click();

        WebElement number3 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[3]/div/div"));
        number3.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement equalButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
        equalButton.click();                                  //*[@id="rso"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div

        //Confirm that the displayed result is correct (in this case, 30).
        WebElement result3 = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        String result3Value = result3.getText();

        if (result3.isDisplayed()) {
            System.out.println(" mutiplication operation result is correct.");
        } else {
            System.out.println(" multiplication operation result is incorrect.");
        }

        //Click the "AC" (All Clear) button on the calculator.
        WebElement ACButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[1]/td[4]/div/div[1]"));
        ACButton.click();

        //Verify that the display clears.
        result3Value = result3.getText();
        if (result3Value.isEmpty()) {
            System.out.println(" Display is cleared after clicking the 'AC' button..");
        } else {
            System.out.println(" Display is not cleared after clicking the 'AC' button..");
        }

        //Expected Result: The "All Clear" (AC) button should clear the display, and the Google Calculator should correctly perform the multiplication operation.

        System.out.println("end Test case: testCase03");


    }









        public void testCase04() 
        {
        System.out.println("Start Test case: testCase04");
        //TestCase04: Verify Division Operation
        //**Description: **Verify that the Google Calculator can perform division correctly.
        //Test Steps:
        //Perform a division operation, 20 / 4.
        WebElement number2 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[2]/div/div"));
        number2.click();

        WebElement number0division = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[1]/div/div"));
        number0division.click();

        WebElement divButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[4]/div/div"));
        divButton.click();

        WebElement number4 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[1]/div/div"));
        number4.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement equalButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
        equalButton.click();

        //Confirm that the displayed result is correct (in this case, 5).
        WebElement result4 = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        String result4Value = result4.getText();

        if (result4.isDisplayed()) {
            System.out.println(" Division operation result is correct.");
        } else {
            System.out.println(" Division operation result is incorrect.");
        }
        //Expected Result: The Google Calculator should correctly perform the division operation.



        System.out.println("end Test case: testCase04");
    }
}