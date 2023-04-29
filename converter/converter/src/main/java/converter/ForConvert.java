package converter;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import employee.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForConvert {
    public static List<Employee> parseCSV(String[] columnMapping, String fileName) {
        try (var reader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            return csv.parse();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> fromXML(String pathToXml) {
        List<Employee> list = new ArrayList<>();
        Document doc;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(new File(pathToXml));
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        NodeList nodeList = doc.getElementsByTagName("employee");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Map<String, String> empMap = new HashMap<>();
            Node node = nodeList.item(i);

            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;

                Long id = Long.valueOf(getElement(element, "id"));
                String firstName = getElement(element, "firstName");
                String lastName = getElement(element, "lastName");
                String country = getElement(element, "country");
                Integer age = Integer.valueOf(getElement(element, "age"));

                list.add(new Employee(id, firstName, lastName, country, age));
            }
        }
        return list;
    }

    public static String getElement(Element element, String tag) {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }

    public static String convertToJson(List<Employee> list) {
        var builder = new GsonBuilder();
        var gson = builder.setPrettyPrinting().create();
        var listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gson.toJson(list, listType);
    }

    public static void writeString(String str, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
