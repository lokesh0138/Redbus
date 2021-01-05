package redbus;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelobject {
	//FileInputStream fis=new FileInputStream("C:\\Users\\krishna\\Documents\\data\\datasheet.xlsx");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public excelobject(String path,String sheetname){
		try{
			FileInputStream fis=new FileInputStream(path);
			//String projectpath=System.getProperty("user.dir");
			//XSSFWorkbook workbook=new XSSFWorkbook(projectpath+"/resorces/data.xslx");
			 workbook=new XSSFWorkbook(fis);
			 sheet=workbook.getSheet(sheetname);
		}catch (Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}
		
	}
	/*public static void main(String[] args) {
		getRowcount();
		getceldatastring(0,4);
		getceldatanumeric(1,4);
	}*/

	public static void getRowcount(){
		try{
			/*FileInputStream fis=new FileInputStream("C:\\Users\\krishna\\Documents\\data\\datasheet.xlsx");
			//String projectpath=System.getProperty("user.dir");
			//XSSFWorkbook workbook=new XSSFWorkbook(projectpath+"/resorces/data.xslx");
			 workbook=new XSSFWorkbook(fis);
			 sheet=workbook.getSheet("data2");*/
			int rowcount=sheet.getPhysicalNumberOfRows();
			System.out.print(rowcount);
		}catch (Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}
	}
	public static void getceldatastring(int rowNum,int colNum){
		try{
			/*FileInputStream fis=new FileInputStream("C:\\Users\\krishna\\Documents\\data\\datasheet.xlsx");
			//String projectpath=System.getProperty("user.dir");
			//XSSFWorkbook workbook=new XSSFWorkbook(projectpath+"/resorces/data.xslx");
			 workbook=new XSSFWorkbook(fis);
			 sheet=workbook.getSheet("data2");*/
			String celldata=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.print(celldata);
		}catch (Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}
		
	}
	public static void getceldatanumeric(int rowNumn,int colNumn){
		try{
			/*FileInputStream fis=new FileInputStream("C:\\Users\\krishna\\Documents\\data\\datasheet.xlsx");
			//String projectpath=System.getProperty("user.dir");
			//XSSFWorkbook workbook=new XSSFWorkbook(projectpath+"/resorces/data.xslx");
			 workbook=new XSSFWorkbook(fis);
			 sheet=workbook.getSheet("data2");*/
			double celldatavalue=sheet.getRow(rowNumn).getCell(colNumn).getNumericCellValue();
			System.out.print(celldatavalue);
		}catch (Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}
		
	}
}
