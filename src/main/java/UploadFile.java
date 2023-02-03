import java.io.FileWriter;

public class UploadFile {
    public static void Uploader() throws Exception{
        FileWriter fileWriter = new FileWriter("MyFile.txt");
        fileWriter.write( "fileUploader");
        fileWriter.close();

    }

}
