package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    public static void main(String[] args) {
//        입력받는다. 3번의 기회가 주어진다. 맞추면 종료 계속하려면 1 아니면 2
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        int i = 0;
        while (true){
            String input = Console.readLine();
            int[] result = check(input);
            System.out.println(getResultMsg(result));
            if (result[0] == 3){
                i = 3;
            }
            i++;
            if (i > 3){
                Boolean wantContinue = Console.readLine().equals("1");
                if (!wantContinue) break;
                i = 0;
            }
        }
    }

    public static int[] check(String input){
        return new int[]{};
    }

    public static String getResultMsg(int[] result){
        int strike = result[0];
        int ball = result[1];
        int nothing = result[2];
        return "";
    }
}
