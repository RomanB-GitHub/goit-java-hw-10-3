import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Tasks {

    //Task-1
    public static List<String> getOddNames(List<String> allNames) {
        List<String> results = new ArrayList<>();
        int counter = 0;
        for (String name : allNames) {
            counter++;
            name = counter + "." + name;

            if (counter % 2 != 0) {
                results.add(name);
            }
        }
        return results;
    }

    //Task-2
    public static List<String> returnSortInUpperCase(List<String> allNames) {
        List<String> sortList = allNames
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        sortList.replaceAll(String::toUpperCase);
        return sortList;
    }

    //Task-3
    public static String convertFromArray(String[] numbers) {
        return Arrays.stream(numbers)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .collect(Collectors.joining(", "));
    }

    //Task-4
    public static Stream<Long> randomDigitsStream(long a, long c, long m, long seed) {
        if (checkParametrs(a, c, m, seed)) {
            return Stream.iterate(seed, n -> 1 * (a * n + c) % m);
        } else {
            throw new RuntimeException("Not correct parametr");
        }
    }

    private static boolean checkParametrs(long a, long c, long m, long seed) {
        return (m >= 2 && a >= 0 && a < m && c >= 0 && c < m && seed >= 0 && seed < m);
    }

    //Task-5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return Stream.concat(first, second).collect(Collectors.collectingAndThen(
                toList(),
                list -> {
                    Collections.shuffle(list);
                    return list.stream();
                }));
    }
}
