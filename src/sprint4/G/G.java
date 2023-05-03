package sprint4.G;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G {

    public static void main(String[] args) throws IOException {
        String path = "src/sprint4/G/4G.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));

        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            var num = Integer.parseInt(reader.readLine());
            if (num == 0) {
                System.out.println("0");
                return;
            }
            var rounds = reader.readLine().split(" ");

            System.out.println(solution(num, rounds));
        }
    }

    private static int solution(int num, String[] rounds) {
        int maxRoundDraw = 0;
        int sum = 0;

        Map<Integer, Integer> resultIdx = new HashMap<>();
        resultIdx.put(0, -1);

        for (int i = 0; i < num; i++) {
            if (rounds[i].equals("0")) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (!resultIdx.containsKey(sum)) {
                resultIdx.put(sum, i);
            } else {
                maxRoundDraw = Math.max(maxRoundDraw, i - resultIdx.get(sum));
            }

        }
        return maxRoundDraw;
    }
}
