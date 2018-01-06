public class Item {

    private double size;

    public Item(){
        this.size = Math.random();
    }

    public Item(double size) throws ItemException {
        this.size = size;
    }


    public void checkSize(double size) throws  ItemException{
        if(!(0<=size && size<=1))
            throw new ItemException("Taille non comprise entre 0 et 1");
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size)  {
        this.size = size;
    }
}
