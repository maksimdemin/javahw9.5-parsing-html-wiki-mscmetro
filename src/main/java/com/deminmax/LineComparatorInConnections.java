package com.deminmax;
import java.util.Comparator;

public class LineComparatorInConnections implements Comparator<Station> {


    @Override
    public int compare(Station o1, Station o2) {
        Double s1 = Double.parseDouble(o1.getLine().replaceAll("[^0-9]", "\\.41"));
        Double s2 = Double.parseDouble(o2.getLine().replaceAll("[^0-9]", "\\.41"));

        int result = Double.compare(s1, s2);
        if (result != 0) return result;

        return Double.compare(s1, s2);
    }
}
