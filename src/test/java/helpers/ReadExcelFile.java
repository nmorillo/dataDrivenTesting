package helpers;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRichTextString;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.Platform;

import baseTest.Common;



public class ReadExcelFile extends Common {
	
	public ReadExcelFile() {
		
	}
	
	public XSSFSheet getSheet(String filepath, String sheetName) throws IOException {
		File file = new File(filepath);		
		FileInputStream inputStream = new FileInputStream(file);			
		XSSFWorkbook newWorkbook = new 	XSSFWorkbook(inputStream);			
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
//		newWorkbook.close();
		return newSheet;
	}
	
	public void readExcel(String filepath, String sheetName) throws IOException {
		//cramos un objeto de tipo file y le pasamos el camino en donde va a estar ese fichero
		File file = new File(filepath);
		//realiza la conexión del archivo según su ruta y guarda los datos 
		FileInputStream inputStream = new FileInputStream(file);		
		// el objeto donde vamos a guardar el ficheto con los datos obtenidos	
		XSSFWorkbook newWorkbook = new 	XSSFWorkbook(inputStream);		
		// creamos el objeto en donde se guarda la hoja en la cual estamos trabajando		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		// guardamos cuantas filas de datos tiene ese excel
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		
		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "||");
			}			
		}
		newWorkbook.close();
	}
	
	public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		File file = new File(filepath);		
		FileInputStream inputStream = new FileInputStream(file);				
		XSSFWorkbook newWorkbook = new 	XSSFWorkbook(inputStream);		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		// para leer el dato de una celda específica
		XSSFRow row = newSheet.getRow(rowNumber);
		
		XSSFCell cell = row.getCell(cellNumber);
		
		newWorkbook.close();
		return cell.getStringCellValue();		
	}

}
