/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import java.util.ArrayList;
import java.util.List;

/**
 * class that creates new game initializing it and run.
 */
public class Ass6Game {
    /**
     * initializing the game and run according to asked level.
     *
     * @param args receive strings from user
     */
    public static void main(String[] args) {
        List<LevelInformation> levelInformation = new ArrayList<>();
        int flag = 0;
        try {
            for (String s : args) {
                Integer.parseInt(s);
                flag = 1;
                break;
            }
        } catch (Exception e) {
            System.out.print("");
        }

        if (args.length == 0 || flag == 0) {
            //||(args[0]!=null) maybe can fix
            levelInformation.add(new DirectHit());
            levelInformation.add(new WideEasy());
            levelInformation.add(new Green3());
            levelInformation.add(new FinalFour());

        } else {
            for (String arg : args) {
                if (arg.equals("1")) {
                    levelInformation.add(new DirectHit());
                } else if (arg.equals("2")) {
                    levelInformation.add(new WideEasy());
                } else if (arg.equals("3")) {
                    levelInformation.add(new Green3());
                } else if (arg.equals("4")) {
                    levelInformation.add(new FinalFour());
                }
            }
        }

        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(levelInformation);
    }
}
