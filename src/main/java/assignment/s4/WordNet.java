package assignment.s4;

import edu.princeton.cs.algorithms.Digraph;
import edu.princeton.cs.introcs.In;

import java.util.*;

public class WordNet {

    private Set<String> synsetsSet;
    private Map<Integer, Set<String>> keyToValue;
    private Map<String, Set<Integer>> valueToKey;
    private Digraph digraph;

    public WordNet(String synsets, String hypernyms) {
        synsetsSet = new HashSet<>();
        keyToValue = new HashMap<>();
        valueToKey = new HashMap<>();

        In synsetsIn = new In(synsets);
        while (true) {
            String inLine = synsetsIn.readLine();
            if (inLine == null) break;
            String[] ss = inLine.split(",");
            int key = Integer.parseInt(ss[0]);
            String[] values = ss[1].split(" ");
            Set<String> valuesSet = new HashSet<>();
            valuesSet.addAll(Arrays.asList(values));
            keyToValue.put(key, valuesSet);

            for (String s : values) {
                valueToKey.computeIfAbsent(s, s1 -> {Set<Integer> set = new HashSet<>(); valueToKey.put(s1, set);return set;});
                Set<Integer> set = valueToKey.get(s);
                set.add(key);
                synsetsSet.add(s);
            }
        }

        digraph = new Digraph(keyToValue.size());
        In hypernymsIn = new In(hypernyms);
        while (true) {
            String inLine = hypernymsIn.readLine();
            if (inLine == null) break;
            String[] ss = inLine.split(",");
            for (int i = 1 ; i < ss.length; i++) {
                digraph.addEdge(Integer.parseInt(ss[0]), Integer.parseInt(ss[i]));
            }
        }
    }

    public Iterable<String> nouns() {
        return synsetsSet;
    }

    public boolean isNoun(String word) {
        if (word == null) throw new IllegalArgumentException("null");
        return synsetsSet.contains(word);
    }

    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException("not exist");
        SAP sap = new SAP(digraph);
        Set<Integer> sourceA = valueToKey.get(nounA);
        Set<Integer> sourceB = valueToKey.get(nounB);
        return sap.length(sourceA, sourceB);
    }

    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException("not exist");
        SAP sap = new SAP(digraph);
        Set<Integer> sourceA = valueToKey.get(nounA);
        Set<Integer> sourceB = valueToKey.get(nounB);
        int ancestorKey = sap.ancestor(sourceA, sourceB);
        return keyToValue.get(ancestorKey).iterator().next();
    }

    public static void main(String[] args) {

    }
}
