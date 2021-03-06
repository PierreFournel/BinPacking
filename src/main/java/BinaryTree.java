import javax.swing.tree.TreeNode;
import java.util.Stack;

public class BinaryTree {

    BinaryNode root;

    public BinaryTree() {
        root = null;
    }

    private BinaryNode findMax(BinaryNode binaryNode) {
        if (binaryNode != null) {
            while (binaryNode.getRight() != null) {
                binaryNode = binaryNode.getRight();
            }
        }
        return binaryNode;
    }

    private BinaryNode findMin(BinaryNode binaryNode) {
        if (binaryNode != null) {
            while (binaryNode.getLeft() != null) {
                binaryNode = binaryNode.getLeft();
            }
        }
        return binaryNode;
    }
/*
    public int count() {

        int count=0;
        Stack<BinaryNode> visitStack = new Stack();
        visitStack.push(this.root);
        while (!visitStack.isEmpty()) {
            count++;
            BinaryNode next = visitStack.pop();
            if (next.getLeft() != null) {
                visitStack.push(next.getLeft());
            }
            if (next.getRight() != null) {
                visitStack.push(next.getRight());
            }
        }

    }
*/

    private BinaryNode getBestNode(BinaryNode binaryNode, double space) {
        BinaryNode best = null;
        boolean trouve = false;
        while (this.root != null && !trouve) {
            if (root.getNodePack().getAvailibity() == space) {
                return root;
            } else if (root.getNodePack().getAvailibity() > space) {
                best = root;
                root = root.getLeft();
            } else if (root.getNodePack().getAvailibity() < space) {
                root = root.getRight();
            } else {
                best = root;
                trouve = true;
            }
        }
        return best;
    }

    private BinaryNode insert(Pack pack, BinaryNode binaryNode) {
        if (binaryNode == null) {
            return new BinaryNode(pack);
        }
        if (pack.getAvailibity() > binaryNode.getNodePack().getAvailibity()) {
            binaryNode.setRight(insert(pack, binaryNode.getRight()));
        } else if (pack.getAvailibity() <= binaryNode.getNodePack().getAvailibity()) {
            binaryNode.setLeft(insert(pack, binaryNode.getLeft()));
        }
        return binaryNode;
    }

    private BinaryNode removeMax(BinaryNode a, BinaryNode b) {
        if (a.getRight() == null) {
            b.setNodePack(a.getNodePack());
            return a.getLeft();
        }
        a.setRight(removeMax(a.getRight(), b));
        return a;
    }

    private BinaryNode deleteNode(BinaryNode root, double cle) {
        if (root == null) {
            return root;
        }
        if (cle < root.getNodePack().getAvailibity()) {
            root.setLeft(deleteNode(root.getLeft(), cle));
        } else if (cle > root.getNodePack().getAvailibity()) {
            root.setRight(deleteNode(root.getRight(), cle));
        } else {
            if (root.getLeft() == null) {
                BinaryNode tmp = root.getRight();
                root = null;
                return tmp;
            } else if (root.getRight() == null) {
                BinaryNode tmp = root.getLeft();
                root = null;
                return tmp;
            }
            BinaryNode tmp = findMin(root.getRight());
            root.setNodePack(tmp.getNodePack());
            root.setRight(deleteNode(root.getRight(), (int) tmp.getNodePack().getAvailibity()));
        }
        return root;
    }

    private void deleteObj(BinaryNode node) {
        if (node == null) {
            return;
        } else {
            if (node.getLeft() != null) {
                deleteObj(node.getLeft());
            }
            if (node.getRight() != null) {
                deleteObj(node.getRight());
            }
            node = null;
        }
    }


    public void insert(Pack pack) {
        this.root = insert(pack, this.root);
    }

    public Pack getBestPack(double space) {
        BinaryNode best = getBestNode(this.root, space);
        if (best != null) {
            return best.getNodePack();
        } else {
            return new Pack(0.0);
        }
    }

    public BinaryNode findMax() {
        return findMax(this.root);
    }

    /* public void display(){
         display(this.root);
     }
 */
    public BinaryNode getRoot() {
        return this.root;
    }

    public void deleteNode(double cle) {
        this.root = deleteNode(this.root, cle);
    }

}
