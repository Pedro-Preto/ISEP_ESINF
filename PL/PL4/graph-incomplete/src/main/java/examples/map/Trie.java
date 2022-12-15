package examples.map;

import graph.*;

/**
 *
 * @author DEI-ESINF
 *
 */
public class Trie {

    private static final Integer NO_STATE = -1;
    private static final Integer MIN_STATE = 100;

    private static Integer nextState(Graph<Integer, Character> trie, Integer vo, Character c) {
        for (Edge<Integer, Character> e : trie.outgoingEdges(vo)) {
            if (e.getWeight().equals(c)) return e.getVDest();
        }
        return NO_STATE;
    }

    private static Integer checkSequenceRec(Graph<Integer, Character> trie, Character[] sequence,
                                            Integer vo, Integer i) {
        if (vo.equals(NO_STATE)) return NO_STATE;
        if (i.equals(sequence.length)) return (vo < MIN_STATE ? vo : NO_STATE);

        return checkSequenceRec(trie, sequence, nextState(trie, vo, sequence[i]), i + 1);
    }

    public static Integer checkSequence(Graph<Integer, Character> trie, Character[] sequence) {

        return checkSequenceRec(trie, sequence, 0, 0);
    }

/* Iterative alternative

    public static Integer checkSequence(Graph<Integer, Character> trie, Character[] sequence) {

        Integer vo = 0;

        for (Character c : sequence) {
            vo = nextState(trie, vo, c);

            if (vo.equals(NO_STATE)) return NO_STATE;
        }

        return (vo < MIN_STATE ? vo : NO_STATE);
    }
*/
}
