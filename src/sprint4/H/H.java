package sprint4.H;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class H {

    private static final String responseYes = "YES";
    private static final String responseNo = "NO";

    public static void main(String[] args) throws IOException {
        String path = "src/sprint4/H/4H.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));

        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String s = reader.readLine();
            String t = reader.readLine();
            System.out.println(solution(s, t));
        }
    }

    private static String solution(String s, String t) {

        if (s.length() != t.length()) {
            return responseNo;
        }

        Map<Character, Character> first2second = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sLatter = s.charAt(i);
            char tLatter = t.charAt(i);

            if (first2second.containsKey(sLatter) && first2second.get(sLatter) != tLatter) {
                return responseNo;
            }

            if (!first2second.containsKey(sLatter) && first2second.containsValue(tLatter)) {
                return responseNo;
            }

            if (!first2second.containsKey(sLatter)) {
                first2second.put(sLatter, tLatter);
            }
            first2second.put(s.charAt(i), t.charAt(i));
        }
        return responseYes;
    }
}
