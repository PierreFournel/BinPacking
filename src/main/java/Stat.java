import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stat {


    public static void main(String[] args) throws Exception {

        Display display = new Display();
        String csv = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrer la capacité maximale d'un pack : ");

        int max_pack = scanner.nextInt();

        System.out.println("Entrer le nombre d'items : ");

        int nb_items = scanner.nextInt();

        System.out.println("Entrer le nombre de simulations : ");

        int nb_simulations = scanner.nextInt();

        List<Item> items = createItems(nb_items,max_pack);

        List<AlgorithmBinPacking> algos = new ArrayList<AlgorithmBinPacking>();

        algos.add(new NextFit());
        algos.add(new FirstFit());
        algos.add(new BestFit());
        algos.add(new AlmostWorstFit());
        algos.add(new WorstFit());

        for (int i = 0; i < nb_simulations; i++) {

            for (AlgorithmBinPacking algo : algos) {
                algo.refresh();
                algo.configure(items,max_pack);
                algo.compute();
            }
            csv += display.dataStat(algos,items,max_pack,i);
        }
        System.out.println(csv);
    }

    public static List<Item> createItems(int nb_items, int pack_max) {
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i < nb_items; i++) {
            items.add(new Item(Math.random() * pack_max));
        }
        return items;
    }

}
