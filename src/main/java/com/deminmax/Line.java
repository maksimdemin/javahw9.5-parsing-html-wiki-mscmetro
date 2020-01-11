package com.deminmax;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(numberLine, line.numberLine) &&
                Objects.equals(nameLine, line.nameLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLine, nameLine);
    }

    @Override
    public int compareTo(Line o) {
//        return Integer.compare(Integer.parseInt(this.nameLine.replaceAll("[^0-9]", "")), Integer.parseInt(o.getNumber().replaceAll("[^0-9]", "")));
        return (this.numberLine + this.nameLine.toLowerCase()).compareTo(o.numberLine + o.nameLine.toLowerCase());
    }


//    @Override
//    public int compareTo(Line l) {
////        return this.number.compareTo(l.number) + this.name.toLowerCase().compareTo(l.name.toLowerCase());
////        return Integer.compare(Integer.parseInt(l.getNumber()), Integer.parseInt(this.numberLine));
////        return this.numberLine.compareTo(l.getNumber()) + this.nameLine.toLowerCase().compareTo(l.nameLine.toLowerCase());
////        return (this.nameLine.toLowerCase() + this.numberLine).compareTo(l.getName().toLowerCase() + l.getNumber());
//        return compare(this.numberLine, l.getNumber());
//
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Line)
//            return this.numberLine.equals(((Line) obj).getNumber());
//        return false;
//    }
//
//
//    @Override
//    public String toString() {
//        return numberLine;
//    }
//
////    @Override
////    public Comparator<Line> thenComparing(Comparator<? super Line> other) {
////        return Comparator.comparing(Line::getNumber);
////    }
}