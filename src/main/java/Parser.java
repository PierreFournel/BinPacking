import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Parser {
    private int pack_size;
    private List<Item> items;

    public Parser(String fileName) throws Exception {
        items = new ArrayList();

        //    ClassLoader classLoader = getClass().getClassLoader();

        //   File file = new File(classLoader.getResource("exemples/" + fileName).getFile());
        //  System.out.println(file);

        //  FileReader fileReader = new FileReader(file);

        InputStream inputStream = getClass().getResourceAsStream("exemples/" + fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // BufferedReader bufferedReader = new BufferedReader(fileReader);

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
        inputStream.close();
    }

    public int getPack_size() {
        return pack_size;
    }

    public List<Item> getItems() {
        return items;
    }
}