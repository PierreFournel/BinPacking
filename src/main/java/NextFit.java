

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NextFit extends AlgorithmBinPacking{

    public NextFit(List<Item> items,int pack_size){
        super(items,pack_size);
    }

    public void compute() throws PackException {




        long debut = System.nanoTime();


        for(int i=0; i<items.size();i++){
            Item item = items.get(i);
            if(packs.get(nb_packs_used-1).canAddItem(item)){
                packs.get(nb_packs_used-1).addItem(item);
            }else{
                nb_packs_used++;
                packs.add(new Pack(pack_size));
                packs.get(nb_packs_used-1).addItem(item);

            }
        }

        time = (System.nanoTime() - debut)/1000000.0;
       // tostring(items,packs,pack_size,packPosition);
    }


}
