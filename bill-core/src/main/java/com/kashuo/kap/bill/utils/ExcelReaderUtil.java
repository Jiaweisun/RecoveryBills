package com.kashuo.kap.bill.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by sunjiawei on 2017/4/14.
 */
public class ExcelReaderUtil {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * @param path excel file pathName
     * @return Excel文件
     * @throws Exception
     */
    private HSSFWorkbook getExcelByName(String path)throws Exception{
        //Excel文件
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(path)));
        return wb;
    }


    /**
     * @param workBook excel
     * @return 有效的表单页
     */
    private ArrayList<HSSFSheet> getSheets(HSSFWorkbook workBook){

        //获取excel的所有表单页
        int  sheetCount = workBook.getNumberOfSheets();

        ArrayList<HSSFSheet> sheets = new ArrayList<>();
        HSSFSheet sheet = null;
        for(int x=0;x<sheetCount; x++){
            String sheetName = workBook.getSheetName(x);
//            System.out.println("第"+(x+1)+"页的名字是："+sheetName+" ");

            HSSFSheet tempSheet = workBook.getSheetAt(x);
            if (tempSheet.getLastRowNum()<=0) {
//                System.out.println("第"+(x+1)+"表单是空的，所以丢弃。 ");
                continue;
            }
            sheet = tempSheet;
            sheets.add(sheet);
        }
        System.out.println("该excel包含  "+sheets.size()+" 页");
        return sheets;
    }

    /**
     * 读取包含合并单元格的内容
     * @param sheet 表单
     * @param count 存在的合并单元格的量, 不存在则为0
     */
    private void readContentWithMergedRegions(HSSFSheet sheet, int count){

        //获得总行数
        int lastRowNumber = sheet.getLastRowNum()+1;
        if (lastRowNumber <=0)return;

        System.out.println("一共 "+lastRowNumber+" 行 .......withmmmm");
        for (int i = 0; i<lastRowNumber; i++) {
            boolean isMerg = false;
            HSSFRow row =null;
            int startRow= 0 ,endRow = 0 ,startCell=0 ,endCell = 0;
                //合并单元格行
                for (int p = 0; p<count; p++){
                    CellRangeAddress oldRange=sheet.getMergedRegion(p);
                    startRow =oldRange.getFirstRow();//起始行
                    endRow = oldRange.getLastRow();//结束行
                    startCell =oldRange.getFirstColumn();//起始列
                    endCell =oldRange.getLastColumn();//结束列

                    if (i == startRow && endRow>startRow){
                        row = sheet.getRow(i);
                        i = endRow;
                        isMerg = true;
                        System.out.println("表单中有 "+count+" 处合并单元格, 第 "+(p+1)+" 处的起始行："+startRow+" ,结束行："+endRow
                                +" ， 起始列："+startCell+"  ，结束列： "+endCell);
                        break;
                    }else{
                        row = sheet.getRow(i);
                    }
                }
            readCell(row,startCell,endCell,isMerg);
        }
    }

    /**
     * 读取行中的所有列
     * @param row 单个行
     * @param startCell 合并单元格的起始列 ， 非合并单元格 startCell = 0
     * @param endCell 合并单元格的终止列， 非合并单元格 endCell = 0
     * @param isMerg 是否存在合并单元格, 非合并单元格 isMerg = false
     */
    private void readCell(HSSFRow row, int startCell,int endCell, boolean isMerg){
        if (endCell >startCell && isMerg){ //读取合并单元格的内容
            HSSFCell cell = row.getCell(startCell);
            String cellValue = getByType(cell);
            System.out.println("合并单元格列值：" + cellValue);
        }
        else{
            //获取总列数目
            int totalCell = row.getLastCellNum();
            System.out.println("*************一共 " + totalCell + " 列***************");
            if (totalCell <= 0) return;

            for (int j = 0; j < totalCell; j++) {
                HSSFCell cell = row.getCell(j);
                String cellValue = getByType(cell);
                System.out.println("第" + (j + 1) + "列：" + cellValue);
            }
        }
    }


    /**
     * 根据列内容类型返回String
     * @param cell 列
     * @return
     */
    private  String getByType(HSSFCell cell){
        String cellValue = "";
        int x = cell.getCellType();
        switch (x) {
            case 0://数字型
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case 1://字符串
                cellValue = cell.getStringCellValue();
                break;
        }
        return cellValue;
    }

    /**
     * 导入 excel demo
     * @throws Exception
     */
    public void testImport() throws Exception {
        //Excel文件
        HSSFWorkbook wb = this.getExcelByName("classpath:0605-normal.xlsx");
        log.error("wb{}",wb);
        ArrayList<HSSFSheet> sheets = this.getSheets(wb);

        for (HSSFSheet tempSheet: sheets){
            //判断每个表单是否包含合并单元格
            int regionsCount = tempSheet.getNumMergedRegions();
            this.readContentWithMergedRegions(tempSheet,regionsCount);
        }
    }



    public static void main(String [] args){
        ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil();
        try {
            excelReaderUtil.testImport();
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
