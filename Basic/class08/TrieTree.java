package class08;

public class TrieTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abd");
        int search = trie.search("abc");
        int ab = trie.prefixNumber("ab");
        System.out.println("search = " + search);
        System.out.println("ab = " + ab);
        trie.delete("abc");
        search = trie.search("abc");
        System.out.println("删除后 search = " + search);
        ab = trie.prefixNumber("ab");
        System.out.println("删除后 ab = " + ab);
        trie.insert("cde");
        trie.insert("cfg");
        search = trie.search("cde");
        System.out.println("search cde = " + search);
        search = trie.search("cgf");
        System.out.println("search cgf = " + search);

        trie.delete("cfg");
        trie.delete("cgf");
        search = trie.search("cfg");
        System.out.println("删除后 search cfg = " + search);
    }

    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            int pass = 0;
            int end = 0;

            nexts = new  TrieNode[26];
        }
    }

    public static class Trie{
        public TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        //word之前在树中出现了几次
        public int search(String word){
            if (word == null) return 0;

            TrieNode node =root;
            int index = 0;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre){
            if (pre == null) return 0;

            TrieNode node = root;
            int index = 0;
            char[] chs = pre.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        public void insert(String word){
            if (word == null) return;

            char[] chs = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            node.pass++;

            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word){
            int search = search(word);
            if (search == 0) return;

            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            int index = 0;


            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                node.nexts[index].pass--;
                if (node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }
}
