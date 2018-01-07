import java.util.List;

public class AlmostWorstFit2 extends AlgorithmBinPacking2 {

    protected BinaryTree binaryTree;

    public AlmostWorstFit2(List<Item> items, int pack_size) {
        super(items, pack_size);
    }

    public void compute() {
        for(Item item : items){
            double value = item.getSize();

            Pack mostEmptyPack = binaryTree.findMax().getNodePack();
            if (mostEmptyPack.getAvailibity()<value){
                mostEmptyPack = new Pack(pack_size);
                mostEmptyPack.addItem(item);
            }else{
             //   binaryTree.deleteNode()
            }

        }
    }
}
