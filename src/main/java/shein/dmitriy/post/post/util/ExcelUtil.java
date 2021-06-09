package shein.dmitriy.post.post.util;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.post.post.entytis.Liter;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.usermodel.HorizontalAlignment.*;

@Service
public class ExcelUtil {
    private static HSSFWorkbook workbook = new HSSFWorkbook();
    private static HSSFSheet sheet = workbook.createSheet("list");
    private CurrDate currDate;

    @Autowired
    public ExcelUtil(CurrDate currDate) {
        this.currDate = currDate;
    }

    public void create(List<Liter> literList) {

        create103_part1(literList);

        File file = new File("C:/Post/" + currDate.getDate() + ".xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = null;
        try {
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createStyleForCell(Cell cell) {
        HSSFFont font = workbook.createFont();
        CellStyle style = workbook.createCellStyle();
        font.setFontHeight((short) 140);
        style.setFont(font);
        cell.setCellStyle(style);

    }

    private void create103_part1(List<Liter> literList) {

        sheet.setColumnWidth(0, 1750);
        sheet.setColumnWidth(1, 14364);
        sheet.setColumnWidth(2, 4265);
        sheet.setColumnWidth(3, 2515);
        sheet.setColumnWidth(4, 2770);
        sheet.setColumnWidth(5, 2770);
        sheet.setColumnWidth(6, 2770);
        sheet.setColumnWidth(7, 2770);
        sheet.setColumnWidth(8, 5832);

        Row row;
        Cell cell;
        //Row 0
        // Cell 7
        row = sheet.createRow(0);
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Приложение № 4");
//        cell.setCellStyle(style);
        createStyleForCell(cell);
        //Row 2
        // Cell 7
        row = sheet.createRow(2);
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("АНФ 14/01");
        createStyleForCell(cell);
        //Row 3
        // Cell 7
        row = sheet.createRow(3);
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Утверждена");
        createStyleForCell(cell);
        //Row 4
        // Cell 7
        row = sheet.createRow(4);
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("приказом ФГУП 'Почта России'");
        createStyleForCell(cell);
        //Row 5
        // Cell 7
        row = sheet.createRow(5);
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("от 06.09.2010 № 330-п");
        createStyleForCell(cell);
        //Row 7
        //Cell 2
        row = sheet.createRow(7);
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("СПИСОК №");
        createStyleForCell(cell);
        setFontBold(cell);
        setCellAlign(cell, "right");
        //Cell 4
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("(дополнительный)");
        //Cell 8
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("ф.103");
        setCellAlign(cell, "center");
        //Row 8
        //Cell 1
        row = sheet.createRow(8);
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("внутрених почтовых отправлений");
        createStyleForCell(cell);
        setFontBold(cell);
        //Row 8
        //Cell 1
        row = sheet.createRow(9);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("от");
        createStyleForCell(cell);
        setCellAlign(cell, "right");
        //Cell 2
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue(currDate.getDate());
        createStyleForCell(cell);
        setBorderBottom(cell);
        setCellAlign(cell, "center");
    }

    private void setBorderBottom(Cell cell, String align) {
        CellStyle style ;
        style = cell.getCellStyle();
        switch ()
        style.setBorderBottom(BorderStyle.THIN);
        cell.setCellStyle(style);
    }

    private void setFontBold(Cell cell){
        HSSFFont font = workbook.createFont();
        CellStyle style ;
        style = cell.getCellStyle();
        font.setBold(true);
        style.setFont(font);
        cell.setCellStyle(style);
    }

    private void setCellAlign(Cell cell, String aling){

        CellStyle style ;
        style = cell.getCellStyle();
        switch (aling){
            case "left":
                style.setAlignment(LEFT);
                break;
            case "right":
                style.setAlignment(RIGHT);
                break;
            case "center":
                style.setAlignment(CENTER);
                break;
        }
        cell.setCellStyle(style);
    }
}
