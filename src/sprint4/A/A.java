package sprint4.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        String path = "src/sprint4/A/4A.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));

        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            int base = Integer.parseInt(reader.readLine());
            int mod = Integer.parseInt(reader.readLine());
            var string = reader.readLine();

            System.out.println(solution(base, mod, string));

        }
    }

    private static long solution(int base, int mod, String string) {
        var n = string.length();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return (int) string.charAt(0) % mod;
        }

        long hash = 0;
        for (int i = 0; i < string.length(); i++) {
            hash = (hash * base + string.charAt(i)) % mod;
        }
        return hash;
    }
}
