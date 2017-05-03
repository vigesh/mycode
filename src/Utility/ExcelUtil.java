package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public  class ExcelUtil {
	
	public Workbook workbook=null;
	public String Xlpath=System.getProperty("user.dir")+"\\src\\Testdata\\";
	public Hashtable<Integer, String> Hash_dict=new Hashtable<Integer, String>();
	public Sheet sheet;
	public Row row;
	public int rowcount;
	public Cell cell;
	
	public void ReadExcel(String sheetname) throws Exception{
		String xlname="testdata.xlsx";
		File file=new File(Xlpath+xlname);
		Constants.Cellvalue.clear();
		Constants.sheet_name=sheetname;
		try
		{
			FileInputStream fis=new FileInputStream(file);	
			String fileXtnName=xlname.substring(xlname.indexOf("."));
			if(fileXtnName.equalsIgnoreCase(".xlsx"))
			{
				workbook=new XSSFWorkbook(fis);
			}	
			else if(fileXtnName.equalsIgnoreCase(".xls"))
			{
				workbook=new HSSFWorkbook(fis);
				
			}
			
			sheet=workbook.getSheet(sheetname);
			rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			Constants.iterationcount=rowcount;
			int coliterator;
			ArrayList<String> cellData = new ArrayList<String>();
			cellData.clear();
				for(int rowiterator=1;rowiterator<rowcount+1; rowiterator++ )
				{					
					row=sheet.getRow(rowiterator);
					int totalcell  = row.getLastCellNum();
					for(coliterator=0; coliterator<totalcell; coliterator++)
					{
						cell = row.getCell(coliterator);
						String cellvalue=cell.getStringCellValue();
						if(!cellvalue.isEmpty())
						{
							cellData.add(cellvalue);
						}
						else
						{
							break;
						}
						Row r = sheet.getRow(0);
						String strkey = r.getCell(coliterator).getStringCellValue();
						Constants.Cellvalue.put(strkey, cellData.get(coliterator));
					}
										
				}
				
			}
			catch(Exception e)
			{
				throw(e);
			}
		
		
		}
	
			
		public String xlvalue(String Colname) throws IOException
		{
			String temp = null;
			for (Map.Entry<String, String> hashdata :  Constants.Cellvalue.entrySet())
				{
					String key = hashdata.getKey();
					String inputvalue  = hashdata.getValue();
					if (key.equals(Colname))
						{
							if (inputvalue.length()>0)
								{
									temp =inputvalue;
									break;
								}
						}
				}
		return temp;
		}

		public void ReadExcel_list(String sheetname, int rowno) throws Exception{
			String xlname="testdata.xlsx";
			File file=new File(Xlpath+xlname);
			Constants.Cellvalue.clear();
			try
			{
				FileInputStream fis=new FileInputStream(file);	
				String fileXtnName=xlname.substring(xlname.indexOf("."));
				if(fileXtnName.equalsIgnoreCase(".xlsx"))
				{
					workbook=new XSSFWorkbook(fis);
				}	
				else if(fileXtnName.equalsIgnoreCase(".xls"))
				{
					workbook=new HSSFWorkbook(fis);
					
				}
				
				sheet=workbook.getSheet(sheetname);
				rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
				int coliterator;
				ArrayList<String> cellData = new ArrayList<String>();
				cellData.clear();
					for(int rowiterator=rowno; ;)
					{		
						if(rowno<=rowcount)
						{
						row=sheet.getRow(rowiterator);
						int totalcell  = row.getLastCellNum();
						for(coliterator=0; coliterator<totalcell; coliterator++)
						{
							Cell cell;
							cell = row.getCell(coliterator);
							String cellvalue=cell.getStringCellValue();
							if(!cellvalue.isEmpty())
							{
								cellData.add(cellvalue);
							}
							else
							{
								break;
							}
							Row r = sheet.getRow(0);
							String strkey = r.getCell(coliterator).getStringCellValue();
							Constants.Cellvalue.put(strkey, cellData.get(coliterator));
						}
						break;
					}
						
											
				}
					
			}
				catch(Exception e)
				{
					throw(e);
				}
			
			
			}
		
		public void Write_excel(String Sheet_name) throws Exception
		{
			String xlname="Testdata.xlsx";
			File file=new File(Xlpath+xlname);
			Constants.Xlheader_name.clear();
			FileInputStream fis=null;
			FileOutputStream fos = null;
			try
			{
				fis=new FileInputStream(file);	
				String fileXtnName=xlname.substring(xlname.indexOf("."));
				if(fileXtnName.equalsIgnoreCase(".xlsx"))
				{
					workbook=new XSSFWorkbook(fis);
				}	
				else if(fileXtnName.equalsIgnoreCase(".xls"))
				{
					workbook=new HSSFWorkbook(fis);
					
				}
				
				sheet=workbook.getSheet(Sheet_name);
				int totalrowcount=sheet.getLastRowNum();
				row=sheet.getRow(0);
				for(int coliterator=0; coliterator<row.getLastCellNum(); coliterator++)
				{
					cell=row.getCell(coliterator);
					String col_cellvalue=cell.getStringCellValue();
					Constants.Xlheader_name.add(col_cellvalue);
				}
				List<String> celldata=new ArrayList<String>();
				celldata.add(Constants.test_name);
				celldata.add(Constants.testexe_time);
				celldata.add(Constants.Test_status);
				int currentRow=0;
				for(int setcell=0; setcell<row.getLastCellNum(); setcell++)
				{
					
					String mapkey=Constants.Xlheader_name.get(setcell);
					Constants.Writecellvalue.put(mapkey, celldata.get(setcell));
					if(setcell==0)
					{
						Row newRow=sheet.createRow(totalrowcount+1);
						Cell newCell=newRow.createCell(setcell);
						newCell.setCellValue(Constants.Writecellvalue.get(mapkey));
						currentRow=totalrowcount+1;
					}
					else
					{
						Row oldrow=sheet.getRow(currentRow);
						Cell newCell=oldrow.createCell(setcell);
						newCell.setCellValue(Constants.Writecellvalue.get(mapkey));
					}
					
					fos=new FileOutputStream(file); 
					workbook.write(fos);
				}
				
				fis.close();
				fos.close();
				
			}
			catch(Exception e)
			{
				throw(e);
			}
		}
		
		public void clear_Excel(String sheet_name) throws Exception
		{
			int rowIndex=0;
			try
			{
				  int lastRowNum=sheet.getLastRowNum();
				    if(rowIndex>0&&rowIndex<lastRowNum){
				        sheet.shiftRows(rowIndex+1,lastRowNum, -1);
				    }
				    if(rowIndex==lastRowNum){
				        Row removingRow=sheet.getRow(rowIndex);
				        if(removingRow!=null){
				            sheet.removeRow(removingRow);
				        }
				    }
				}
			
			catch(Exception e)
			{
				throw(e);
			}
		}
		
}
