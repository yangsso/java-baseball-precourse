package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int i = 0;
        List<Integer> answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        while (true){
            String input = Console.readLine();
            int[] result = check(input, answer);
            System.out.println(getResultMsg(result));
            if (result[0] == 3){
                i = 3;
            }
            i++;
            if (i > 3){
                boolean wantContinue = Console.readLine().equals("1");
                if (!wantContinue) break;
                i = 0;
                answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            }
        }
    }

    public static int[] check(String input, List<Integer> answer){
        return new int[]{};
    }

    public static String getResultMsg(int[] result){
        String resultMsg = "";

        int strike = result[0];
        int ball = result[1];

        if (ball > 0) {
            resultMsg += String.format("%s볼", ball);
        }

        if (strike > 0) {
            resultMsg += String.format("%s스트라이크", strike);
        }

        if (ball == 0 && strike == 0){
            resultMsg = "낫싱";
        }

       return resultMsg;
    }
}
