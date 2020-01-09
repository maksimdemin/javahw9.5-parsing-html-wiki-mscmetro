package com.deminmax;
import java.util.*;

public class MyMetro {

    List<Line> lines;
//    TreeMap<Integer, ArrayList<Station>> stations;
    HashMap<String, ArrayList<String>> stations;
//    TreeSet<TreeSet<Station>> connections;
    List<ArrayList<Station>> connections;

    public MyMetro() {
        lines = new ArrayList<>();
        stations = new LinkedHashMap<>();
        connections = new ArrayList<>();
    }


    public void addStation(Station station) {
        if (station != null) {
            stations.get(station.getLine()).add(station.getNameStation());
        }
    }


    public void addLine(Line line) {
        if (line != null) {
            lines.add(line);
            stations.put(line.getNumber(), new ArrayList<>());
        }
    }


    public Line getLine(Line line) {
        for (Line currentLine : lines) {
            if (currentLine.equals(line))
                return currentLine;
        }
        return null;
    }


    public HashMap<String, ArrayList<String>> getStations() {
        return stations;
    }


    public static void getQuantityStationsByLine(MyMetro myMetro) {
        System.out.println("The quantity of stations on each line:");
        myMetro.getStations().forEach((lineNumber, listStations) ->
                System.out.printf("Line № %3s  has %2d stations%n", lineNumber, listStations.size()));
    }


    public void addConnection(ArrayList<Station> connection) {
        connections.add(connection);
    }


    public List<ArrayList<Station>> getConnectedStations() {
        return connections;
    }

}
