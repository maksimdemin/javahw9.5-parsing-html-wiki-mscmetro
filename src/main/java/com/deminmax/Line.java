package com.deminmax;
import java.util.Objects;

public class Line {
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
        return Objects.equals(numberLine, line.numberLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLine);
    }

}