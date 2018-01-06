import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Parser
{
    private int pack_size;
    private List<Item> items;

    public Parser(String fileName) throws Exception
    {
        items = new ArrayList();

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource("exemples/" + fileName).getFile());
        System.out.println(file);
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        if(bufferedReader.readLine() != null)
        {
            line = bufferedReader.readLine();

            if(line != null)
            {
                pack_size = Integer.parseInt(line);
            }
        }

        if(bufferedReader.readLine() != null)
        {
            line = bufferedReader.readLine();

            if(line != null)
            {
                String items[] = line.split(", ");

                for(String string : items)
                {
                    if(string.contains("."))
                    {
                        string = string.replace(".", "");
                    }

                    this.items.add(new Item(Integer.parseInt(string)));
                }
            }
        }

        bufferedReader.close();
        fileReader.close();
    }

    public int getPack_size()
    {
        return pack_size;
    }

    public List<Item> getItems()
    {
        return items;
    }
}