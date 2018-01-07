import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public abstract class AlgorithmBinPacking2 {

    public AlgorithmBinPacking2(List<Item> items,int pack_size){
        this.items=items;
        this.items = new ArrayList<Item>();
        this.pack_size=pack_size;

        id++;
    }
    protected int id=1;
    protected List<Item> items;
    protected int pack_size;
    protected  List<Pack> packs;
    protected int nb_packs_used;


    public abstract void compute();

}
