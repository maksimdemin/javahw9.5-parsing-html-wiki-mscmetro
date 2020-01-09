package com.deminmax;


import java.util.Comparator;

public class Line implements Comparable<Line> {
    private String numberLine;
    private String nameLine;
    private String colorLine;

    public Line(String  number, String name)
    {
        this.numberLine = number;
        this.nameLine = name;
    }

    public String getNumber() {
        return numberLine;
    }

    public String getName() {
        return nameLine;
    }


    @Override
    public int compareTo(Line l) {
//        return this.number.compareTo(l.number) + this.name.toLowerCase().compareTo(l.name.toLowerCase());
//        return Integer.compare(Integer.parseInt(l.getNumber()), Integer.parseInt(this.numberLine));
        return this.numberLine.compareTo(l.getNumber()) + this.nameLine.toLowerCase().compareTo(l.nameLine.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line)
            return this.numberLine.equals(((Line) obj).getNumber());
        return false;
    }


    @Override
    public String toString() {
        return numberLine;
    }

//    @Override
//    public Comparator<Line> thenComparing(Comparator<? super Line> other) {
//        return Comparator.comparing(Line::getNumber);
//    }
}