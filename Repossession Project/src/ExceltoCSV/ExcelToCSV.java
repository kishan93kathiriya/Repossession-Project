package Example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToCSV {

	public static void convertToXlsx(String input, String output, String bank_name, int FileID) {
		File inputFile = new File(input);// input
		File outputFile = new File(output);// output

		// For storing data into CSV files
		StringBuffer cellValue = new StringBuffer();
		try {
			System.out.println("output file=" + outputFile);
			FileOutputStream fos = new FileOutputStream(outputFile);

			FileInputStream fin = new FileInputStream(inputFile);
			System.out.println("input file=" + inputFile);

			// Get the workbook instance for XLSX file
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));

			// Get first sheet from the workbook
			XSSFSheet sheet = wb.getSheetAt(0);

			Row row;
			Cell cell;

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int x = 0;
				int y = 1;
				while (cellIterator.hasNext() && y <= 7) {
					cell = cellIterator.next();
					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_BOOLEAN:
						cellValue.append(cell.getBooleanCellValue() + ",");
						break;

					case Cell.CELL_TYPE_NUMERIC:

						cellValue.append(cell.getNumericCellValue() + ",");
						break;

					case Cell.CELL_TYPE_STRING:

						String main = null;
						main = cell.getStringCellValue().replace(",", "").replace("\"", "").trim();
						int confirm = 1;
						if (x == 2) {
							main = cell.getStringCellValue().replace(",", "").replace(" ", "").replace("\"", "").trim();
							// System.out.println("hehe cell ="+main);
							String s1 = "";
							main = main.replace("-", "").replace("(", "").replace(")", "").replace("{", "")
									.replace("}", "").replace("[", "").replace("]", "").replace(" ", "")
									.replace("/", "").replace("*", "").replace("+", "").replace(";", "")
									.replace(",", "").replace(".", "").replace("#", "").replace("!", "")
									.replace(":", "");

							if (main.length() == 0 || main == null || main.length() < 5 || main.length() > 10) {
								cellValue.append(",");
							} else if (main.length() <= 10) {
								s1 = main.substring(0, 2);
								int p = 2;
								String ex = null;
								if (main.substring(p, p + 1).matches("[0-9]+")) {
									// s1=s1.concat(main.substring(p,p+1));
									ex = main.substring(p, p + 1);
									p = 3;
									if (main.substring(p, p + 1).matches("[0-9]+")) {
										// s1=s1.concat(main.substring(p,p+1));
										ex = ex.concat(main.substring(p, p + 1));
										p = 4;
									}
									if (ex.length() == 1) {
										s1 = s1.concat("0" + ex);
									} else {
										s1 = s1.concat(ex);
									}

								}
								if (main.substring(p, p + 1).equals("$")) {
									p = p + 1;

								} else if (!main.substring(p, p + 1).matches("[0-9]+")) {
									s1 = s1.concat(main.substring(p, p + 1));
									p = p + 1;
									if (!main.substring(p, p + 1).matches("[0-9]+")) {
										s1 = s1.concat(main.substring(p, p + 1));
										p = p + 1;
									}
								}
								if (main.substring(p).length() > 0) {
									if (main.substring(p, p + 1).matches("[0-9]+")) {
										if (main.substring(p).length() == 3) {
											s1 = s1.concat("0" + main.substring(p));
										} else if (main.substring(p).length() == 2) {
											s1 = s1.concat("00" + main.substring(p));
										} else if (main.substring(p).length() == 3) {
											s1 = s1.concat("000" + main.substring(p));
										} else if (main.substring(p).length() == 4) {
											s1 = s1.concat(main.substring(p));
										} else {
											confirm = 0;
										}

									}
								}
							}
							if (confirm == 1) {
								cellValue.append(s1 + ",");
							} else {
								cellValue.append(" ,");
							}
						} else {
							main = main.replace(",", "");
							cellValue.append(main + ",");
						}

						break;

					case Cell.CELL_TYPE_BLANK:
						cellValue.append(" " + ",");
						break;

					default:
						cellValue.append(cell + " ,");

					}
					x++;
					y++;
				}

				Date d = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

				String s = ft.format(d);

				while (x <= 9) {
					if (x <= 6) {
						cellValue.append(" ,");
					} else {
						// System.out.println("--------"+x+cellValue);
						cellValue.append("0" + ",");
						cellValue.append(bank_name + ",");
						cellValue.append(s + ",");
						// cellValue.append(FileID+",");

						x = 9;
					}
					x++;
				}

				cellValue.append(System.lineSeparator());

			}

			fos.write(cellValue.toString().getBytes());
			fos.close();
			System.out.println("Excel to CSV conversion Done!");

		}
		/*
		 * { System.out.println("output file="+outputFile); FileOutputStream fos
		 * = new FileOutputStream(outputFile);
		 * 
		 * FileInputStream fin=new FileInputStream(inputFile);
		 * System.out.println("input file="+inputFile); // Get the workbook
		 * instance for XLSX file
		 * 
		 * XSSFWorkbook wb = new XSSFWorkbook(fin);
		 * 
		 * // Get first sheet from the workbook XSSFSheet sheet =
		 * wb.getSheetAt(0);
		 * 
		 * Row row; Cell cell;
		 * 
		 * // Iterate through each rows from first sheet Iterator<Row>
		 * rowIterator = sheet.iterator();
		 * 
		 * Date d = new Date( ); SimpleDateFormat ft = new SimpleDateFormat
		 * ("dd-MM-yyyy");
		 * 
		 * while (rowIterator.hasNext()) { row = rowIterator.next(); // For each
		 * row, iterate through each columns Iterator<Cell> cellIterator =
		 * row.cellIterator(); int x=0; while (cellIterator.hasNext()) { cell =
		 * cellIterator.next(); if(cell.toString()!=null) { System.out.println(
		 * "space value ="+cell.toString()); } else {
		 * System.out.println("khikhikhi"); }
		 * 
		 * switch (cell.getCellType()) {
		 * 
		 * 
		 * case Cell.CELL_TYPE_BOOLEAN:
		 * cellValue.append(cell.getBooleanCellValue() + ","); break;
		 * 
		 * case Cell.CELL_TYPE_NUMERIC:
		 * cellValue.append(cell.getNumericCellValue() + ","); break;
		 * 
		 * case Cell.CELL_TYPE_STRING: String main=cell.getStringCellValue();
		 * if(x==2) { //System.out.println("hehe cell ="+main); String s1="";
		 * main=main.replace("-", "").replace(" ", "").replace("/",
		 * "").replace("*", "").replace("+", "").replace(";", "").replace(",",
		 * "").replace(".", "").replace(":", ""); if(main.length()==0) {
		 * cellValue.append(" ,"); } else { s1=main.substring(0, 2); int p=2;
		 * String ex=null; if(main.substring(p,p+1).matches("[0-9]+")) {
		 * //s1=s1.concat(main.substring(p,p+1)); ex=main.substring(p,p+1); p=3;
		 * if(main.substring(p,p+1).matches("[0-9]+")) { //
		 * s1=s1.concat(main.substring(p,p+1));
		 * ex=ex.concat(main.substring(p,p+1)); p=4; } if(ex.length()==1) {
		 * s1=s1.concat("0"+ex+main.substring(p)); } else {
		 * s1=s1.concat(ex+main.substring(p)); }
		 * 
		 * } }
		 * 
		 * cellValue.append(s1+ ","); } else { main=main.replace(",", "");
		 * cellValue.append(main+ ","); }
		 * 
		 * break;
		 * 
		 * case Cell.CELL_TYPE_BLANK: cellValue.append("" + ","); break;
		 * 
		 * default: cellValue.append(cell + ","); } if(cell==null ||
		 * cell.equals("")) { System.out.println("aayu"); cellValue.append(" ,"
		 * ); } x++;
		 * 
		 * } String s=ft.format(d);
		 * 
		 * 
		 * if(x==0) { cellValue.append("status" + ","); cellValue.append("bank"
		 * + ","); cellValue.append("date" + ","); } else { cellValue.append("0"
		 * + ","); cellValue.append(bank_name + ","); cellValue.append(s+",");
		 * 
		 * }
		 * 
		 * cellValue.append(System.getProperty("line.separator"));
		 * 
		 * } fos.write(cellValue.toString().getBytes()); fos.close();
		 * 
		 * }
		 */ catch (Exception e) {
			System.err.println("Exception :" + e.getMessage());
		}
	}

	static void convertToXls(File inputFile, File outputFile) {
		// For storing data into CSV files
		StringBuffer cellDData = new StringBuffer();
		try {
			FileOutputStream fos = new FileOutputStream(outputFile);

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));
			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell;
			Row row;

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();

					switch (cell.getCellType()) {

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
						cellDData.append("" + ",");
						break;

					default:
						cellDData.append(cell + ",");

					}
				}
			}

			fos.write(cellDData.toString().getBytes());
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}