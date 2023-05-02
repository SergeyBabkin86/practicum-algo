package sprint4.D;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class D {

    public static void main(String[] args) throws IOException {
        String path = "src/sprint4/D/4D.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));

        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            int lineNum = Integer.parseInt(reader.readLine());
            var society = reader.lines().collect(Collectors.toList());
            solution(society, lineNum).values().forEach(System.out::println);
        }
    }

    private static Map<Integer, String> solution(List<String> list, int n) {
        Map<Integer, String> map = new HashMap<>(n);
        int key = 0;

        for (String str : list) {
            if (!map.containsValue(str)) {
                map.put(key, str);

                key++;
            }
        }
        return map;
    }
}
