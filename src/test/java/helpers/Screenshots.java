package helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public static void takeScreenshot(String result, WebDriver driver) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("target/surefire-reports/scr"+result+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo sacar la captura : "+e);
			e.printStackTrace();
		}
	}

}
