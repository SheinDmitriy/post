package shein.dmitriy.post.post.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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

@Service
public class ExcelUtil {
    private static HSSFWorkbook workbook = new HSSFWorkbook();
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
        HSSFCellStyle style = workbook.createCellStyle();
        font.setFontHeight((short) 160);
        style.setFont(font);
        cell.setCellStyle(style);

    }

    private void create103_part1(List<Liter> literList) {
        HSSFSheet sheet = workbook.createSheet("list");
        HSSFFont font = workbook.createFont();
        HSSFCellStyle style = workbook.createCellStyle();

        Row row;
        Cell cell;
        //Row 0
        // Cell 7
        row = sheet.createRow(0);
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Приложение № 4");
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
        font.setFontHeight((short) 200);
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.RIGHT);
        cell.setCellStyle(style);
        //Cell 3
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("1");
        font.setFontHeight((short) 200);
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        cell.setCellStyle(style);
        //Cell 4
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("(дополнительный)");
        createStyleForCell(cell);
        //Cell 8
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("ф.103");
        font.setFontHeight((short) 160);
        font.setBold(true);
        style.setFont(font);
        cell.setCellStyle(style);

    }
}
