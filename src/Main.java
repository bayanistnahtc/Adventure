import control.Game;
import model.GamePlotParts;
import view.GameView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by R2 on 01.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        gameView.view();
    }

}
