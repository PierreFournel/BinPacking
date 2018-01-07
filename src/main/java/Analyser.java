import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Analyser{
    public Analyser(){
    }

    public void generate(String fileName, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName+".csv");
        fileWriter.append(content);
        fileWriter.close();
    }
}
