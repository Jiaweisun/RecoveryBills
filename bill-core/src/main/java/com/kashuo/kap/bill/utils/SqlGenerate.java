package com.kashuo.kap.bill.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

public class SqlGenerate {
    private static final Logger LOG = Logger.getLogger("");
    private static final String out_put_name = LocalDate.now().getDayOfMonth()+"result.txt";
    private static  final String noramlName = "standard-danbianzhang0614.xlsx";
    private static  final String bankName = "standard-bank-danbianzhang0602.xlsx";
    private static boolean seq = false;

    public static void main(String[] args) throws IOException {
        String sql = readFromFile(ConstantUtil.NORMAL_SQL);
        outputBySql(sql, ConstantUtil.BASE_FILE_PATH+""+noramlName,1);

//        String sql = readFromFile(ConstantUtil.BANK_SQL);
//        outputBySql(sql, ConstantUtil.BASE_FILE_PATH+""+bankName,2);
    }


    public static void outputBySql(String sql_template, String base_dir,int flag) throws IOException {
        Map<Integer, String> map = getMap();
        for (Map.Entry<Integer, String> column : map.entrySet()) {
            Integer key = (Integer) column.getKey();
            String value = (String) column.getValue();
            sql_template = sql_template.replace("${" + value + "}", "${" + key +
                    "}");
        }
        readOutputFile(sql_template,base_dir,flag);
    }

    public static void readOutputFile(String sql_template, String base_dir,int flag) throws IOException{
        Workbook book = null;
        Object sql_list = new ArrayList();

        File f = new File(out_put_name);
        FileWriter fw = null;
        BufferedWriter out = null;
        FileInputStream fis = null;
        if (f.exists()) {
            f.delete();
        }

        try {
            f.createNewFile();
            fw = new FileWriter(f, true);
            out = new BufferedWriter(fw);
            fis = new FileInputStream(new File(base_dir));

            book = getWorkBook(fis);
            int sheetNums = book.getNumberOfSheets();
            if (sheetNums == 0) {
                return;
            }
            List list;
            Map<String, Object> row_map;
            String sql_tmp;
            int count =0;
            for (int i = 0; i < sheetNums; i++) {
                Sheet sheet = getSheet(book, i);
                list = getSheetVal(sheet);
                if ((list != null) && (list.size() != 0)) {
                    for (int j = 0; j < list.size(); j++) {
                        if (j != 0) {
                            row_map = (Map) list.get(j);
                            sql_tmp = sql_template;
                            for (Map.Entry column : row_map.entrySet()) {
                                String key = (String) column.getKey();
                                Object value = column.getValue();
                                String sql_str = "";
                                if ((value != null) &&(!value.toString().trim().equals(""))) {
                                    sql_str = value.toString();
                                }
                                sql_tmp =sql_tmp.replace("${" + key + "}", sql_str.trim());
                            }
                            if(flag==1) {
                                sql_tmp = sql_tmp.replaceAll("'?\\$\\{\\d{1,2}\\}'?","NULL");
                            }
                            ((List) sql_list).add(sql_tmp);
                        }
                    }
                }
            }
            output((List) sql_list,out,flag);
        } catch (IOException e) {
            LOG.info(e.getMessage());
        }finally {
            out.flush();
            out.close();
            if(fw!=null) {
                fw.close();
            }
        }

    }

    public static void output(List sql_list,BufferedWriter out, int flag) throws IOException {
        int i = 1;

        if(flag==1) {
            out.write("-- 普通漏单"+"\r\n");
        }else if(flag==2){
            out.write("-- 银行漏单"+"\r\n");
        }

        for (Object str : (List) sql_list) {
            if (seq) {
                out.write("-- " + i++ + "\n" + str + "\n\n");
            } else {
                String resultString = str.toString();
                String selqectSql = resultString.substring(resultString.indexOf("<")+1, resultString.indexOf(">"));
                String insertSql = resultString.substring(resultString.indexOf("<<") + 2, resultString.indexOf(">>")) + "\r\n" + "\r\n";
                //如果是普通漏单
                if(flag==1) {
//                         Boolean haveData =  FindData.selectData(selqectSql);
//                         if(!haveData) {
                    LOG.info(selqectSql);
//                    out.write(selqectSql.split("\n")[0].replace("<","")+"\r\n"+insertSql + "\r\n" );
//                         }else{
                    out.write("-- 待处理："+selqectSql + "\r\n" + insertSql+"\r\n");
//                         }
                }else if(flag==2){
//                        Map<String,String> resultMap = FindData.selectDataBank(selqectSql);
//                        if("0".equals(resultMap.get("status"))){
//                            out.write(selqectSql.split("\n")[0].replace("<","")+"\r\n"+insertSql.replace("{trans_no}",resultMap.get("trans_no")) + "\r\n" );
//                        }else if("1".equals(resultMap.get("status"))||"4".equals(resultMap.get("status"))){//交给活动配置处理
//                            out.write("status:"+resultMap.get("status")+ "\r\n" +"trans_no:"+ resultMap.get("trans_no")+"\r\n");
//                        }else if("-1".equals(resultMap.get("status"))){
//                            out.write("---待处理："+selqectSql + "\r\n" + insertSql+"\r\n");
//                        }
                    System.out.println(selqectSql);
                }
            }
        }
    }









    public static String readFromFile(String path)
    {
        File file = new File(path);
        if ((!file.exists()) || (file.isDirectory()))
        {
            LOG.info("文件不存在，或文件是个路径");
            return null;
        }
        String data = null;
        StringBuffer sb = new StringBuffer();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));)
        {
            while ((data = br.readLine()) != null) {
                sb.append(data + "\n");
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException localIOException) {}
        return sb.toString();
    }

    public static Workbook getWorkBook(InputStream in)
    {
        Workbook book = null;
        try
        {
            book = WorkbookFactory.create(in);
        }
        catch (Exception localException) {}
        return book;
    }

    public static Sheet getSheet(Workbook book, int index)
    {
        if (book != null) {
            return book.getSheetAt(index);
        }
        return null;
    }

    public static List<Map<String, Object>> getSheetVal(Sheet sheet)
    {
        if (sheet == null) {
            return null;
        }
        List list = new ArrayList();
        int rowCount = sheet.getLastRowNum() + 1;
        for (int i = 0; i < rowCount; i++)
        {
            Row row = sheet.getRow(i);
            if (row != null)
            {
                Map map = getRowVal(row);
                if ((map != null) && (map.size() > 0)) {
                    list.add(map);
                }
            }
        }
        return list;
    }

    public static Map<String, Object> getRowVal(Row row)
    {
        Map map = new HashMap();
        if (row == null) {
            return map;
        }
        int cellCount = row.getLastCellNum() + 1;
        for (int i = 0; i < cellCount; i++)
        {
            String index = String.valueOf(i);
            Cell cell = row.getCell(i);
            if (cell != null) {
                switch (cell.getCellType())
                {
                    case 0:
                        if (DateUtil.isCellDateFormatted(cell))
                        {
                            Date inputValue = cell.getDateCellValue();
                            map.put(index, inputValue);
                        }
                        else
                        {
                            Double doubleValue = Double.valueOf(cell
                                    .getNumericCellValue());
                            DecimalFormat df = new DecimalFormat("#.#########");
                            map.put(index, df.format(cell.getNumericCellValue()));
                        }
                        break;
                    case 1:
                        String str = cell.getStringCellValue();
                        if ((str != null) && (!"".equals(str.trim()))) {
                            map.put(index, cell.getStringCellValue());
                        }
                        break;
                    case 4:
                        map.put(index, Boolean.valueOf(cell.getBooleanCellValue()));
                }
            }
        }
        return map;
    }

    public static Map<Integer, String> getMap()
    {
        String[] A = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        String[] B = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        int i = 0;

        Map<Integer, String> map = new HashMap();
        for (int j = 0; j < A.length; j++) {
            map.put(Integer.valueOf(i++), A[j]);
        }
        for (int k = 0; k < A.length; k++) {
            for (int m = 0; m < B.length; m++) {
                map.put(Integer.valueOf(i++), A[k] + B[m]);
            }
        }
        return map;
    }

    private static boolean convert(String i)
    {
        if (i.equals("1")) {
            return true;
        }
        return false;
    }
}
