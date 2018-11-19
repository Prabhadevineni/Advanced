package HDFC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Fileinput { 
	
	public static void main(String[] args) {
		
		File file = new File("test.xlsx");
		 try {
			InputStream IS = new FileInputStream(file);//Stream is creatred 
			XSSFWorkbook WB = new XSSFWorkbook(IS); //Steam as workbook
			XSSFSheet sheet = WB.getSheet("sheet1");
			System.out.println("Fisrt row is" +sheet.getFirstRowNum());
			System.out.println("Fisrt row is" +sheet.getLastRowNum());
			
			for(int i=1; i<=sheet.getLastRowNum(); i++)//pulled from 1 row, iterated till last row
			{
				System.out.println(sheet.getRow(i).getCell(0).getStringCellValue()+"\t\t");
				System.out.println(sheet.getRow(i).getCell(1).getStringCellValue()+"\n");
				
				sheet.getRow(i).createCell(2).setCellValue("result");
				IS.close();
			}
			
			OutputStream OS = new FileOutputStream(file);
			WB.write(OS);
			OS.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
