package shein.dmitriy.post.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.post.post.entytis.Liter;

import java.util.List;

@Service
public class LiterService {


    @Autowired
    public LiterService() {
    }

    public void add(Liter liter, List literList) {
        literList.add(liter);
    }
}
