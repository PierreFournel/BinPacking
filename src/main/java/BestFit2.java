import java.util.List;
import java.util.Queue;

public class BestFit2 extends AlgorithmBinPacking2 {

    protected BinaryTree binaryTree;
    protected List<Pack> fullPacks;

    public BestFit2(List<Item> items, int pack_size) {
        super(items, pack_size);
    }

    public void compute() {
        Pack best_Pack = new Pack(pack_size);

        for (Item item : items) {
            double value = item.getSize();
            best_Pack = binaryTree.getBestPack(value);
            if (best_Pack.getAvailibity() != 0) {
                binaryTree.deleteNode(best_Pack.getAvailibity());
            } else {
                best_Pack = new Pack(pack_size);
            }
            best_Pack.addItem(item);
            if (best_Pack.getAvailibity() == 0) {
                packs.add(best_Pack);
            } else {
                binaryTree.insert(best_Pack);
            }
        }
    }
}
