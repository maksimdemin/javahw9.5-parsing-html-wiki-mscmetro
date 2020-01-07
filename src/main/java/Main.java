import com.deminmax.JsonFile;
import com.deminmax.Line;
import com.deminmax.MyMetro;
import com.deminmax.ParserHTML;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

    private static final String URL_WIKI_MSCMETRO = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%81%D1%82%D0%B0%D0%BD%D1%86%D0%B8%D0%B9_%D0%9C%D0%BE%D1%81%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_%D0%BC%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B5%D0%BD%D0%B0";

    public static void main(String[] args) throws IOException {

        ParserHTML parserHTML = new ParserHTML(URL_WIKI_MSCMETRO);
        Elements elements = parserHTML.parseHTMLFromURL();
        MyMetro myMetro = parserHTML.getMetro(elements);
        Path pathFromUser = JsonFile.pathFromUser();
//        JsonFile.toJsonFile(myMetro, Path.of("myfiles/test.json"));
        JsonFile.toJsonFile(myMetro, pathFromUser);
        MyMetro.getQuantityStationsByLine(myMetro);
    }
}
