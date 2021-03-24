package shein.dmitriy.post.post.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.post.post.entytis.Liter;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class LiterService {
    private static List<Liter> literList = new ArrayList<>();

    @Autowired
    public LiterService() {
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
        System.out.println(literList.size());
    }
}
