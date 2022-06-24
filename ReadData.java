package Week6Day2;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.

public class ReadData {

	public static String[][] fetchData(String fileName) throws IOException {
//	public static void main(String arg[]) throws IOException {


				XSSFWorkbook wb = new XSSFWorkbook("C:\\Users\\60028440\\Documents\\TestLeaf\\Maven\\JavaSeleniumMay\\ReadDataFile\\LearnExcel.xlsx");

				XSSFSheet ws = wb.getSheet(fileName);
//				XSSFSheet ws = wb.getSheet("CreateLead");
				
				XSSFRow row = ws.getRow(1);
				System.out.println(row);
				
				int rowCount = ws.getLastRowNum();
				System.out.println(rowCount);
				System.out.println(ws.getPhysicalNumberOfRows());

				int cellCount = ws.getRow(1).getLastCellNum();
				System.out.println(cellCount);
				
				String[][] data = new String[rowCount][cellCount];
				int count=1;
				for(int i=1; i<=rowCount; i++) {
					for (int j = 0; j < cellCount; j++) {
						data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
						System.out.println("count: "+count + data[i-1][j]);
						count = count + 1;
					}
				}
				wb.close();
				
				return data;
		

	}

}
