package class01;

import java.util.HashMap;

public class RandomPool {
    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("KFC");
        pool.insert("crazy");
        pool.insert("thursday");
    }

    public static class Pool<K>{
        public HashMap<K, Integer> keyIndex;
        public HashMap<Integer, K> indexKey;
        public int size;

        public Pool(){
            keyIndex = new HashMap<>();
            indexKey = new HashMap<>();
            size = 0;
        }

        public void delete(K key){
            if (keyIndex.containsKey(key)){
                int deleteIndex = keyIndex.get(key);
                int lastIndex = --this.size;
                K lastKey = indexKey.get(lastIndex);

                keyIndex.put(lastKey, deleteIndex);
                indexKey.put(deleteIndex, lastKey);
                keyIndex.remove(key);
                indexKey.remove(lastIndex);
            }
        }

        public void insert(K key){
            if (!keyIndex.containsKey(key)){
                keyIndex.put(key, size);
                indexKey.put(size, key);
                size++;
            }
        }

        public K getRandom(){
            if (this.size == 0){
                return null;
            }
            int randomNumber = (int)(Math.random() * this.size);
            return indexKey.get(randomNumber);
        }
    }
}
