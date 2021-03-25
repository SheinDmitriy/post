package shein.dmitriy.post.post.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import shein.dmitriy.post.post.entytis.Liter;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelUtil {
    public void create(List<Liter> literList) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("test");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0, CellType.STRING);
        cell.setCellValue(literList.size());

        File file = new File("D:/demo/test.xls");
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
}
