package DDTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	public static WebDriver driver = null;
	
	
	@Test(dataProvider = "getdata")
	public void loginToAmazon(String username, String password){
		
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
		
		
	}
	
	
	@DataProvider
	public Object[][] getdata(){
		
		ExcelReader er = new ExcelReader("C:\\Users\\Owner\\Desktop\\Tutorial_Java_Selenium_s\\DataDrivenTesting\\src\\test\\resources\\dd.xlsx");
		
		
		String sheetName = "login";
		
		int rows = er.getRowCount(sheetName);
		
		int cols = er.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int r =2; r<=rows; r++){
			
			for(int c=0;c<cols; c++){
				
				data[r-2][c] =er.getCellData(sheetName, c, r);
				
			
			
		}
		}
		
		/*data[0][0] = "a@gmail.com";
		data[0][1] = "abc123";
		
		data[1][0] = "b@gmail.com";
		data[1][1] = "abc1234";
		
		data[2][0] = "c@gmail.com";
		data[2][1] = "abc1235";*/
		
		
		
		
		return data;
		
		
	}
	
	
	
	}
