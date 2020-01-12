package com.deminmax;
import java.util.Comparator;

public class LineComparatorInConnections implements Comparator<Station> {


    @Override
    public int compare(Station o1, Station o2) {
        Double s1, s2;
        if (o1.getLine().matches("\\d+\\D")) {
            char ch = o1.getLine().charAt(o1.getLine().length() - 1);
            s1 = Double.parseDouble(o1.getLine().replaceAll("[^0-9]", "")) + Double.parseDouble(Integer.toHexString(ch)) / 1000;
        }
        else {s1 = Double.parseDouble(o1.getLine());}

        if (o2.getLine().matches("\\d+\\D")) {
            char ch = o2.getLine().charAt(o2.getLine().length() - 1);
            s2 = Double.parseDouble(o2.getLine().replaceAll("[^0-9]", "")) + Double.parseDouble(Integer.toHexString(ch)) / 1000;
        }
        else {s2 = Double.parseDouble(o2.getLine());}

        return Double.compare(s1, s2);
    }
}
