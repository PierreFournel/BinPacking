import java.util.ArrayList;
import java.util.List;

public class Pack {

    private List<Item> items;
    private double capacity;
    private double current_size;

    public  Pack(){
        items = new ArrayList();
        capacity = 1;
        current_size = 0;
    }



    public void addItem(Item item) throws PackException {
        if(capacity-current_size>item.getSize()) {
            items.add(item);
            current_size+= item.getSize();
            return;
        }
        throw new PackException("Impossible d'ajouter l'item au pack.");
    }

    public double getAvailibity(){
        return capacity-current_size;
    }



    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCurrent_size() {
        return current_size;
    }

    public void setCurrent_size(double current_size) {
        this.current_size = current_size;
    }
}
