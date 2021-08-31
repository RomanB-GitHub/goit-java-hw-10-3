import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main_Home_Task_10 {
    public static void main(String[] args) {

        List<String> allNames = Arrays.asList("Ivan Groznuy", "Andrey Malahov", "Peter Pen", "Styven King",
                "Bob Marley", "Tommy Lee", "Chack Noris", "Westly Snayps");

        String[] numbers = {"1, 2, 0", "4, 5"};

        //Task-1
        System.out.println("Task-1");
        System.out.println("Метод принимает на вход список имен. Вернуть строку в виде: \"1. Ivan, 3. Peter ...\",\n" +
                " с именами из списка, стоящими под нечетным индексом (1, 3 и т.д.) результат :\n" +
                Tasks.getOddNames(allNames));
        System.out.println("***");

        //Task-2
        System.out.println("Task -2");
        System.out.println("Метод принимает на вход список из строк (можно список из Задания 1).\n" +
                " Возвращает список этих строк в верхнем регистре и " +
                "отсортированные по убыванию (от Z до А) результат:\n" +
                Tasks.returnSortInUpperCase(allNames));
        System.out.println("***");

        //Task-3
        System.out.println("Task-3");
        System.out.println("Дан массив:[\"1, 2, 0\", \"4, 5\"]\n" +
                " Получить из массива все числа, вернуть в отсортированном виде, разделенные запятой, то есть\n" +
                "\n \"0, 1, 2, 4, 5\" результат:\n " + Tasks.convertFromArray(numbers));
        System.out.println("***");

        //Task-4
        System.out.println("Task-4");
        System.out.println(
                "Используя Stream.iterate сделайте бесконечный стрим рандомных чисел, " +
                "\n но не используя Math.random. Реализуйте свой \"линейный конгруэнтный генератор\". " +
                "\n Для этого начните с x[0] = seed и затем каждый следующий элемент x[n + 1] = 1 (a x[n] + c) % m," +
                "\n для корректных значений a, c, и m. Необходимо имплементировать метод, который " +
                "\n принимает на вход параметрыa, c, m и seed и возвращает Stream<Long>. " +
                "\n Для теста используйте данные a = 25214903917, c = 11 и m = 2^48 (2 в степени 48) результат:\n " +
                Tasks.randomDigitsStream(25214903917L, 11, (long) Math.pow(2,48),29)
                .limit(20)
                .collect(Collectors.toList())
        );
        System.out.println("***");

        //Task-5
        System.out.println("Task-5");
        System.out.println("Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) " +
                "\n который \"перемешивает\" элементы из стримов first и second, останавливается тогда, " +
                "\n когда у одного из стримов закончатся элементы результат:\n "  +
                Tasks.zip(IntStream.range(24,36).boxed(),IntStream.range(12,28).boxed()).collect(Collectors.toList()));
        System.out.println("***");

    }
}
