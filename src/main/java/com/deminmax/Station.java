package com.deminmax;

import java.util.Comparator;

public class Station implements Comparable<Station> {

    private String numberLine;
    private String nameStation;


    public Station(String line, String name)
    {
        this.numberLine = line;
        this.nameStation = name;
    }

    public String  getLine()
    {
        return numberLine;
    }

    public String getNameStation()
    {
        return nameStation;
    }

    @Override
    public int compareTo(Station s) {
        return this.numberLine.compareTo(s.getLine()) + this.nameStation.toLowerCase().compareTo(s.nameStation.toLowerCase());
    }


//    @Override
//    public int compare(Station o1, Station o2) {
//        return o1.numberLine.compareTo(o2.getLine());
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Station) {
            return this.numberLine.equals(((Station) obj).getLine());
        }
        return false;

    }

    @Override
    public String toString() {
        return numberLine;
    }

}

