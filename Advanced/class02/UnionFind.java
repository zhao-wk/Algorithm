package class02;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static void main(String[] args) {

    }

    public static class Element<V>{
        public V value;
        public Element(V value){
            this.value = value;
        }
    }
    public static class UnionFindSet<V>{
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list){
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V v : list) {
                Element<V> element = new Element<>(v);
                elementMap.put(v, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        public Element<V> findHead(Element<V> element){
            Stack<Element<V>> path = new Stack<>();
            while(element != fatherMap.get(element)){
                path.push(element);
                element = fatherMap.get(element);
            }
            while (path != null){
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public void union(V a, V b){
            if (elementMap.containsKey(a) && elementMap.containsKey(b)){
                Element<V> aHead = findHead(elementMap.get(a));
                Element<V> bHead = findHead(elementMap.get(b));
                if (aHead != bHead){
                    Element<V> big = rankMap.get(aHead) > rankMap.get(bHead) ? aHead : bHead;
                    Element<V> small = big == aHead ? bHead : aHead;
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(big) + rankMap.get(small));
                    rankMap.remove(small);
                }
            }
        }

        public boolean isSameSet(V a, V b){
            if (elementMap.containsKey(a) && elementMap.containsKey(b)){
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }
    }
}
