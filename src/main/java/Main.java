import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception {
        /*
        List<Item> items = new ArrayList();

        for(int i=0; i<20;i++){
            items.add(new Item());
        }
*/
        List<String> filesName = new ArrayList<String>();
        filesName.add("exemple100.txt");
        filesName.add("exemple500.txt");
        filesName.add("exemple1000.txt");
        filesName.add("monexemple.txt");

        for(String fileName : filesName){
            System.out.println(fileName.toUpperCase());
            Parser parser = new Parser(fileName);

            List<Item> items = new ArrayList();
            int pack_size;

            items = parser.getItems();
            pack_size = parser.getPack_size();

            NextFit nextFit = new NextFit(items, pack_size);
            nextFit.compute();
            nextFit.toString();
/*
        FirstFit firstFit = new FirstFit(items,1);
        firstFit.compute();
        firstFit.toString();

        BestFit bestFit = new BestFit(items,1);
        bestFit.compute();
        bestFit.toString();

        AlmostWorstFit almostWorstFit = new AlmostWorstFit(items,1);
        almostWorstFit.compute();
        almostWorstFit.toString();

        WorstFit worstFit = new WorstFit(items,1);
        worstFit.compute();
        worstFit.toString();
*/
        }

    }
}
