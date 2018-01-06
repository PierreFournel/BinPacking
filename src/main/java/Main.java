import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws PackException {
        List<Item> items = new ArrayList();

        for(int i=0; i<20;i++){
            items.add(new Item());
        }

        NextFit nextFit = new NextFit(items,10);
        nextFit.compute();

    }
}
