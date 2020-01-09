package com.deminmax;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class ParserHTML {
    private static String URL_CONTENT;

    public ParserHTML(String url) {
        URL_CONTENT = url;
    }


    public Elements parseHTMLFromURL() {
        try {
            Document document = Jsoup.connect(URL_CONTENT).maxBodySize(0).get();
            Elements elements = document.select(".standard.sortable tbody tr");
//            elements.forEach(element -> element.select("small").remove());
            return elements;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public MyMetro getMetro(Elements elements) throws IOException {
        MyMetro myMetro = new MyMetro();
        elements.forEach(element -> {
            String nameStation = element.select("td:nth-child(2):not(:matches(.+закрыта.+))").text();
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
            Elements transitions = element.select("td:nth-child(4) a");
            Elements numbersLines = element.select("td:nth-child(4) span.sortkey");
            if (numbersLines.size() > 0 && numbersLines.size() == transitions.size()) {
                ArrayList<Station> connections = new ArrayList<>();
                for (int i = 0; i < transitions.size(); i++) {
                    String absLinkInsideHTMLWiki = transitions.get(i).attr("abs:href");
                    Document document = Jsoup.connect(absLinkInsideHTMLWiki).get();
                    Elements fromNewLink = document.select("body.mediawiki div.mw-body h1.firstHeading");
                    String nameTransitionStation = fromNewLink.text().replaceAll("\\(.*\\)", "").trim();
                    String numberLine = numbersLines.get(i).text().replaceFirst("^0", "");
                    Station station = new Station(numberLine, nameTransitionStation);
                    connections.add(station);
                }
                String baseNameStation = element.select("td:nth-child(2) a").text();
                Elements baseNumbersLines = element.select("td:nth-child(1) span.sortkey:not(:last-child)");
                for (int i = 0; i < baseNumbersLines.size(); i++) {
                    String baseNumberLine = baseNumbersLines.get(i).text().replaceFirst("^0", "");
                    Station baseStation = new Station(baseNumberLine, baseNameStation);
                    connections.add(baseStation);
                }

                Collections.sort(connections);
                if (!myMetro.getConnectedStations().contains(connections)) {
                    myMetro.addConnection(connections);
                }
            }
        }
    }


//    public String parseLinkInsideWikiMSCMetro(Elements elements) {
//        elements.forEach(element -> {
//            Elements transitions = element.select("td:nth-child(4) a");
//            for (int i = 0; i < transitions.size(); i++) {
//                String absLinkInsideHTMLWiki = transitions.get(i).attr("abs:href");
//                try {
//                    Document document = Jsoup.connect(absLinkInsideHTMLWiki).get();
//                    Elements fromNewLink = document.select("body.mediawiki div.mw-body h1.firstHeading");
//                   String nameTransitionStation = fromNewLink.text().replaceAll("\\(.*\\)", "").trim();
//                    System.out.println(nameTransitionStation);
//                   return nameTransitionStation;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
