import java.util.List;

public class Affichage {

    public Affichage(){

    }

    public void tostring(List<Item> items, List<Pack> packs, int packMax, int itemPosition, boolean allItemsArrange){
        System.out.println("------------------------------------------------------AFFICHAGE CONTENU PACKS---------------------------------------------------------------------------");
        System.out.println(items.size() + " items");
        System.out.println(packMax + " packs max \n");
        if(allItemsArrange){
            System.out.println("Tous les items ont été affecté à un pack.");

        }else{
            int diff = items.size()-itemPosition;
            System.out.println("Tous les items n'ont pas été affecté à un pack, il reste " + diff +" items à ranger.");
            System.out.println("Les items restant ont pour taille : ");
            System.out.print("[ ");
            for(int j= itemPosition; j<items.size();j++){

                System.out.print(items.get(j).getSize() +" ,");
            }
            System.out.print(" ]");
        }
        for(int i =0; i<packs.size();i++){

            Pack pack = packs.get(i);
            System.out.println("\n\nPack "+i+" : Occupé par "+ pack.getItems().size() +" items et de capacité occupée " + pack.getCurrent_size());
            System.out.print("[ ");
            for(Item item : pack.getItems()){
                System.out.print(item.getSize() +", ");

            }
            System.out.print(" ]");
            System.out.println();
            System.out.println("Espace disponible dans le pack "+i+" : " +pack.getAvailibity());
        }
        System.out.println("------------------------------------------------------FIN-----------------------------------------------------------------------------------------------");
    }
}
