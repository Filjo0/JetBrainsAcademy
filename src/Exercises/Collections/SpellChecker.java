package Exercises.Collections;

import java.util.*;

class SpellChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> knownWords = new HashSet<>();
        int sizeOfKnown = Integer.parseInt(scanner.nextLine());
        while (sizeOfKnown > 0) {
            knownWords.add(scanner.nextLine().toLowerCase());
            sizeOfKnown--;
        }

        int sizeText = Integer.parseInt(scanner.nextLine());
        ArrayList<String> lines = new ArrayList<>();
        Set<String> text = new HashSet<>();
        while (sizeText > 0) {
            lines.add(scanner.nextLine().toLowerCase());
            sizeText--;
        }
        for (String line : lines) {
            Collections.addAll(text, line.split(" "));
        }

        HashSet<String> unknownWords = ColUtils.unknownWords(new HashSet<>(text), new HashSet<>(knownWords));

        LinkedList<String> list = new LinkedList<>(unknownWords);
        Iterator<String> itr = list.descendingIterator();
        while (itr.hasNext()) {
            String item = itr.next();
            System.out.println(item);
        }

    }
}

class ColUtils {

    public static HashSet<String> unknownWords(HashSet<String> list1, HashSet<String> list2) {
        list1.removeIf(list2::contains);
        return list1;
    }
}