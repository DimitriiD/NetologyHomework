import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var stringBuilder = new StringBuilder();
        var url = "Z:\\Users\\Работа\\Desktop\\Game";
        stringBuilder.append(url + "\\src Create " + new File(url + "\\src").mkdir() + "\n");
        stringBuilder.append(url + "\\res Create " + new File(url + "\\res").mkdir() + "\n");
        stringBuilder.append(url + "\\savegames Create " + new File(url + "\\savegames").mkdir() + "\n");
        stringBuilder.append(url + "\\temp Create " + new File(url + "\\temp").mkdir() + "\n");
        url = url + "\\src";
        stringBuilder.append(url + "\\main Create " + new File(url + "\\main").mkdir() + "\n");
        stringBuilder.append(url + "\\test Create " + new File(url + "\\test").mkdir() + "\n");
        url = url + "\\main";
        try {
            stringBuilder.append(url + "\\Main.java Create " + new File(url + "\\Main.java").createNewFile() + "\n");
            stringBuilder.append(url + "\\Utils.java Create " + new File(url + "\\Utils.java").createNewFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url = "Z:\\Users\\Работа\\Desktop\\Game\\res";
        stringBuilder.append(url + "\\drawables Create " + new File(url + "\\drawables").mkdir() + "\n");
        stringBuilder.append(url + "\\vectors Create " + new File(url + "\\vectors").mkdir() + "\n");
        stringBuilder.append(url + "\\icons Create " + new File(url + "\\icons").mkdir() + "\n");
        url = "Z:\\Users\\Работа\\Desktop\\Game\\temp\\temp.txt";
        try {
            var file = new File(url);
            stringBuilder.append(url + " Create " + file.createNewFile() + "\n");
            var fileWriter = new FileWriter(file);
            fileWriter.write( stringBuilder.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder);
    }
}
