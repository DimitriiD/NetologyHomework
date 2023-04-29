import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import static converter.ForConvert.*;

public class TestConvert {
    @Test
    public void testCsvToJson() throws IOException {
        // given:
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        var fileName = "data.csv";
        // when:
        writeString(convertToJson(parseCSV(columnMapping, fileName)), "newData.json");
        // then:
        var expectFile = "expectData.json";
        var actualFile = "newData.json";
        Assertions.assertTrue(Arrays.equals(convertFileToByteArray(expectFile),
                        convertFileToByteArray(actualFile)),
                "different file");
    }

    @Test
    public void testXmlToJson() throws IOException {
        // given:
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        var pathToXml = "data.xml";
        // when:
        writeString(convertToJson(fromXML(pathToXml)), "newData2.json");
        // then:
        var expectFile = "expectData2.json";
        var actualFile = "newData2.json";
        Assertions.assertTrue(Arrays.equals(convertFileToByteArray(expectFile),
                        convertFileToByteArray(actualFile)),
                "different file");
    }

    private static byte[] convertFileToByteArray(String filePath) throws IOException {
        var fileInputStream = new FileInputStream(filePath);
        var arrayByte = new byte[fileInputStream.available()];
        fileInputStream.read(arrayByte);
        return arrayByte;
    }

}