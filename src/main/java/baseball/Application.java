package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
        if (input.length() > 3){
            throw new IllegalArgumentException();
        }
        int[] result = new int[]{};
        for (int i = 0; i < input.length(); i++){
            try {
                int val = (int) input.charAt(0);
                if (!answer.contains(val)){
                    continue;
                }

                if (answer.get(i) == val) {
                    result[0] += 1;
                    continue;
                }

                result[1] += 1;
            } catch (Exception e){
                throw new IllegalArgumentException();
            }
        }

        return result;
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
