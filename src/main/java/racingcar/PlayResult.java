package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {
    // 실행 결과 출력 메소드
    public void getResult(String[] names, String[] results){
        for (int i = 0; i < names.length; i++) {
            int r = Randoms.pickNumberInRange(0, 9);
            if (r >= 4)
                results[i] += "-";
            System.out.println(results[i]);
        }
    }

    public void getWinner(String[] results){
        String max = results[0];
        List<String> winner = new ArrayList<>();

        for (int i = 1; i < results.length; i++) {
            if (max.split(":")[1].length() < results[i].split(":")[1].length()){
                max = results[i];
            }
        }
        String maxname = max.split(" ")[0];
        winner.add(maxname);

        for (int i = 0; i < results.length; i++) {
            String name = results[i].split(" ")[0];
            if (max.split(":")[1].length() == results[i].split(":")[1].length() && !maxname.equals(name)){
                winner.add(name);
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            if (i == winner.size() - 1){
                System.out.print(winner.get(i));
                break;
            }
            System.out.print(winner.get(i) + ", ");
        }
    }
}
