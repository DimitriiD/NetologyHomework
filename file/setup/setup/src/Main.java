import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        var stringBuilder = new StringBuilder();
        var url = "Z:\\Users\\Работа\\Desktop\\Game";
        var gameProgress1 = new GameProgress(10, 10, 1, 5.5);
        var gameProgress2 = new GameProgress(15, 15, 2, 4.5);
        var gameProgress3 = new GameProgress(20, 20, 3, 3.5);
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
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url = "Z:\\Users\\Работа\\Desktop\\Game\\savegames";

        saveGame(url + "\\save1.dat", gameProgress1);
        saveGame(url + "\\save2.dat", gameProgress2);
        saveGame(url + "\\save3.dat", gameProgress3);
        zipSave(url + "\\");
    }

    private static void saveGame(String url, GameProgress gameProgress) {
        try (var fileOutputStream = new FileOutputStream(url)) {
            var objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameProgress);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void zipSave(String url) {
        String[] fileList = new File(url).list();
        for (String fileUrl : fileList) {
            if (fileUrl.contains(".dat")) {
                try (var fileInputStream = new FileInputStream(url + fileUrl);
                     var zipOutputStream = new ZipOutputStream(new FileOutputStream(url + fileUrl.replace(".dat", ".zip")))) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    var entry = new ZipEntry(fileUrl);
                    zipOutputStream.putNextEntry(entry);
                    fileInputStream.read(buffer);
                    zipOutputStream.write(buffer);
                    zipOutputStream.closeEntry();
                    fileInputStream.close();
                    new File(url + fileUrl).delete();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
