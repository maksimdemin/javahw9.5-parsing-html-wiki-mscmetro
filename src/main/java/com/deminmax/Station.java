package com.deminmax;
import java.util.Objects;

public class Station {

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
        return Objects.equals(numberLine, station.numberLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLine);
    }
}

