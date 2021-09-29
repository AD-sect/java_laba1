
import java.util.Objects;

public class Map{

    private class Pair{
        private Object key;
        private Object value;

        Pair(Object key, Object value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}' + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(key, pair.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public Object getKey() {return key;}
        public Object getValue() {return value;}
        public void setKey(Object key) {this.key = key;}
        public void setValue(Object value) {this.value = value;}
    }

    @Override
    public String toString() {
        return "Map{" +
                "map=" + map +
                '}';
    }

    private List map;

    Map(Object key, Object value){
        Pair pair = new Pair(key, value);
        map = new List(pair);
    }

    public void put(Object key, Object value){
        Pair pair = new Pair(key,value);

        if (map.contains(pair)){
            map.set(pair, map.indexOf(pair));
        } else{
            map.add(pair);
        }
    }

    public Object get(Object key) {
        Pair pair = new Pair(key, null);
        if (map.contains(pair)) {
            return ((Pair) map.get(map.indexOf(pair))).getValue();
        } else {
            return null;
        }
    }

    public Object get(Object key, Object bydefault){
        Pair pair = new Pair(key, bydefault);
        if (map.contains(pair)) {
            return ((Pair) map.get(map.indexOf(pair))).getValue();
        }else{
            put(key, bydefault);
            return bydefault;
        }
    }

    public Object remove(Object key){
        Pair pair = new Pair(key, null);
        if (map.contains(pair)) {
            Object value = get(key);
            map.remove(map.indexOf(pair));
            return value;
        } else{
            return null;
        }
    }

    public boolean keyContains(Object key){
        Pair pair = new Pair(key, null);
        if (map.contains(pair)) {
            return true;
        }else{
            return false;
        }
    }

    public List getKeys(){
        if(map.isEmpty()){
            return null;
        }else {
            List list = new List();
            for (int i = 0; i < map.size(); i++) {
                list.add(((Pair) map.get(i)).getKey());
            }
            return list;
        }
    }

    public List getValues(){
        if(map.isEmpty()){
            return null;
        }else {
            List list = new List();
            for (int i = 0; i < map.size(); i++) {
                list.add(((Pair) map.get(i)).getValue());
            }
            return list;
        }
    }

    public List getEntries(){
        return map;
    }
    public int size(){
        return map.size();
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }

    
    public static void main(String[] args) {
        Map a = new Map(1, "apple");
        a.put(2, "banana");
        a.put(3, " kivi");


        //System.out.print(a.isEmpty());


        //a.remove(77)   ;
        System.out.print("\n");
        System.out.print(a.getValues());

    }


}
