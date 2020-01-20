package com.mtf.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mtf.framework.model.User;

public class PoiExcel {

	// 记录类的输出信息­

	 private static final Logger logger = Logger.getLogger(PoiExcel.class);

	// 获取Excel文档的路径­

	public static String	filePath	= "D://Masterlist.xlsx";
	
	private static List<User> userName = new ArrayList<User>();
	
	public static List<User> getUserName() {
		// 创建对Excel工作簿文件的引用­

		try {
			XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));
			// 在Excel文档中，第一张工作表的缺省索引是0，­

			// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);­

			XSSFSheet sheet = wookbook.getSheet("Staff List");

			// 获取到Excel文件中的所有行数­

			int rows = sheet.getPhysicalNumberOfRows();

			// 遍历行­

			for (int i = 0; i < rows; i++) {

				// 读取左上端单元格­

				XSSFRow row = sheet.getRow(i);

				// 行不为空­

				if (row != null) {

					// 获取到Excel文件中的所有的列­

					int cells = row.getPhysicalNumberOfCells();

					String value = "";

					// 遍历列­

					for (int j = 0; j < cells; j++) {

						// 获取到列的值­

						XSSFCell cell = row.getCell(j);

						if (cell != null) {

							switch (cell.getCellType()) {

								case XSSFCell.CELL_TYPE_FORMULA:

									break;

								case XSSFCell.CELL_TYPE_NUMERIC:

									value += cell.getNumericCellValue() + ",";

									break;

								case XSSFCell.CELL_TYPE_STRING:

									value += cell.getStringCellValue() + ",";

									break;

								default:

									value += "0";

									break;

							}

						}

					}
					// 将数据插入到mysql数据库中­

					String[] val = value.split(",");
					User user = new User();
					user.setFirstName(val[2]);
					
					
			

				}
			}

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userName;
	}
	

}
