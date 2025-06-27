package Processor.medium;

import java.util.*;

public class DesignANumberContainerSystem2349 {
    public static class WordDictionary {

        static class Trie {
            static class QueueItem {
                TrieNode crr; // search in this node
                int index; // index of current character

                public QueueItem(TrieNode crr, int index) {
                    this.crr = crr;
                    this.index = index;
                }
            }

            static class TrieNode {
                TrieNode[] children;
                boolean end;

                public TrieNode() {
                    // lowercase English letters = 26
                    children = new TrieNode[26];
                }

                public boolean isEndWord() {
                    return end;
                }
            }

            TrieNode root;

            public Trie() {
                this.root = new TrieNode();
            }

            public void insert(String s) {
                TrieNode crr = root;
                for (int i = 0; i < s.length(); i++) {
                    if (crr.children[s.charAt(i) - 'a'] == null) {
                        crr.children[s.charAt(i) - 'a'] = new TrieNode();
                    }
                    crr = crr.children[s.charAt(i) - 'a'];
                }
                crr.end = true;
            }

            private boolean searchBFS(String s) {
                Queue<QueueItem> queue = new LinkedList<>();
                //add root to item;
                queue.add(new QueueItem(root, 0));
                while (!queue.isEmpty()) {
                    QueueItem item = queue.poll();
                    if (item == null)
                        break;
                    TrieNode current = item.crr;
                    if (item.index < (s.length() - 1)) {
                        if (s.charAt(item.index) == '.') {
                            queue.addAll(Arrays.stream(current.children)
                                    .filter(Objects::nonNull)
                                    .map(i -> new QueueItem(i, item.index + 1))
                                    .toList());
                        } else {
                            if (current.children[s.charAt(item.index) - 'a'] != null) {
                                queue.add(new QueueItem(current.children[s.charAt(item.index) - 'a'], item.index + 1));
                            }
                        }
                    } else {
                        //check the last letter

                        if ((item.index > s.length() - 1)) //something wrong
                            return false;

                        if (s.charAt(item.index) == '.') {
                            if (Arrays.stream(current.children)
                                    .filter(Objects::nonNull)
                                    .anyMatch(TrieNode::isEndWord)) {
                                return true;
                            }
                        } else {
                            return (current.children[s.charAt(item.index) - 'a'] != null)
                                    && current.children[s.charAt(item.index) - 'a'].isEndWord();
                        }
                    }
                }
                return false;
            }

            public boolean search(String s) {
                return searchBFS(s);
            }
        }

        Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.insert(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }
    }

    public static void main(String[] args) {

    }
}
