import java.util.List;

public class BestFit extends AlgorithmBinPacking {

    public BestFit(List<Item> items, int pack_size) {
        super(items, pack_size);
    }

    public BestFit() {
        super();
    }

    public void compute() throws PackException {

        long debut = System.nanoTime();

        int best_index = 0;
        boolean best;
        for (Item item : items) {
            best_index = 0;
            best = false;
            for (int i = 0; i < nb_packs_used; i++) {
                if (packs.get(i).canAddItem(item)) {
                    if (!best) {
                        best_index = i;
                        best = true;
                    } else if (packs.get(best_index).getAvailibity() > packs.get(i).getAvailibity()) {
                        best_index = i;
                    }
                }
            }
            if (!best) {
                packs.add(new Pack(pack_size));
                nb_packs_used++;
                packs.get(packs.size() - 1).addItem(item);
            } else {
                packs.get(best_index).addItem(item);
            }
        }
        time = (System.nanoTime() - debut) / 1000000.0;
    }
}
