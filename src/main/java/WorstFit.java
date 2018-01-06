import java.util.List;

public class WorstFit extends AlgorithmBinPacking {


    public WorstFit(List<Item> items, int pack_size) {
        super(items, pack_size);
    }

    public void compute() throws PackException {

        long debut = System.nanoTime();

        int worst_index = 0;
        boolean hasWorst;
        for (Item item : items) {
            worst_index = 0;
            hasWorst = false;
            for (int i = 0; i < nb_packs_used; i++) {
                if (packs.get(i).canAddItem(item)) {
                    if (!hasWorst) {
                        worst_index = i;
                        hasWorst = true;
                    } else if (packs.get(worst_index).getAvailibity() < packs.get(i).getAvailibity()) {
                        worst_index = i;
                    }
                }
            }
            if (!hasWorst) {
                packs.add(new Pack(pack_size));
                nb_packs_used++;
                packs.get(packs.size() - 1).addItem(item);
            } else {
                packs.get(worst_index).addItem(item);
            }
        }
        time = (System.nanoTime() - debut)/1000000.0;
    }
}
