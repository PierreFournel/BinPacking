import java.util.ArrayList;
import java.util.List;

public class Pack {

    private List<Item> items;
    private double capacity;
    private double current_size;

    public Pack(double capacity) {
        items = new ArrayList();
        this.capacity = capacity;
        current_size = 0;
    }

    public boolean canAddItem(Item item) {
        if (capacity - current_size > item.getSize())
            return true;
        return false;
    }

    public void addItem(Item item) {
        items.add(item);
        current_size += item.getSize();
    }

    public double getAvailibity() {
        return capacity - current_size;
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
