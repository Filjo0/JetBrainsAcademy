package Exercises.Collections;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Squares list
Implement a method called pow2 that takes a collection of numbers
and returns a collection of squares of these numbers.

Sample Input:
10 20 -5

Sample Output:
100 400 25
 */

class CollUtils {

    public static Collection<Integer> pow2(Collection<Integer> numbers) {
        List<Integer> srcList = (List<Integer>) numbers;
        for (int i = 0; i < srcList.size(); i++) {
            var numToAdd = srcList.get(i) * srcList.get(i);
            srcList.set(i, numToAdd);
        }
        return numbers;
    }
}

public class Squares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collection<Integer> result = Exercises.Collections.CollUtils.pow2(numbers);

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}