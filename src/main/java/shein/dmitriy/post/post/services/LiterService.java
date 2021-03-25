package shein.dmitriy.post.post.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.post.post.entytis.Liter;
import shein.dmitriy.post.post.util.ExcelUtil;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class LiterService {
    private ExcelUtil excelUtil;

    private static List<Liter> literList = new ArrayList<>();

    @Autowired
    public LiterService(ExcelUtil excelUtil) {
        this.excelUtil = excelUtil;
    }

    public static void add(Liter liter) {
        literList.add(liter);
    }

    public static List<Liter> getLiterList() {
        return literList;
    }

    public void remove(String shpi) {
        Liter tmp = new Liter();
        for (Liter l: literList) {
            if (l.getShpi().equals(shpi)){
                tmp = l;
                break;
            } else {
                tmp = null;
            }
        }
        if (tmp != null){
            literList.remove(tmp);
        }
    }

    public void clear() {
        literList.clear();
    }

    public void create() {
        excelUtil.create(literList);
    }
}
