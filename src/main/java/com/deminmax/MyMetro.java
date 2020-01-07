package com.deminmax;

import java.util.*;

public class MyMetro {

    List<Line> lines;
//    TreeMap<Integer, ArrayList<Station>> stations;
    HashMap<String, ArrayList<String>> stations;
//    TreeMap<Station, TreeSet<Station>> connections;

    public MyMetro()
    {
        lines = new ArrayList<>();
        stations = new HashMap<>();
//        connections = new TreeMap<>();
    }


    public void addStation(Station station)
    {
        if (station != null) {
            stations.get(station.getLine()).add(station.getNameStation());
        }
    }


    public void addLine(Line line)
    {
        if (line != null) {
            lines.add(line);
            stations.put(line.getNumber(), new ArrayList<>());
        }
    }


    public Line getLine(Line line)
    {
        for (Line currentLine : lines) {
            if (currentLine.equals(line))
                return currentLine;
        }
        return null;
    }


    public HashMap<String, ArrayList<String>> getStations() {
        return stations;
    }









//    public void addConnection(List<Station> stations)
//    {
//        for(Station station : stations)
//        {
//            if(!connections.containsKey(station)) {
//                connections.put(station, new TreeSet<>());
//            }
//            TreeSet<Station> connectedStations = connections.get(station);
//            connectedStations.addAll(stations.stream()
//                    .filter(s -> !s.equals(station)).collect(Collectors.toList()));
//        }
//    }



//    public Set<Station> getConnectedStations(Station station)
//    {
//        if(connections.containsKey(station)) {
//            return connections.get(station);
//        }
//        return new TreeSet<>();
//    }

}
