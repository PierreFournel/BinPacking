public class BinaryNode {

    private Pack nodePack;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(Pack pack){
        this.nodePack = pack;
        left = null;
        right = null;
    }

    public Pack getNodePack() {
        return nodePack;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setNodePack(Pack nodePack) {
        this.nodePack = nodePack;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public double minVal(){
        if (left == null){
            return nodePack.getAvailibity();
        }
        else {
            return this.left.minVal();
        }
    }

    public BinaryNode remove(double val, BinaryNode parent){
        if (val < this.getNodePack().getAvailibity()){
            if (left != null){
                return left.remove(val, this);
            }else{
                return null;
            }
        }
        else if (val > this.nodePack.getAvailibity()){
            if (right != null){
                return right.remove(val, this);
            }
            else return null;
        }
        else {
            if (left != null && right != null){
                this.setNodePack(right.getNodePack());
                return right.remove(this.getNodePack().getAvailibity(),this);
            }
            else if (parent.left==this){
                if (left!=null){
                    parent.left = left;
                }else{
                    parent.left = right;
                }
                return this;
            }
            else if (parent.right==this){
                if (left!=null){
                    parent.right = left;
                }else{
                    parent.right = right;
                }
                return this;
            }
        }
        return null;
    }
}
