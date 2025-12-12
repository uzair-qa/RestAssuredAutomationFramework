package api.utilities;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "alldata")
	public String [][] allDataProvider(){
	    
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int totalRowCount = ReadExcelFile.getRowCount(fName, "Sheet1");
		int totalColCount = ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userData[][] = new String[totalRowCount-1][totalColCount];

		for(int rowNo=1; rowNo<totalRowCount; rowNo++) {
			
			for(int colNo=0; colNo<totalColCount;colNo++) {
				
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo);
			}
		}
		return userData;
	}
	
	@DataProvider(name = "usernamesdata")
	public String [] userNamesDataProvider(){
		String fname = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int totalRowCount = ReadExcelFile.getRowCount(fname, "Sheet1");
		int totalColCount = ReadExcelFile.getColCount(fname, "Sheet1");
		
		String userNamesData[] = new String[totalRowCount-1];

		for(int rowNo=1; rowNo<totalRowCount; rowNo++) {
			
			userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fname, "Sheet1", rowNo, 1);
		}
		return userNamesData;
	}
}
