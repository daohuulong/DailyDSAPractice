package src.main.java.Processor.hard;

import java.util.*;

public class WorldSearchII212_2 {
    static class Trie {
        static class TrieNode {
            TrieNode[] children;
            boolean endOfWord;

            TrieNode() {
                this.children = new TrieNode[26];
            }

            public boolean checkExist(char c) {
                return children[c - 'a'] != null;
            }

            public TrieNode next(char c) {
                return children[c - 'a'];
            }

            public void addChild(char c) {
                children[c - 'a'] = new TrieNode();
            }

            public boolean isEndOfWord() {
                return endOfWord;
            }
        }

        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode curr = this.root;
            for (var c : s.toCharArray()) {
                if (!curr.checkExist(c)) {
                    curr.addChild(c);
                }
                curr = curr.next(c);
            }
            curr.endOfWord = true;
        }

        private List<String> DFS(TrieNode node, List<String> result, StringBuilder crr) {
            if (node.endOfWord)
                result.add(crr.toString());
            for (char c = 'a'; c < 'z'; c++) {
                if (node.checkExist(c)) {
                    crr.append(c);
                    DFS(node.next(c), result, crr);
                    crr.deleteCharAt(crr.length() - 1);
                }
            }
            return result;
        }

        public int search(String s) {
            TrieNode curr = this.root;
            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);
                if (!curr.checkExist(c)) {
                    return -1;
                }
                curr = curr.next(c);
            }
            if (curr.isEndOfWord()) {
                return 1;
            }
            return 0;
        }

    }

    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private List<String> BFS(char[][] board, int x, int y, int m, int n, String word) {
        List<String> result = new ArrayList<>();
        Map<String, Set<String>> wordsMap = new HashMap<>();
        Set<String> first = new HashSet<>();
        first.add(x+""+y);
        wordsMap.put(String.valueOf(board[x][y]), first);
        while(!wordsMap.isEmpty()) {

        }
        return result;
    }


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        int m = board.length;
        int n = board[0].length;

        for (String dict : words) {
            trie.insert(dict);
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
            }
        return result.stream().toList();
    }
}
/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 * <p>
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * Input is generated in a way that the length of the answer doesn't exceed 105.
 */