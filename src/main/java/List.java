public class List {

    private class Node{
         private Object data;
         private Node next;

         Node(Object data, Node next){
             this.data = data;
             this.next = next;
         }

         Node(Object data){
             this.data = data;
             this.next = null;
         }

         private Node getNext(){return this.next;}

         private Object getData(){return this.data;}

         private void setNext(Node next){this.next = next;}

         private void setData(Object data){this.data = data;}

         private void set(Object data, Node next){
             this.data= data;
             this.next = next;
         }

        @Override
        public java.lang.String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private int length;


    List(){
        head = null;
        length = 0;

    }
    List(Object data){
        head = new Node(data);
        length = 1;

    }

    List(Object[] dataMas, int length){
        for(int i = 0; i < length; i++){
            head = new Node(dataMas[i], head);
        }
        this.length = length;
    }

    @Override
    public java.lang.String toString() {
        return "List{" +
                "head=" + head +
                ", length=" + length +
                '}';
    }

    public Node goTo(int index){
        Node copyHead = head;
        for(int i = 0; i < index; i++){
            copyHead = copyHead.getNext();
        }
        return copyHead;
    }

    public void add(Object data){

        if(head == null){
            head = new Node(data);
            length = 1;
        }else {
            Node copyHead = head;
            Node cur = new Node(data, null);
            head = goTo(length - 1);

            head.set(head.getData(), cur);
            head = copyHead;
            length++;
        }
    }

    public void add(Object data, int index){
        if (index  >= length){
            add(data);
            length++;
        } else if(index <= 0){
            head = new Node(data, head);
            length++;
        }else {
            Node copyHead = head;
            copyHead = goTo(index - 1);

            Node cur = new Node(data, copyHead.getNext());
            copyHead.setNext(cur);

            length++;
        }
    }

    public Object remove(int index) {
        if ((index >= length) || (index < 0)){
            return null;
        } else {
            if (index == 0) {
                Object data = head.getData();
                head = head.getNext();

                length--;
                return data;
            } else {
                Node copyHead = head;
                copyHead = goTo(index - 1);

                Node cur = copyHead;
                copyHead = copyHead.getNext();
                Object data = copyHead.getData();
                cur.setNext(copyHead.getNext());
                cur = cur.getNext();

                length--;
                return data;
            }
        }
    }

    public Object get(int index){
        if ((index >= length) || (index < 0)){
            return null;
        } else {
            Node copyHead = head;
            copyHead = goTo(index);
            Object data = copyHead.getData();

            return data;
        }
    }

    int size(){
        return length;
    }

    public Object set(Object data, int index){
        if ((index >= length) || (index < 0)){
            return null;
        } else {
            Node copyHead = head;
            copyHead = goTo(index);
            copyHead.set(data, copyHead.getNext());

            return data;
        }
    }

    public boolean isEmpty(){
        if(length >= 0)
            return false;
        else
            return true;
    }

    public int indexOf(Object data){
        Node copyHead = head;
        for(int i = 0; i < length; i++){
            if(copyHead.getData().equals(data)){
                return i;
            }
            copyHead = copyHead.getNext();
        }
        return -1;
    }

    public boolean contains(Object data){
        if(indexOf(data) == -1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {

    }

}
