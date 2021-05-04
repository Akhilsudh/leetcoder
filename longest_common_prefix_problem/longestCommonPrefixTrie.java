import java.io.*;

// minimal Trie data structure to save the strings
class Trie {
    class Node {
        Node[] nodes;
        public Node() {
            nodes = new Node[26];
        }
    }

    Node root;
    
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node tempNode = root;
        int index;
        for(int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if(tempNode.nodes[index] == null) {
                tempNode.nodes[index] = new Node();
                tempNode = tempNode.nodes[index];
            }
            else {
                tempNode = tempNode.nodes[index];
            }
        }
    }
}

public class longestCommonPrefixTrie {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String prefix = "";
        int min = Integer.MAX_VALUE;
        Trie obj = new Trie();
        for(String item: strs){
            obj.insert(item);
            min = (item.length() < min)?item.length():min;
        }
        int count;
        for(int i = 0; i < min; i++) {
            count = 0;
            for(int j = 0; j < 26; j++) {
                if(obj.root.nodes[j] != null) {
                    count++;
                }    
            }
            if( count == 1) {
                prefix = prefix + strs[0].charAt(i);
            }
            else {
                break;
            }
            obj.root = obj.root.nodes[strs[0].charAt(i) - 'a'];
        }
        return prefix;
    }

    public static void main(String args[]) throws IOException {
        String [] arr = {"Aang", "Aang Avatar", "Aang Last Air Bender"};
        System.out.println("The largest common prefix is : " + longestCommonPrefix(arr));
        String [] arr2 = {"Akhil", "Akhil Sudhakaran", "Akhi", "Akhu"};
        System.out.println("The largest common prefix is : " + longestCommonPrefix(arr2));
        String [] arr3 = {"Aang", "Aang Avatar", "Zuko", "Azula"};
        System.out.println("The largest common prefix is : " + longestCommonPrefix(arr3));
    }
}