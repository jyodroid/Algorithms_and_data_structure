package algoritms_data_structures.datastructure;

import java.util.Scanner;

/**
 * Created by jyodroid on 10/9/17.
 * Data structure used to index and search structures inside a string.
 * O(n) to find a word where n is the size of the word
 * Allows to find words with single characters differents
 * The name trie is an infix of the word "retrieval"
 * Definition:
 * + the trie is a tree where each vertex represents a single word or a prefix
 * + The trie start with the empty string "" and the direct sons represent prefixes of lenght 1,
 *  the vertex that are 2 edge of distance from root are called prefixes of length 2 and so on. A vertex
 *  that are k edges from the root have an associate prefix of length k.
 */

public class TrieNode {

//    Because english alphabet (lower case only)
    private static int NUMBER_OF_WORDS = 26;

    TrieNode[] children = new TrieNode[NUMBER_OF_WORDS];
    int size = 0;

    private static int getCharIndex(char c){
        return c - 'a';
    }

    private TrieNode getNode(char c){
        return children[getCharIndex(c)];
    }

    private void setNode(char c, TrieNode node){
        children[getCharIndex(c)] = node;
    }

    public void addWord(String word, int index){
        size++;
        if (index == word.length()) return;
        char c = word.charAt(index);
        TrieNode childNode = getNode(c);
        if (childNode == null){
            childNode = new TrieNode();
            setNode(c, childNode);
        }
        childNode.addWord(word, index + 1);
    }

    public int findCount(String word, int index){
        if (index == word.length()) return size;
        TrieNode child = getNode(word.charAt(index));
        if (child == null) return 0;
        return child.findCount(word, index + 1);
    }
}