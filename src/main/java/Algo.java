
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Algo {

    public static void main(String[] args) throws Exception {

        String csv = "";
        Display display = new Display();

        List<String> filesName = new ArrayList<String>();
        filesName.add("exemple100.txt");
        filesName.add("exemple500.txt");
        filesName.add("exemple1000.txt");
        filesName.add("monexemple.txt");

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
/*
                System.out.println("Excecution de l'algorithme " + algo.getClass() + " avec l'exemple " + fileName + " : ");
                algo.toString();
*/
            }
            csv += display.dataAlgo(algos, fileName, items, pack_size);
        }
        System.out.println(csv);
    }


}

