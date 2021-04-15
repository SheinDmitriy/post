package shein.dmitriy.post.post.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CurrDate {

    public String getDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
