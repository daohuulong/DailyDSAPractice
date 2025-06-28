package src.main.java.Processor.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs677 {

    static class MapSum {
        static class Trie {
            Map<String, Integer> valueMap;
            TrieNode trieNode;
            public Trie() {
                trieNode = new TrieNode();
                valueMap = new HashMap<>();
            }

            public void insert(String key, int val) {
                var crr = trieNode;
                var delta = 0;
                if(valueMap.containsKey(key)) {
                    delta = val - valueMap.get(key);
                }
                valueMap.put(key, val);
                for(var c : key.toCharArray()) {
                    if(crr.nodes[c-'a'] == null) {
                        crr.nodes[c-'a'] = new TrieNode();
                    }
                    crr.nodes[c-'a'].val += delta;
                    crr = crr.nodes[c-'a'];
                }
            }

            public int search(String key) {
                var crr = trieNode;
                for(var c : key.toCharArray()) {
                    if(crr.nodes[c-'a'] == null) {
                        return 0;
                    }
                    crr = crr.nodes[c-'a'];
                }
                return crr.val;
            }
        }

        static class TrieNode {
            TrieNode[] nodes;
            int val;

            public TrieNode() {
                val = 0;
                nodes = new TrieNode[26];
            }
        }

        Trie trie;

        public MapSum() {
            trie = new Trie();
        }

        public void insert(String key, int val) {
            trie.insert(key, val);
        }

        public int sum(String prefix) {
            return trie.search(prefix);
        }
    }
}
