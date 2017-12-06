package Example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.CSVImportDAO;

public class ExcelToCSV1 {

	//public static  void convertToXlsx(String input, String output, String bank_name)
	public static  void convertToXlsx(File inputFile, File outputFile)
	{
	/*	File input = new File(input);// input
		File output = new File(output);// output
		*/
	// For storing data into CSV files
StringBuffer cellValue = new StringBuffer();
try 
/*{
	FileOutputStream fos = new FileOutputStream(outputFile);

	// Get the workbook instance for XLSX file
	XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));

	// Get first sheet from the workbook
	XSSFSheet sheet = wb.getSheetAt(0);

	Row row;
	Cell cell;

	// Iterate through each rows from first sheet
	Iterator<Row> rowIterator = sheet.iterator();

	while (rowIterator.hasNext()) 
	{
	row = rowIterator.next();

	
	// For each row, iterate through each columns
	Iterator<Cell> cellIterator = row.cellIterator();
	
	int x=0;
		while (cellIterator.hasNext()) 
		{
			cell = cellIterator.next();
			
			switch (cell.getCellType()) 
			{
			
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue.append(cell.getBooleanCellValue() + ",");
				break;
			
			case Cell.CELL_TYPE_NUMERIC:
				cellValue.append(cell.getNumericCellValue() + ",");
				break;
			
			case Cell.CELL_TYPE_STRING:
				
				cellValue.append(cell.getStringCellValue().replace(",", "").replace("\"", "").trim() + ",");
				break;
	
			case Cell.CELL_TYPE_BLANK:
				cellValue.append("" + ",");
				break;
				
			default:
				cellValue.append(cell + ",");
	
			}
			x++;
		}
		if(x<=9)
		{
			if(x<=6)
			{
				cellValue.append(" ,");
			}
			else
			{
				cellValue.append("0,");
				cellValue.append("SBI,");
				cellValue.append("15-07-2010,");
				x=9;
			}
		}
	
	cellValue.append(System.lineSeparator());
		
	}

fos.write(cellValue.toString().getBytes());
fos.close();

} 
*/
{
	FileOutputStream fos = new FileOutputStream(outputFile);

	System.out.println("output file="+outputFile);
//	FileOutputStream fos = new FileOutputStream(outputFile);

	FileInputStream fin=new FileInputStream(inputFile);
	System.out.println("input file="+inputFile);

	// Get the workbook instance for XLSX file
	XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));

	// Get first sheet from the workbook
	XSSFSheet sheet = wb.getSheetAt(0);

	Row row;
	Cell cell;

	// Iterate through each rows from first sheet
	Iterator<Row> rowIterator = sheet.iterator();

	 Date d = new Date( );
     SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
	

	while (rowIterator.hasNext()) 
	{
	row = rowIterator.next();

	
	// For each row, iterate through each columns
	Iterator<Cell> cellIterator = row.cellIterator();
	
	int x=0;
		while (cellIterator.hasNext()) 
		{
			cell = cellIterator.next();
			
			switch (cell.getCellType()) 
			{
			
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue.append(cell.getBooleanCellValue() + ",");
				break;
			
			case Cell.CELL_TYPE_NUMERIC:
				cellValue.append(cell.getNumericCellValue() + ",");
				break;
			
			case Cell.CELL_TYPE_STRING:
				String main=cell.getStringCellValue();
				
				if(x==2)
				{
					//System.out.println("hehe cell ="+main);
					String s1="";
					main=main.replace("-", "").replace(" ", "").replace("/", "").replace("*", "").replace("+", "").replace(";", "").replace(",", "").replace(".", "").replace(":", "");
					if(main.length()==0)
					{
						cellValue.append(" ,");
					}
					else
					{
					s1=main.substring(0, 2);
					int p=2;
					String ex=null;
					if(main.substring(p,p+1).matches("[0-9]+"))
					{
						//s1=s1.concat(main.substring(p,p+1));
						ex=main.substring(p,p+1);
						p=3;
						if(main.substring(p,p+1).matches("[0-9]+"))
						{
						//	s1=s1.concat(main.substring(p,p+1));
							ex=ex.concat(main.substring(p,p+1));
							p=4;
						}
						if(ex.length()==1)
						{
							s1=s1.concat("0"+ex+main.substring(p));	
						}
						else
						{
							s1=s1.concat(ex+main.substring(p));
						}
	
					}	
					}
					
					cellValue.append(s1+ ",");
				}
				else
				{
					main=main.replace(",", "");
					cellValue.append(main+ ",");
				}
				

				break;
	
			case Cell.CELL_TYPE_BLANK:
				cellValue.append("jvhd" + ",");
				break;
				
			default:
				cellValue.append(cell + "jdvgjsdg,");
	
			}
			x++;
		}

		String s=ft.format(d);
		
		
		while(x<=9)
		{
			if(x<=6)
			{
				cellValue.append(" ,");
				
			}
			else
			{
				cellValue.append("0" + ",");
				cellValue.append("bank" + ",");
				cellValue.append(s+",");
				
				x=9;
			}
			x++;
		}
	
		cellValue.append(System.lineSeparator());
	
	}
	
	fos.write(cellValue.toString().getBytes());
	fos.close();

} 



catch (Exception e) 
{
	System.err.println("Exception :" + e.getMessage());
}
}

static void convertToXls(File inputFile, File outputFile) 
{
// For storing data into CSV files
StringBuffer cellDData = new StringBuffer();
try 
{
	FileOutputStream fos = new FileOutputStream(outputFile);

	// Get the workbook instance for XLS file
	HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));
	// Get first sheet from the workbook
	HSSFSheet sheet = workbook.getSheetAt(0);
	Cell cell;
	Row row;

	// Iterate through each rows from first sheet
	Iterator<Row> rowIterator = sheet.iterator();
	while (rowIterator.hasNext()) 
	{
	row = rowIterator.next();

	// For each row, iterate through each columns
	Iterator<Cell> cellIterator = row.cellIterator();
	while (cellIterator.hasNext()) 
	{
	cell = cellIterator.next();

	switch (cell.getCellType()) 
	{
	
	case Cell.CELL_TYPE_BOOLEAN:
		cellDData.append(cell.getBooleanCellValue() + ",");
		break;
	
	case Cell.CELL_TYPE_NUMERIC:
		cellDData.append(cell.getNumericCellValue() + ",");
		break;
	
	case Cell.CELL_TYPE_STRING:
		cellDData.append(cell.getStringCellValue() + ",");
		break;

	case Cell.CELL_TYPE_BLANK:
		cellDData.append(" dkmd" + ",");
		break;
		
	default:
		cellDData.append(cell + ",");

	}
	cellDData.append(System.lineSeparator());
	}
	}

fos.write(cellDData.toString().getBytes());
fos.close();

}
catch (FileNotFoundException e) 
{
    System.err.println("Exception" + e.getMessage());
} 
catch (IOException e) 
{
	System.err.println("Exception" + e.getMessage());
}
System.out.println("Done");
}

public static void main(String[] args) 
{
	File inputFile = new File("C:\\input.xls");
	File outputFile = new File("C:\\output1.csv");
	
	File inputFile2 = new File("C:\\Users\\KISHAN\\Desktop\\indusins gj list.xlsx");
	File outputFile2 = new File("C:\\Users\\KISHAN\\Desktop\\1.csv");
	
	convertToXlsx(inputFile2, outputFile2);
	  CSVImportDAO x=new CSVImportDAO();
      x.importCSV("C:\\Users\\KISHAN\\Desktop\\1.csv");
      x.deleteDuplicate();
     
		//convertToXls(inputFile, outputFile);
		
	}
}