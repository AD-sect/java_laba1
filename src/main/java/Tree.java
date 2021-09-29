
public class Tree {

    private class Node {
        private Node parent;
        private List children;
        private Object value;
        private int index;

        Node(Object value) {
            this.value = value;
            this.children = new List();
            parent = null;
            index = 0;
        }

        Node(){
            this.value = null;
            this.children = null;
            parent = null;
            index = 0;
        }

        public Object getValue() {return value;}

        public Node getParent() {return parent;}

        public List getChildren() {return children;}

        public void setValue(Object value) {this.value = value;}

        public void setParent(Node p) { parent = p;}

        public void setChildren(List children) {this.children = children;}
    }

    private Node root;
    private static int maxAmountOfChildren;
    private int size;

    Tree(Object value, int AmountOfChildren){
        root = new Node(value);
        this.maxAmountOfChildren = AmountOfChildren;
        size = 1;
    }

    Tree(int AmountOfChildren){
        root = new Node();
        maxAmountOfChildren = AmountOfChildren;
        size = 0;
    }

    public void addChild(Node value){


    }




}


