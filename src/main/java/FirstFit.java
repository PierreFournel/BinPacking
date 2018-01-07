import java.util.List;

public class FirstFit extends AlgorithmBinPacking {

    public FirstFit(List<Item> items, int max_packs) {
        super(items, max_packs);
    }

    public FirstFit() {
        super();
    }

    @Override
    public void compute() {
        long debut = System.nanoTime();
        boolean filled;
        for (Item item : items) {
            filled = false;
            for (Pack pack : packs) {
                if (pack.canAddItem(item)) {
                    pack.addItem(item);
                    filled = true;
                    break;
                }
            }
            if (!filled) {
                packs.add(new Pack(pack_size));
                nb_packs_used++;
                packs.get(packs.size() - 1).addItem(item);
            }
        }
        time = (System.nanoTime() - debut) / 1000000.0;
    }
}