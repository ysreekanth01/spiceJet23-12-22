package com.spicejet.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExecelUtility {
	Workbook workbook;
	FileInputStream fisExcel;
	FileOutputStream fos;
	
	/**
	 * To read data from Excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	
	public String getDataFromExcel(String excelPath, String sheetName,int rowNumber, int cellNumber) {
		try {
			fisExcel=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}

	/**
	 * To write data to excel
	 * @param data
	 * @param rowNum
	 * @param cellNum
	 */
	public void setDataToExcel(String data, int rowNum, int cellNum) {
		workbook.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).setCellValue(data);
		try {
			fos=new FileOutputStream("./src/test/resources/ExpectedDataSpecialization.xlsx");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * To close the excel
	 * @throws IOException
	 */
	public void closeExcel() throws IOException 
	{
		workbook.close();
		fisExcel.close();
		
		
	
	
	}

}
