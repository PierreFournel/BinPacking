import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws PackException {
        List<Item> items = new ArrayList();

        for(int i=0; i<20;i++){
            items.add(new Item());
        }

        NextFit nextFit = new NextFit(items,1);
        nextFit.compute();
        nextFit.toString();

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



    }
}
