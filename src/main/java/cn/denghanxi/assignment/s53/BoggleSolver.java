package cn.denghanxi.assignment.s53;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BoggleSolver {

    private Map<String, Boolean> dic;
    private Set<String> result;
    private boolean[][] marked;
    private Node root;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        this.dic = new HashMap<>();
        for (String s : dictionary) {
            dic.put(s, true);
        }
        root = new Node();
        for (String s : dictionary) {
            if (s.length() > 0) {
                setupNode(root, s, 0);
            }
        }
    }

    private void setupNode(Node root, String s, int i) {
        if (root.next[s.charAt(i)] == null) {
            root.next[s.charAt(i)] = new Node();
        }
        if (i + 1 < s.length()) {
            setupNode(root.next[s.charAt(i)], s, i + 1);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        result = new HashSet<>();
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                marked = new boolean[board.rows()][board.cols()];
                StringBuilder stringBuilder = new StringBuilder();
                crawl(board, i, j, stringBuilder, root);
            }
        }
        return result;
    }

    private void crawl(BoggleBoard board, int row, int col, StringBuilder stringBuilder, Node node) {
        char c = board.getLetter(row, col);
        stringBuilder.append((c == 'q' || c == 'Q') ? "QU" : c);
        checkIfAWord(stringBuilder);

        Node nextNode = nextNode(node, c);
        if (nextNode == null) {
            if (c == 'q' || c == 'Q') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return;
        }
        ;
        marked[row][col] = true;

        //go on
        //-1 0
        if (row - 1 >= 0 && !marked[row - 1][col]) {
            crawl(board, row - 1, col, stringBuilder, nextNode);
        }
        //-1 +1
        if (row - 1 >= 0 && col + 1 < board.cols() && !marked[row - 1][col + 1]) {
            crawl(board, row - 1, col + 1, stringBuilder, nextNode);
        }
        //0 +1
        if (col + 1 < board.cols() && !marked[row][col + 1]) {
            crawl(board, row, col + 1, stringBuilder, nextNode);
        }
        //+1 +1
        if (row + 1 < board.rows() && col + 1 < board.cols() && !marked[row + 1][col + 1]) {
            crawl(board, row + 1, col + 1, stringBuilder, nextNode);
        }
        //+1 0
        if (row + 1 < board.rows() && !marked[row + 1][col]) {
            crawl(board, row + 1, col, stringBuilder, nextNode);
        }
        //+1 -1
        if (row + 1 < board.rows() && col - 1 >= 0 && !marked[row + 1][col - 1]) {
            crawl(board, row + 1, col - 1, stringBuilder, nextNode);
        }
        //0 -1
        if (col - 1 >= 0 && !marked[row][col - 1]) {
            crawl(board, row, col - 1, stringBuilder, nextNode);
        }
        //-1 -1
        if (row - 1 >= 0 && col - 1 >= 0 && !marked[row - 1][col - 1]) {
            crawl(board, row - 1, col - 1, stringBuilder, nextNode);
        }
        marked[row][col] = false;
        if (c == 'q' || c == 'Q') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    private Node nextNode(Node node, char c) {
        if (c == 'q' || c == 'Q') {
            if (node.next[c] == null) return null;
            return node.next[c].next['U'];
        }
        return node.next[c];
    }

    private void checkIfAWord(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 2) {
            if (isAWord(stringBuilder.toString())) {
                result.add(stringBuilder.toString());
            }
        }
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (dic.get(word) == null) return 0;
        switch (word.length()) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            default:
                return 11;
        }
    }

    private boolean isAWord(String s) {
        return dic.get(s) == null ? false : true;
    }

    // R-way trie node
    private static class Node {
        private Node[] next = new Node[256];
    }
}

