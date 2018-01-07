
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Algo {

    public static void main(String[] args) throws Exception {

        String csv = "";
        Display display = new Display();

        Analyser analyser;
        List<String> filesName = new ArrayList<String>();

        filesName.add("exemples/exemple100.txt");
        filesName.add("exemples/exemple500.txt");
        filesName.add("exemples/exemple1000.txt");
        filesName.add("exemples/monexemple.txt");

        List<AlgorithmBinPacking> algos = new ArrayList<AlgorithmBinPacking>();
        algos.add(new NextFit());
        algos.add(new FirstFit());
        algos.add(new BestFit());
        algos.add(new AlmostWorstFit());
        algos.add(new WorstFit());

        for (String fileName : filesName) {

            Parser parser = new Parser(fileName);

            List<Item> items = new ArrayList();
            int pack_size;

            items = parser.getItems();
            pack_size = parser.getPack_size();

            for (AlgorithmBinPacking algo : algos) {

                algo.refresh();
                algo.configure(items, pack_size);

                algo.compute();
            }
            analyser = new Analyser();
            csv += display.dataAlgo(algos, fileName, items, pack_size);
            analyser.generate(fileName.split(".txt")[0],csv);
        }
        System.out.println(csv);
    }

    public static String data(List<AlgorithmBinPacking> algos, String fileName, List<Item> items, int max_pack) {
        String csv = fileName.split(".txt")[0] + "\n";
        csv += "algo;items;bin capacity;packs used;time (ms)\n";
        for (AlgorithmBinPacking algo : algos) {
            String algoName = algo.getClass().toString().replace("class ","");
            csv += algoName + ";" + items.size() + ";" + max_pack + ";" + algo.nb_packs_used + ";" + algo.time + "\n";
        }
        csv += "\n\n";
        return csv;

    }
}

