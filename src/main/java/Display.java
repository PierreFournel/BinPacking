import java.util.List;

public class Display {
    public Display() {
    }
/*
    public  String dataAlgoCSV(List<AlgorithmBinPacking> algos, String fileName, List<Item> items, int max_pack) {
        String csv = fileName + "\n";
        csv += "algo, items, bin capacity, packs used, time (ms)\n";
        for (AlgorithmBinPacking algo : algos) {
            String algoName = algo.getClass().toString().replace("class ", "");
            csv += algoName + ", " + items.size() + ", " + max_pack + ", " + algo.nb_packs_used + ", " + algo.time + "\n";

        }
        csv += "\n\n";
        return csv;
    }
*/
    public  String dataAlgoCSV(List<AlgorithmBinPacking> algos, String fileName, List<Item> items, int max_pack) {
        String csv="\n";
        csv+="Nom de l'exemple : "+fileName.split("/")[1].split(".txt")[0]+"\n\n";
        csv+="Nombre items : "+items.size()+"\nCapacite maximale d'un pack : "+max_pack+"\nTaille moyenne d'un item : "+averageItemCapacity(items)+"\n\n";

        csv += "Algorithme;nombre de packs utilises;temps execution (ms);place moyenne occupee pack\n";
        for (AlgorithmBinPacking algo : algos) {
            String algoName = algo.getClass().toString().replace("class ", "");
            csv += algoName + ";" + algo.nb_packs_used  + ";" + algo.time +";"+averageUsedSpacePack(algo.packs)+"\n";

        }
        csv += "\n\n----------------------------------------------------------------------\n\n";
        return csv;
    }

    public  String dataAlgo(List<AlgorithmBinPacking> algos, String fileName, List<Item> items, int max_pack) {
        String csv="\n";
        csv+="Nom de l'exemple : "+fileName.split("/")[1].split(".txt")[0]+"\n\n";
        csv+="Nombre items : "+items.size()+"\nCapacite maximale d'un pack : "+max_pack+"\nTaille moyenne d'un item : "+averageItemCapacity(items)+"\n\n";
       // csv+="--------------------------------------------------------------------------------------------------------------------------------";
        csv += "Algorithme - Nb packs utilises - Temps (ms) - Place moyenne pack\n";
        for (AlgorithmBinPacking algo : algos) {

            String algoName = algo.getClass().toString().replace("class ", "");
            csv += algoName + "  " + algo.nb_packs_used  + "  " + algo.time +"  "+averageUsedSpacePack(algo.packs)+"\n";

        }
        csv += "\n\n----------------------------------------------------------------------\n\n";
        return csv;
    }

    public  String dataStat(List<AlgorithmBinPacking> algos, List<Item> items, int max_pack, int index_simulation) {
        String csv="\n";
        csv+="Simulation no" +(index_simulation+1)+ " :\n\nNombre items : "+items.size()+"\nCapacite maximale d'un pack : "+max_pack+"\nTaille moyenne d'un item : "+averageItemCapacity(items)+"\n\n";
        csv+="Nombre items : "+items.size()+"\nCapacite maximale d'un pack : "+max_pack+"\nTaille moyenne d'un item : "+averageItemCapacity(items)+"\n\n";
        // csv+="--------------------------------------------------------------------------------------------------------------------------------";
        csv += "Algorithme - Nb packs utilises - Temps (ms) - Place moyenne pack\n";
        for (AlgorithmBinPacking algo : algos) {

            String algoName = algo.getClass().toString().replace("class ", "");
            csv += algoName + "  " + algo.nb_packs_used  + "  " + algo.time +"  "+averageUsedSpacePack(algo.packs)+"\n";

        }
        csv += "\n\n----------------------------------------------------------------------\n\n";
        return csv;
    }


    public  String dataStatCSV(List<AlgorithmBinPacking> algos, List<Item> items, int max_pack, int index_simulation) {
        String csv ="";
         csv+="Simulation no" +(index_simulation+1)+ " :\n\nNombre items : "+items.size()+"\nCapacite maximale d'un pack : "+max_pack+"\nTaille moyenne d'un item : "+averageItemCapacity(items)+"\n\n";

        csv += "Algorithme;nombre de packs utilises;temps execution (ms);place moyenne occupee pack\n";
        for (AlgorithmBinPacking algo : algos) {
            String algoName = algo.getClass().toString().replace("class ", "");
            csv += algoName + ";" + algo.nb_packs_used  + ";" + algo.time +";"+averageUsedSpacePack(algo.packs)+"\n";
        }
        return csv;
    }

    public double averageItemCapacity(List<Item> items){
        double sum=0;
        for (Item item : items){
            sum+=item.getSize();
        }
        return sum/items.size();
    }
    public double averageUsedSpacePack(List<Pack> packs){
        double sum=0;
        for(Pack pack : packs){
            sum+=pack.getCurrent_size();
        }
        return sum/packs.size();
    }
}
