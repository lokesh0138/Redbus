package redbus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class example {
	public ArrayList<String> getdata(String testcasename) throws IOException{
		ArrayList<String> a= new ArrayList<String>();
		// TODO Auto-generated method stub
		int k=0;
		int col=0;
		FileInputStream fis=new FileInputStream("C:\\Users\\krishna\\Documents\\data\\datasheet.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int Sheets=workbook.getNumberOfSheets();
		for(int i=0;i<Sheets;i++){
			if(workbook.getSheetName(i).equalsIgnoreCase("data2"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				Iterator<Cell> cell=firstrow.cellIterator();
				while(cell.hasNext()){
					Cell testcase=cell.next();
					if(testcase.getStringCellValue().equalsIgnoreCase(testcasename))
					{
						col=k;
					}
					k++;
				}
				
				while(rows.hasNext()){
					Row r=rows.next();
					if(r.getCell(col).getStringCellValue().equalsIgnoreCase("Yes"))
					{
						Iterator<Cell> cellvalue=r.cellIterator();
						while(cellvalue.hasNext()){
							Cell c=cellvalue.next();
							if(c.getCellTypeEnum()==CellType.STRING){
							a.add(c.getStringCellValue());	
							//String[] str=run(a);
							}
							else{
								a.add(NumberToTextConverter.toText((c.getNumericCellValue())));
								//String[] str=run(a);
							}
						}
					}
				}
			
				
			}
		
		
	}
	
	return a;
	
		
	}
	
}
