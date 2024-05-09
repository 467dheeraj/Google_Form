package demo;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement nameElement;

    @FindBy(xpath = "//div[@class='Pc9Gce Wic03c']/textarea[@jsname='YPqjbf']")
    WebElement textAreaElement;

    @FindBy(xpath = "//div[@class='SG0AAe']/div[1]//div[@class='vd3tt']")
    WebElement radioButtonElement;

    @FindBy(xpath = "//div[@aria-labelledby='i25']/div/label/div/div/div[2]")
    WebElement javaCheckboxElement;

    @FindBy(xpath="//div[@aria-labelledby='i25']/div[2]/label/div/div/div[2]")
    WebElement seleniumCheckboxElement;

    @FindBy(xpath = "//div[@aria-labelledby='i25']/div[4]/label/div/div/div[2]")
    WebElement testNGChckboxElement;

    @FindBy(xpath = "//span[text()='Choose']")
    WebElement dropdownElement;

    @FindBy(xpath = "//div[@class='OA0qNb ncFHed QXL7Te']/div[3]")
    WebElement selectGenderElement;

    @FindBy(xpath = "(//input[@class='whsOnd zHQkBf'])[2]")
    WebElement dateElement;

    @FindBy(xpath = "(//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf'])[3]")
    WebElement hourElement;

    @FindBy(xpath = "(//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf'])[4]")
    WebElement secondElement;

    @FindBy(className = "vHW8K")
    WebElement thankyouElement;


    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        nameElement.sendKeys("Dheeraj Kapoor");
        long epoch= System.currentTimeMillis()/1000;
        //Thread.sleep(2000);
        textAreaElement.sendKeys("I want to be the best QA Engineer! "+epoch);
        //Thread.sleep(2000);
        radioButtonElement.click();
        //Thread.sleep(2000);
        javaCheckboxElement.click();
        seleniumCheckboxElement.click();
        testNGChckboxElement.click();
        //Thread.sleep(2000);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
        //Thread.sleep(2000);
        dropdownElement.click();
        Thread.sleep(2000);
        selectGenderElement.click();

        Calendar c= Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR,-7);
        Date previousDate=c.getTime();
        DateFormat dm= new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate= dm.format(previousDate);
        //System.out.print(formattedDate);
        dateElement.sendKeys(formattedDate);


        DateFormat dm1= new SimpleDateFormat("HH");
        Date d= new Date();
        String time1= dm1.format(d);
        hourElement.sendKeys(time1);
        
        DateFormat dm2= new SimpleDateFormat("mm");
        Date d1= new Date();
        String time2= dm2.format(d1);
        secondElement.sendKeys(time2);
        //Thread.sleep(3000);
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(3000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Submit']")).click();
        Thread.sleep(2000);
        String submitText=thankyouElement.getText();
        System.out.println(submitText);


        



        System.out.println("end Test case: testCase01");
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


}
