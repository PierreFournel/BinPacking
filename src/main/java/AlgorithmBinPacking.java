import java.util.ArrayList;
import java.util.List;

public abstract class AlgorithmBinPacking {

    protected List<Item> items;
    protected  List<Pack> packs;
    protected int pack_size;
    protected int nb_packs_used;
    protected double time;

    public AlgorithmBinPacking(List<Item> items,int pack_size){
        this.items=items;
        this.pack_size=pack_size;
        packs = new ArrayList<Pack>();
        packs.add(new Pack(pack_size));
        nb_packs_used = 1;

    }

    public abstract void compute() throws PackException;




    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Pack> getPacks() {
        return packs;
    }

    public void setPacks(List<Pack> packs) {
        this.packs = packs;
    }


    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
