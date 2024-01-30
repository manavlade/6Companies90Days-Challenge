/*
 Question 11
Design a data structure that supports adding new words and finding if a string matches 
any previously added string. Implement the WordDictionary class: WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches 
word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */
public class Question11 {
    class WordDictionary {

        Node root;

        class Node {
            Node[] child = new Node[26];
            boolean isEnd;
        }

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.child[index] == null) {
                    current.child[index] = new Node();
                }

                current = current.child[index];
            }

            current.isEnd = true;
        }

        public boolean search(String word) {
            return searchChild(word, root, 0);
        }

        public boolean searchChild(String word, Node child, int strIndex) {
            Node current = child;
            boolean result = false;

            for (int i = strIndex; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (ch == '.') {
                    for (Node c : current.child) {
                        if (c != null && searchChild(word, c, i + 1))
                            return true;
                    }

                    return result;
                } else {
                    int index = ch - 'a';
                    current = current.child[index];
                    if (current == null) {
                        return false;
                    }
                }
            }

            return current != null && current.isEnd;
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
