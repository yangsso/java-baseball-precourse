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
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            int[] result = check(input, answer);
            System.out.println(getResultMsg(result));
            if (result[0] == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종");
                i = 3;
            }
            i++;
            if (i >= 3){
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int continueInput = Integer.parseInt(Console.readLine());
                if (continueInput > 2 || continueInput < 1) throw new IllegalArgumentException();
                if (continueInput == 2) break;
                i = 0;
                answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            }
        }
    }

    public static int[] check(String input, List<Integer> answer){
        if (input.length() != 3){
            throw new IllegalArgumentException();
        }
        int[] result = new int[3];
        for (int i = 0; i < input.length(); i++){
            try {
                int val = input.charAt(i) - '0';
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
