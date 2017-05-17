package com.iss.util;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

/**
 * POI Excel处理类
 */
public class PoiExcelUtil {
	/**
	 * 设置某些列的值只能输入预制的数据,显示下拉框.
	 * @param sheet 要设置的sheet.
	 * @param explicitList 下拉框显示的内容
	 * @param firstRow 开始行
	 * @param lastRow 结束行
	 * @param firstCol 开始列
	 * @param lastCol 结束列
	 * @return sheet.
	 */
	public static Sheet setValidationData(Sheet sheet, String[] explicitList,
			int firstRow, int lastRow, int firstCol, int lastCol) {
		// 加载下拉列表内容
		DVConstraint constraint = DVConstraint.createExplicitListConstraint(explicitList);
		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList rangeAddress = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
		// 数据有效性对象
		DataValidation dv = new HSSFDataValidation(rangeAddress, constraint);
		sheet.addValidationData(dv);
		return sheet;
	}
	
	/**
	 * 处理大数据显示下拉框引用.（解决异常：String literals in formulas can't be bigger than 255 Chars ASCII）
	 * @param workbook Excel对象
	 * @param sheet 要设置的sheet.
	 * @param explicitList 下拉框显示的内容
	 * @param firstRow 开始行
	 * @param lastRow 结束行
	 * @param firstCol 开始列
	 * @param lastCol 结束列
	 * @return sheet.
	 */
	public static Sheet setValidationData(Workbook workbook, Sheet sheet, String[] explicitList,
			int firstRow, int lastRow, int firstCol, int lastCol){
        Sheet hidden = workbook.createSheet("hidden");//数据源sheet页不显示
        workbook.setSheetHidden(workbook.getSheetIndex(hidden), true);
        for (int i = 0; i <explicitList.length; i++){
        	Row row = hidden.createRow(i);
        	Cell cell = row.createCell(firstCol);
            cell.setCellValue(explicitList[i]);
        }
        Name namedCell = workbook.createName();
        namedCell.setNameName("hidden");
        namedCell.setRefersToFormula("hidden!A$1:A$" + explicitList.length);
        HSSFDataValidationHelper dvHelper = new HSSFDataValidationHelper((HSSFSheet) sheet);
        DataValidationConstraint constraint = dvHelper.createFormulaListConstraint("hidden");
 		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
 		CellRangeAddressList rangeAddress = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
 		// 数据有效性对象
 		DataValidation dv = dvHelper.createValidation(constraint, rangeAddress);
 		sheet.addValidationData(dv);
 		return sheet;
	} 
	
	/** 
     * 设置单元格上提示 
     * @param sheet  要设置的sheet. 
     * @param promptTitle 标题 
     * @param promptContent 内容 
	 * @param firstRow 开始行
	 * @param lastRow 结束行
	 * @param firstCol 开始列
	 * @param lastCol 结束列
     * @return sheet. 
     */  
    public static Sheet setHSSFPrompt(Sheet sheet, String promptTitle,  
            String promptContent, int firstRow, int lastRow, int firstCol, int lastCol) {  
        // 构造constraint对象  
        DVConstraint constraint = DVConstraint.createCustomFormulaConstraint("BB1");  
        // 四个参数分别是：起始行、终止行、起始列、终止列  
        CellRangeAddressList rangeAddress = new CellRangeAddressList(firstRow, firstRow, firstCol, firstCol);  
        // 数据有效性对象  
        DataValidation dv = new HSSFDataValidation(rangeAddress, constraint);  
        dv.createPromptBox(promptTitle, promptContent);  
        sheet.addValidationData(dv);  
        return sheet;  
    }
}
