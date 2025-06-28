package src.main.java.Processor.hard;

import java.util.ArrayList;
import java.util.List;

public class WorldBreakII140 {

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

        public boolean search(String s) {
            TrieNode curr = this.root;
            for (var c : s.toCharArray()) {
                if (!curr.checkExist(c)) {
                    return false;
                }
                curr = curr.next(c);
            }
            return curr.isEndOfWord();
        }


        public List<Integer> searchAllPrefix(String s, int start) {
            List<Integer> result = new ArrayList<>();
            TrieNode curr = this.root;
            for (int i = start; i < s.length(); i++) {
                var c = s.charAt(i);
                if (!curr.checkExist(c)) {
                    break;
                }
                curr = curr.next(c);
                if (curr.isEndOfWord()) {
                    result.add(i + 1);
                }
            }
            return result;
        }

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[][] path = new boolean[s.length()+1][s.length()+1];
        Trie trie = new Trie();
        List<Integer> queue = new ArrayList<>();
        int left = 0;
        int right = 0;

        for (String dict : wordDict) {
            trie.insert(dict);
        }

        List<String> result = new ArrayList<>();
        queue.add(0);
        do {
            var curr = queue.get(left);
            left++;
            var allMatch = trie.searchAllPrefix(s, curr);
            for (var rs : allMatch) {
                path[curr][rs] = true;
                queue.add(rs);
                right++;
            }
        } while (left <= right);

        for (int i = 0; i < s.length(); i++) {
            if (path[s.length() - 1][i]) {

            }
        }
        return result;
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