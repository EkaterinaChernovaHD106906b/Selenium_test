import java.io.FileWriter;

public class UploadFile {
    public static void Uploader() throws Exception{
        String path = "src/test/java/File.txt";
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write( "fileUploader");
        fileWriter.close();

    }

}
