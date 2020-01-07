package com.deminmax;

public class Station implements Comparable<Station> {

    private String nameStation;
    private String numberLine;


    public Station(String name, String line)
    {
        this.nameStation = name;
        this.numberLine = line;
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
    public int compareTo(Station s)
    {
//        int lineComparison = line.compareTo(s.getLine());
//        if(lineComparison != 0) {
//            return lineComparison;
//        }
//        return name.compareToIgnoreCase(s.getName());
//        return this.line.compareTo(s.line) + this.name.toLowerCase().compareTo(s.name.toLowerCase());
        return Integer.compare(Integer.parseInt(s.getLine()), Integer.parseInt(this.numberLine));


    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Station) {
            return this.numberLine.equals(((Station) obj).getLine()) && this.nameStation.equals(((Station) obj).getNameStation());
        }
        return false;

    }

//    @Override
//    public String toString()
//    {
//        return name;
//    }

}

