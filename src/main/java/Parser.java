import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private int pack_size;
    private List<Item> items;

    public Parser(String fileName) throws Exception {

        items = new ArrayList();


        FileReader fileReader = new FileReader(System.getProperties().get("user.dir") + "/" + fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String line;

        if (bufferedReader.readLine() != null) {
            line = bufferedReader.readLine();

            if (line != null) {
                pack_size = Integer.parseInt(line);
            }
        }

        if (bufferedReader.readLine() != null) {
            line = bufferedReader.readLine();

            if (line != null) {
                String items[] = line.split(", ");

                for (String string : items) {
                    if (string.contains(".")) {
                        string = string.replace(".", "");
                    }

                    this.items.add(new Item(Integer.parseInt(string)));
                }
            }
        }

        bufferedReader.close();
       // inputStream.close();
        fileReader.close();
    }

    public int getPack_size() {
        return pack_size;
    }

    public List<Item> getItems() {
        return items;
    }
}