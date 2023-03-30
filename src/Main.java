import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст ");
        String text = scanner.nextLine();
        List<String> list = Arrays.asList(text.split("[-#$%^&!?,.0-9\\s]+"));
        Map<String, Integer> frequency = list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toMap(
                        e -> e, e -> 1, Integer::sum
                ));
        Map<String, Integer> sortedMapDesc = frequency.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("В тексте " + list.size() + " слов(а)");
        System.out.println("Топ 10: ");
        sortedMapDesc.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}