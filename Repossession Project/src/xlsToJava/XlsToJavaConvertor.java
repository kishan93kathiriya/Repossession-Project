package xlsToJava;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vo.AttachmentMappingVO;
import vo.list_vehicles;

public class XlsToJavaConvertor {

	public List<list_vehicles> readXLS(AttachmentMappingVO attachmentMappingVO, List<Integer> headers, String bankName, String time) {

		try {

			System.out.println("==========================================================================");

			File file = new File(attachmentMappingVO.getPath());

			// POIFSFileSystem fs = new POIFSFileSystem();
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet;
			XSSFRow row;
			XSSFCell cell;

			int numSheets = wb.getNumberOfSheets();

			List<list_vehicles> list_vehicles = new ArrayList<list_vehicles>();

			for (int j = 0; j < numSheets; j++) {

				sheet = wb.getSheetAt(j);

				int rows; // No of rows
				rows = sheet.getPhysicalNumberOfRows();

				int cols = 0; // No of columns
				int tmp = 0;

				// This trick ensures that we get the data properly even if it
				// doesn't start from first few rows
				for (int i = 0; i < 10 || i < rows; i++) {
					row = sheet.getRow(i);
					if (row != null) {
						tmp = sheet.getRow(i).getPhysicalNumberOfCells();
						if (tmp > cols)
							cols = tmp;
					}
				}

				int k= 0;
				for (int r = 0; r < rows; r++) {
					row = sheet.getRow(r);
					
					if (row != null) {
						
						if(k>0){
						
							list_vehicles list_vehicle = new list_vehicles();
	
							int i = 0;
							for (int c : headers) {
	
								cell = row.getCell(c);
	
								if (cell != null) {
									// Your code here
									String val = new String();
	
									if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
										val = Double.toString(cell.getNumericCellValue());
									} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
										val = cell.getStringCellValue();
									} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
										val = cell.getCellFormula();
									} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
										val = ((Boolean) cell.getBooleanCellValue()).toString();
									}
	
									if (i == 0) {
										list_vehicle.setLoanNo(val);
									} else if (i == 1) {
										list_vehicle.setCustomerName(val);
									} else if (i == 2) {
										list_vehicle.setReg_No(val);
									} else if (i == 3) {
										list_vehicle.setModel(val);
									} else if (i == 4) {
										list_vehicle.setChasis_No(val);
									} else if (i == 5) {
										list_vehicle.setEngine_No(val);
									} else if (i == 6) {
										list_vehicle.setContact(val);
									}
									else if (i > 6) {
										String tmp1 = list_vehicle.getContact();
										tmp1 = tmp1 +"," +val;
										
										list_vehicle.setContact(val);
									}
									i++;
								}
							}
							
							list_vehicle.setDate(time);
							list_vehicle.setBank(bankName);
							
							list_vehicles.add(list_vehicle);
							
						}
						k++;
					}
				}
			}
			System.out.println(bankName);

			System.out.println("==========================================================================");

			return list_vehicles;

		} catch (Exception ioe) {
			ioe.printStackTrace();
			return null;
		}

	}

	public void printXLS(AttachmentMappingVO attachmentMappingVO) {
		// TODO Auto-generated method stub

		try {

			System.out.println("==========================================================================");

			File file = new File(attachmentMappingVO.getPath());

			// POIFSFileSystem fs = new POIFSFileSystem();
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet;
			XSSFRow row;
			XSSFCell cell;

			int numSheets = wb.getNumberOfSheets();

			for (int j = 0; j < numSheets; j++) {

				sheet = wb.getSheetAt(j);

				int rows; // No of rows
				rows = sheet.getPhysicalNumberOfRows();

				int cols = 0; // No of columns
				int tmp = 0;

				// This trick ensures that we get the data properly even if it
				// doesn't start from first few rows
				for (int i = 0; i < 10 || i < rows; i++) {
					row = sheet.getRow(i);
					if (row != null) {
						tmp = sheet.getRow(i).getPhysicalNumberOfCells();
						if (tmp > cols)
							cols = tmp;
					}
				}

				boolean label = true;
				for (int r = 0; r < rows; r++) {
					row = sheet.getRow(r);
					if (row != null) {

						for (int c = 0; c < cols; c++) {
							cell = row.getCell((short) c);
							if (cell != null) {
								// Your code here
								if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									System.out.println("Cell Numeric Value: " + cell.getNumericCellValue());
								}
								if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									System.out.println("Cell String Value: " + cell.getStringCellValue());
								}
								if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
									System.out.println("Cell Formula Value: " + cell.getCellFormula());
								}
								if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
									System.out.println("Cell error Value: " + cell.getErrorCellValue());
								}
								if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
									System.out.println("Cell boolean Value: " + cell.getBooleanCellValue());
								}
							}
						}

					}
					System.out.println();
				}

			}

			System.out.println("==========================================================================");

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

	public HashMap<Integer, String> readXLSHeaders(AttachmentMappingVO attachmentMappingVO) {
		// TODO Auto-generated method stub

		try {

			System.out.println("==========================================================================");

			File file = new File(attachmentMappingVO.getPath());

			// POIFSFileSystem fs = new POIFSFileSystem();
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet;
			XSSFRow row;
			XSSFCell cell;

			int numSheets = wb.getNumberOfSheets();

			HashMap<Integer, String> headerList = new HashMap<Integer, String>();

			for (int j = 0; j < numSheets; j++) {

				sheet = wb.getSheetAt(j);

				int rows; // No of rows
				
				rows = sheet.getPhysicalNumberOfRows();

				int cols = 0; // No of columns
				int tmp = 0;

				// This trick ensures that we get the data properly even if it
				// doesn't start from first few rows
				for (int i = 0; i < 10 || i < rows; i++) {
					row = sheet.getRow(i);
					if (row != null) {
						tmp = sheet.getRow(i).getPhysicalNumberOfCells();
						if (tmp > cols)
							cols = tmp;
					}
				}

				int i = 0;
				for (int r = 0; r < rows; r++) {
					row = sheet.getRow(r);

					if (row != null && i == 0) {

						i++;

						for (int c = 0; c < cols; c++) {
							cell = row.getCell((short) c);
							if (cell != null) {
								// Your code here

								String val = new String();

								if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									val = Double.toString(cell.getNumericCellValue());
									System.out.println("Cell Header Numeric Value: " + val);
								}
								if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
									val = cell.getStringCellValue();
									System.out.println("Cell Header String Value: " + val);
								}
								if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
									val = cell.getCellFormula().toString();
									System.out.println("Cell Header Formula Value: " + val);
								}
								if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
									val = ((Boolean) cell.getBooleanCellValue()).toString();
									System.out.println("Cell Header boolean Value: " + val);
								}

								headerList.put(c, val.trim());
							}
						}

					}
					System.out.println();
				}
			}

			System.out.println("==========================================================================");

			return headerList;

		} catch (Exception ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
			return null;
		}
	}

}
