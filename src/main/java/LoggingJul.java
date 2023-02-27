import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingJul {
    static Logger log = Logger.getLogger(LoggingJul.class.getName());

    public static void init() {
        FileHandler fh;
        try {
            FileInputStream fis;
            Properties property = new Properties();
            fis = new FileInputStream("src/main/java/LoggingJava.properties");
            property.load(fis);
            fh = new FileHandler(property.getProperty("java.util.logging.FileHandler.pattern"));
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Logger Initialized");
        } catch (Exception e) {
            log.log(Level.WARNING, "Exception ::", e);
        }
    }

    public static void main(String[] args) {
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            log.log(Level.WARNING, "Arifmetic Exception", e);
        }
        log.info("end of the program");

    }

    public static void checkLog() {
        log.info("Initialization of first variable");
        int a = 10;
        log.info("Initialization of second variable");
        int b = 2;

    }

    public static void fileDoesntExist() {
        try {
            Files.readAllBytes(Paths.get("/file/does/not/exist"));
        } catch (IOException ioex) {
            log.log(Level.SEVERE, "File doesn't exist", ioex);
        }
    }
}

