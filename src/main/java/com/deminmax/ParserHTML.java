package com.deminmax;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

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
            elements.forEach(element -> {
            });
            return elements;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public MyMetro getMetro(Elements elements) {
        MyMetro myMetro = new MyMetro();
        elements.forEach(element -> {
            String nameStation = element.select("td:nth-child(2) a").text();
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
                    Station station = new Station(nameStation, line.getNumber());
                    myMetro.addStation(station);
                }
            }
        });
        return myMetro;
    }


//    public MyMetro getMetro(Elements elements) {
//        MyMetro myMetro = new MyMetro();
//        elements.forEach(element -> {
//            String nameStation = element.select("td:nth-child(2) a").text();
//                String nameLine = element.select("td:nth-child(1) img").attr("alt");
//                String numberLine = element.select("td:nth-child(1) span.sortkey:not(:last-child)").text().replaceFirst("^0", "");
//                if (!nameStation.equals("") && !nameLine.equals("")) {
//                    Line line = new Line(numberLine, nameLine);
//                    if (myMetro.getLine(line) == null) {
//                        myMetro.addLine(line);
//                    } else {
//                        line = myMetro.getLine(line);
//                    }
//                    Station station = new Station(nameStation, line.getNumber());
//                    myMetro.addStation(station);
//                }
//        });
//        return myMetro;
//    }
}
