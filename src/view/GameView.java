package view;

import control.Game;
import model.GamePlotParts;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by R2 on 01.08.2015.
 */
public class GameView {
    public GameView(){
        System.out.println();
        System.out.println("\t+------------------------+");
        System.out.println("\t|The debaglings adventure|");
        System.out.println("\t+------------------------+");
        System.out.println();
    }
    public void view(){
        System.out.println(GamePlotParts.start());
        char enter0 = enter();
        boolean flag = true;
        while (flag){
            switch (enter0){
                case '1':
                    System.out.println(GamePlotParts.introduction());
                    enter();
                    Game.start(1);
                    flag = false;
                    break;
                case '2':
                    Game.start(2);
                    flag = false;
                    break;
                case '3':
                    Game.start(3);
                    flag = false;
                    break;
                case '4':
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Don't understand, please again!");
                    enter0 = enter();
                    break;
            }

        }
    }
    private static char enter(){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        char ch = ' ';
        try {
            ch = (char)inputStreamReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        return ch;
    }
}
