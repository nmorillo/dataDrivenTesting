package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Index {
	private WebDriver driver;
	private By searchField;
	private By searchButton;
	private By resultTextLocator;
	
	
//	private By iconList;// list
//	private By womenLink;
//	private By dressesLink;
//	private By t_shirtsLink;
//	private By productName;
//	private By loginLink;
	
	public Index(WebDriver driver) {
		this.driver = driver;
		searchField = By.id("search_query_top");
		searchButton = By.name("submit_search");
		resultTextLocator = By.cssSelector("span.heading-counter");
		
//		iconList = By.id("list");
//		womenLink = By.linkText("Women");
//		dressesLink = By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a");
//		t_shirtsLink = By.xpath("//*[@id=\'block_top_menu\']/ul/li[3]/a");
//		productName = By.xpath("//*[@id='center_column']/div/div/div[3]/h1");
//		loginLink = By.linkText("Sign in");
	}
	
//	public void goCategory(String category) {
//		driver.findElement(By.linkText(category)).click();
//	}
	
	public void search(String item) {
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(item);
		driver.findElement(searchButton).click();
		
	}
	
	public String getResultTextLocator() {
		return driver.findElement(resultTextLocator).getText();
	}
//	public void goT_shirtsCategory() {
//		driver.findElement(t_shirtsLink).click();
//	}
//	
//	public void goDressesCategory() {
//		driver.findElement(dressesLink).click();
//	}
	
	
//	public void clickToIconList() {
//		driver.findElement(iconList).click();
//	}
//	
//	public void clickWomenLink() {
//		driver.findElement(womenLink).click();
//	}
	
//	public void selectColor(int num) {
//		driver.findElement(By.id("color_"+num)).click();
//	}
	
//	public String GetProductNameText() {		
//		System.out.println("Estoy en Index......"+driver.findElement(productName).getText());
//		return driver.findElement(productName).getText();
//	}
//	
//	public void loginBtn() {
//		driver.findElement(loginLink).click();
//	}

	
}
