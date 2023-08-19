package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	//this method will fetch all the data from excel
	@Test
	@DataProvider(name="allData")
	public String[][] getAlldata() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"//testData//userdata.xlsx";
		ExcelUtility xl= new ExcelUtility(path);
		
		int rowCount=xl.getRowCount("Sheet1");
		int cellCount=xl.getCellCount("Sheet1", 1);
		System.out.println(rowCount);
		System.out.println(cellCount);
		
		
		String apiData[][]=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				apiData[i-1][j]=xl.getCellData("Sheet1", i, j); //if u don't specify as apiData[i-1][j] then u will get null values at beginning
			}
		}
		
		return apiData;
		//code to print the values of 2D array
		/*
		for(String[] array:apiData)
		{
		    for(String realdata:array)
		    {
		    	System.out.println(realdata);
		    }
		}
		*/
		
		
		
	}
	
	//this method will fetch only username from excel
	
	@DataProvider(name="userNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//userdata.xlsx";
		
		ExcelUtility xl= new ExcelUtility(path);
		
		int rowCount=xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		
		String apiDataUsername[]=new String[rowCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			apiDataUsername[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		return apiDataUsername;
		
	}
}
