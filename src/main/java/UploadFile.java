import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {
    private WebDriver driver;

    public static void uploader() throws Exception {
        String path = "src/test/java/File.txt";
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write("fileUploader");
        fileWriter.close();

    }

    public static boolean checkIfFileExist() {
        String filePath = "src/test/java/File.txt";
        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);
        if (exists) {
            return true;
        } else {
            return false;

        }
    }

    public static void deleteFile() {
        try {
            Files.delete(Paths.get("src/test/java/File_2.txt"));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

