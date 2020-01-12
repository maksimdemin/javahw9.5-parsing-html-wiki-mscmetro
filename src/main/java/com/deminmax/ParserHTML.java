package com.deminmax;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class ParserHTML {
    private static String URL_CONTENT;

    public ParserHTML(String url) {
        URL_CONTENT = url;
    }


    public Elements parseHTMLFromURL() {
        try {
            Document document = Jsoup.connect(URL_CONTENT).maxBodySize(0).get();
            Elements elements = document.select(".standard.sortable tbody tr");
            return elements;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public MyMetro getMetro(Elements elements) throws IOException {
        MyMetro myMetro = new MyMetro();
        elements.forEach(element -> {
            String nameStation = getNameStation(element);
            Elements namesLines = element.select("td:nth-child(1) img");
            Elements numbersLines = element.select("td:nth-child(1) span.sortkey:not(:last-child)");
            for (int i = 0; i < namesLines.size(); i++) {
                String nameLine = namesLines.get(i).attr("alt");
                String numberLine = numbersLines.get(i).text().replaceFirst("^0", "");
                if (namesLines.size() == numbersLines.size() && !nameStation.equals("") && !nameLine.equals("")) {
                    Line line = new Line(numberLine, nameLine);
                    if (myMetro.getLine(line) == null) {
                        myMetro.addLine(line);
                    } else {
                        line = myMetro.getLine(line);
                    }
                    Station station = new Station(line.getNumber(), nameStation);
                    myMetro.addStation(station);
                }
            }
        });
        getConnections(elements, myMetro);
        return myMetro;
    }


    public void getConnections(Elements elements, MyMetro myMetro) throws IOException {
        for (Element element : elements) {
            Elements elLinksConnections = element.select("td:nth-child(4) a");
            Elements numbersLines = element.select("td:nth-child(4) span.sortkey");
            if (numbersLines.size() > 0) {
                ArrayList<Station> connections = new ArrayList<>();
                for (int i = 0; i < numbersLines.size(); i++) {
                    String nameTransitionStation = getNameStationFromLinkConnection(elLinksConnections, i);
                    String numberLine = numbersLines.get(i).text().replaceFirst("^0", "");
                    Station transitionStation = new Station(numberLine, nameTransitionStation);
                    connections.add(transitionStation);
                }
                String baseNameStation = getNameStation(element);
                Elements baseNumbersLines = element.select("td:nth-child(1) span.sortkey:not(:last-child)");
                for (int i = 0; i < baseNumbersLines.size(); i++) {
                    String baseNumberLine = baseNumbersLines.get(i).text().replaceFirst("^0", "");
                    if (!baseNameStation.equals("")) {
                        Station baseStation = new Station(baseNumberLine, baseNameStation);
                        connections.add(baseStation);
                    }
                }
                LineComparatorInConnections lineComparatorInColnnections = new LineComparatorInConnections();
                connections.sort(lineComparatorInColnnections);
                    myMetro.addConnection(connections);
            }
        }
    }


        public String getNameStation(Element element) {
        Elements namesStations = element.select("td:nth-child(2):not(:matches(.+закрыта.+))");
            String nameStation = namesStations.select("td > span > a:first-child").text();
            if (nameStation.equals("")) {
                nameStation = namesStations.select("td > a:first-child").text();
            }
            return nameStation;
        }


        public String getNameStationFromLinkConnection(Elements elLinksConnections, int increment) throws IOException {
            String absLinkInsideHTMLWiki = elLinksConnections.get(increment).attr("abs:href");
            Document document = Jsoup.connect(absLinkInsideHTMLWiki).get();
            Elements fromNewLink = document.select("body.mediawiki div.mw-body h1.firstHeading");
            return fromNewLink.text().replaceAll("\\(.*\\)", "").trim();
        }

}
