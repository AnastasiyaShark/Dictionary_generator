package DictionaryGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String inputString = "Apple BAnana PiNeapLe Apple buy LIST Next TO me";
//отличительная черта функционального стиля:использование чистой функции Function
// и использование Stream API (монада) в реализации интерфейса Function
        Function<String, List<String>> dictionaryFunction = str1 -> Arrays.stream(str1.split(" "))
                .distinct()
                .map(String::toLowerCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        printDictionary(dictionaryFunction, inputString);
    }
    static void printDictionary(Function<String, List<String>> dictionaryFunction, String str) {
        List<String> words = dictionaryFunction.apply(str);
        System.out.println("Get next words: ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
