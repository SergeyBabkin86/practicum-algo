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
            int a = Integer.parseInt(reader.readLine());
            int mod = Integer.parseInt(reader.readLine());
            var string = reader.readLine().toCharArray();

            System.out.println(solution(a, mod, string));

        }
    }

    private static int solution(int a, int mod, char [] chars) {
        var n = chars.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return (int) chars[0] % mod;
        }

//        int result = 0;
//        for (Character ch : chars) {
//            result = (result + ((int) ((int) ch * Math.pow(a, n-1))))%mod;
//            n--;
//        }
        int result = (chars[0] * a + chars[1]) % mod;
        for (int i = 2; i < n; i++) {
            result = ((result * a) + chars[i]) % mod;
        }

//        int result = 0;
//        for (int i = 0; i < chars.length; i++) {
//            result = ((int)(result + (((int)(chars[i]))
//                    * Math.pow(a, chars.length - i - 1)))) % mod;
//
//        }

        return result%mod;
    }
}
