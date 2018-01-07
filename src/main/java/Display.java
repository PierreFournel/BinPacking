import java.util.List;

public class Display {
    public Display() {
    }
/*
    public  String dataAlgo(List<AlgorithmBinPacking> algos, String fileName, List<Item> items, int max_pack) {
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
    public  String dataAlgo(List<AlgorithmBinPacking> algos, String fileName, List<Item> items, int max_pack) {
        String csv ="----------------------------------------------------------------------\n\n";
        csv+="Simulation fichier " +fileName+ " :\n\nNombre items : "+items.size()+"\nCapacité maximale d'un pack : "+max_pack+"\nTaille moyenne d'un item : "+averageItemCapacity(items)+"\n\n";

        csv += "Algorithme, nombre de packs utilisés, temps exécution (ms), place moyenne occupée pack\n";
        for (AlgorithmBinPacking algo : algos) {
            String algoName = algo.getClass().toString().replace("class ", "");
            csv += algoName + ", " + algo.nb_packs_used  + ", " + algo.time +", "+averageUsedSpacePack(algo.packs)+"\n";

        }
        csv += "\n\n----------------------------------------------------------------------\n\n";
        return csv;
    }



    public  String dataStat(List<AlgorithmBinPacking> algos, List<Item> items, int max_pack,int index_simulation) {
        String csv ="----------------------------------------------------------------------\n\n";
         csv+="Simulation n°" +index_simulation+ " :\n\nNombre items : "+items.size()+"\nCapacité maximale d'un pack : "+max_pack+"\nTaille moyenne d'un item : "+averageItemCapacity(items)+"\n\n";

        csv += "Algorithme, nombre de packs utilisés, temps exécution (ms), place moyenne occupée pack\n";
        for (AlgorithmBinPacking algo : algos) {
            String algoName = algo.getClass().toString().replace("class ", "");
            csv += algoName + ", " + algo.nb_packs_used  + ", " + algo.time +", "+averageUsedSpacePack(algo.packs)+"\n";

        }
        csv += "\n\n----------------------------------------------------------------------\n\n";
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
