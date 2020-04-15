package searchFromData;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseTest.Common;

public class SearchTest extends Common{
	
	@BeforeClass
	public void BoforeAll() {
		contadorPaso =0;
		contadorFallo=0;
	}
	
	@AfterClass
	public void arterAll() {	
	System.out.println("****************************** ");
	System.out.println("Test que pasaron la prueba : "+ contadorPaso);
	System.out.println("Test que fallaron la prueba : "+ contadorFallo);
	System.out.println("****************************** ");
		
	}
	
	@Test(enabled= true, description= "Pruebas manejadas por datos" )
	public void searchAndWriteData() throws IOException{
		
			//String filepath = "C:\\Users\\User\\Desktop\\Test.xlsx";
			String filepath = "src/test/resources/Test.xlsx";
			String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0);
			//System.out.println("Search Text: "+searchText);
			
			index.search(searchText);
			String resultText = index.getResultTextLocator();
			//System.out.println("Result Text: "+resultText);			
			
			writeFile.writeCellValue(filepath, "Hoja1", 0, 1, resultText);			
			Assert.assertEquals(resultText, "7 results have been found.");
	}
	
	
	

}
