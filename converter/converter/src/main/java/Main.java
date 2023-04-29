import java.io.IOException;

import static converter.ForConvert.*;
import static java.net.HttpURLConnection.HTTP_OK;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        var fileName = "data.csv";
        var pathToXml = "data.xml";
        int httpOk = HTTP_OK;
        writeString(convertToJson(parseCSV(columnMapping, fileName)), "data.json");
        writeString(convertToJson(fromXML(pathToXml)), "data2.json");
    }
}
