package redbus;


	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.util.NumberToTextConverter;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	public class excel {
		public static void main(String[] args) {
			String fis="C:\\Users\\krishna\\Documents\\data\\datasheet.xlsx";
			String name ="data2";
			excelobject ex=new excelobject(fis, name);
			ex.getRowcount();
			ex.getceldatastring(0, 2);
			ex.getceldatanumeric(1, 4);
			
		}
		
		
		

	}


