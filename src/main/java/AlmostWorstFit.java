import java.util.List;

public class AlmostWorstFit extends AlgorithmBinPacking {

    public AlmostWorstFit(List<Item> items, int pack_size) {
        super(items, pack_size);
    }

    public void compute() throws PackException {

        long debut = System.nanoTime();

        int almost_worst_index = 0;
        int worst_index = 0;
        boolean hasAlmostWorst;
        for (Item item : items) {
            almost_worst_index = 0;
            worst_index = 0;
            hasAlmostWorst = false;
            for (int i = 0; i < nb_packs_used; i++) {
                if (packs.get(i).canAddItem(item)) {
                    if (!hasAlmostWorst) {
                        almost_worst_index = i;
                        worst_index = almost_worst_index;
                        hasAlmostWorst = true;
                    } else if (packs.get(worst_index).getAvailibity() < packs.get(i).getAvailibity()) {
                        almost_worst_index = worst_index;
                        worst_index = i;
                    }
                }
            }
            if (!hasAlmostWorst) {
                packs.add(new Pack(pack_size));
                nb_packs_used++;
                packs.get(packs.size()-1).addItem(item);
            } else {
                packs.get(almost_worst_index).addItem(item);
            }
        }
        time = (System.nanoTime() - debut)/1000000.0;
    }
}
