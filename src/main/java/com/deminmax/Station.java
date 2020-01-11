package com.deminmax;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(numberLine, station.numberLine) &&
                Objects.equals(nameStation, station.nameStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLine, nameStation);
    }

    @Override
    public int compareTo(Station o) {
//        return Integer.compare(Integer.parseInt(this.numberLine.replaceAll("[^0-9]", "")), Integer.parseInt(o.getLine().replaceAll("[^0-9]", "")));
        return (this.numberLine + this.nameStation.toLowerCase()).compareTo(o.numberLine + o.nameStation.toLowerCase());
    }


//    @Override
//    public int compareTo(Station s) {
////        return this.numberLine.compareTo(s.getLine()) + this.nameStation.toLowerCase().compareTo(s.nameStation.toLowerCase());
////        return (this.nameStation.toLowerCase() + this.numberLine).compareTo(s.getNameStation().toLowerCase() + s.getLine());
//        return Integer.compare(Integer.parseInt(this.numberLine.replaceAll("[^0-9]", "")), Integer.parseInt(s.getLine().replaceAll("[^0-9]", "")));
//
//    }

//    @Override
//    public int compare(Station s1, Station s2) {
//        return Integer.compare(Integer.parseInt(s1.getLine().replaceAll("[^0-9]", "")),
//                Integer.parseInt(s2.getLine().replaceAll("[^0-9]", "")));
//    }


//    @Override
//    public int compare(Station o1, Station o2) {
//        return o1.numberLine.compareTo(o2.getLine());
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Station) {
//            return this.numberLine.equals(((Station) obj).getLine());
//        }
//        return false;
//
//    }
//
//    @Override
//    public String toString() {
//        return numberLine;
//    }
//
//    @Override
//    public int compareTo(Station o) {
//        return compare(this.numberLine, o.getLine());
//    }
}

