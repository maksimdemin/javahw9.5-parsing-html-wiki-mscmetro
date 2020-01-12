package com.deminmax;
import javax.swing.text.Document;
import java.util.Comparator;

public class LineComparator implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        Double s1 = Double.parseDouble(o1.replaceAll("[^0-9]", "\\.41"));
        Double s2 = Double.parseDouble(o2.replaceAll("[^0-9]", "\\.41"));

        int result = Double.compare(s1, s2);
        if (result != 0) return result;

        return Double.compare(s1, s2);
    }
}

