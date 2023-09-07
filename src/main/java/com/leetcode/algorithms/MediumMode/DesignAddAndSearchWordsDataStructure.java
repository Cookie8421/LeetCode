package com.leetcode.algorithms.MediumMode;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 */
public class DesignAddAndSearchWordsDataStructure {

    Node root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new Node();
    }

    public void addWord(String word) {
        root.addWord(word,0);
    }

    public boolean search(String word) {
        return root.search(word,0);
    }

    /**
     * Runtime
     * 162 ms
     * Beats
     * 86.86%
     * Memory
     * 96.8 MB
     * Beats
     * 65.88%
     *
     * Approch: prefix tree (Implement Trie)
     */
    class Node{
        Node[] nodes;
        boolean isEnd;

        Node(){
            nodes = new Node[26];
        }

        private void addWord(String word, int index){
            if(index >= word.length())
                return;
            int i = word.charAt(index) - 'a';
            if(nodes[i] == null){
                nodes[i] = new Node();
            }
            if (index == word.length()-1)
                nodes[i].isEnd = true;
            nodes[i].addWord(word, index+1);
        }

        private boolean search(String word, int index) {
            if (index >= word.length())
                return false;
            if(word.charAt(index) == '.'){
                if (index == word.length() - 1){
                    for(int i = 0; i < 26; i++){
                        if(nodes[i] != null && nodes[i].isEnd){
                            return true;
                        }
                    }
                    return false;
                }
                for(int i = 0; i < 26; i++){
                    if(nodes[i] != null && nodes[i].search(word, index+1)){
                        return true;
                    }
                }
                return false;
            } else {
                Node node = nodes[word.charAt(index) - 'a'];
                if (node == null)
                    return false;
                if (index == word.length() - 1 && node.isEnd)
                    return true;
                return node.search(word, index+1);
            }
        }
    }

}
