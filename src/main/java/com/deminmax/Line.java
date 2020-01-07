package com.deminmax;


public class Line implements Comparable<Line>
{
    private String number;
    private String name;
    private String color;

    public Line(String  number, String name)
    {
        this.number = number;
        this.name = name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }


    @Override
    public int compareTo(Line l)
    {
//        return this.number.compareTo(l.number) + this.name.toLowerCase().compareTo(l.name.toLowerCase());
        return Integer.compare(Integer.parseInt(l.getNumber()), Integer.parseInt(this.number));

    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Line)
            return this.name.toLowerCase().equals(((Line) obj).getName().toLowerCase()) && this.number.equals(((Line) obj).getNumber());
        return false;

    }


    @Override
    public String toString()
    {
        return name;
    }

}