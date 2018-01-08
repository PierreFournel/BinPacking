
import java.util.ArrayList;
import java.util.List;

public class Algo {

    public static void main(String[] args) throws Exception {

        String csv = "";
        String affichage ="";
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
            affichage+=display.dataAlgo(algos, fileName, items, pack_size);
            csv += display.dataAlgoCSV(algos, fileName, items, pack_size);
            analyser.generate(fileName.split(".txt")[0],csv);
        }
        System.out.println(affichage);
    }

}

