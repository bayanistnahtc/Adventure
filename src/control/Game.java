package control;

import model.*;
import view.GameView;


import java.io.*;

/**
 * Created by R2 on 01.08.2015.
 * all Game process in this class
 */
public class Game implements Serializable{
    static Game game;
    private Game(){
    }

    public static void gameProcess(){
        Car porsche = new Car("Porsche911");
        Debagling minir = new Debagling("Minir");
        Breaker villain = new Breaker("Break");
        porsche.characters.add(minir);
        porsche.characters.add(villain);
        villain.move(TypeOfCarPart.BODY);

        System.out.println(GamePlotParts.part1());
        Inventory glucose = new Inventory("glucose", TypeOfInventory.FOOD);
        char enter = enter();
        while (true){
            if(enter == '1'){
                minir.putIntoBackpack(glucose);
                System.out.println("You have got " + minir.getBackpackSize() + "thing in your backpack" +
                        "\n 1) next \n");
                enter();
                break;
            }else {
                if(enter =='2'){
                    break;
                }
                System.out.println("Don't understand, please again!");
                enter = enter();
            }
        }
        minir.injure(1);
        System.out.println("You have arrived to new house" + "\n 1) enter");
        enter();

        minir.move(TypeOfCarPart.TRUNK);
        System.out.println(GamePlotParts.part2());
        enter = enter();
        minir.injure(1);
        boolean flag = true;
        while (flag){
            switch (enter){
                case '1':
                    minir.injure(4);
                    flag = false;
                    break;
                case '2':
                    flag = false;
                    break;
                case '3':
                    Inventory food = minir.getBackpack();
                    if( food != null){
                        minir.improveHealth(10);
                    }else {
                        System.out.println("You have not any food!" +
                                "\n 1) next");
                        enter();
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("Don't understand, please again!");
                    enter = enter();
                    break;
            }
        }

        System.out.println(minir.getLifeLevel());
        if (minir.getLifeLevel() >= 9){

        }else {
            GamePlotParts.part3();
            flag = true;
            while (flag){
                switch (enter){
                    case '1':
                        Inventory food = minir.getBackpack();
                        if( food != null){
                            minir.improveHealth(10);
                        }else {
                            System.out.println("You have not any food!" +
                                    "\n 1) next");
                            enter();
                        }
                        flag = false;
                        break;
                    case '2':
                        minir.improveHealth(1);
                        System.out.println("Collywobbles didnТt allow fall asleep.\n");

                    case '3':
                        System.out.println("You have died of hunger! \nGame over");
                        endGame();
                        flag = false;
                        break;
                    default:
                        System.out.println("Don't understand, please again!");
                        enter = enter();
                        break;
                }
            }

        }
        if(minir.getLifeLevel() >= 9){
            GamePlotParts.part4();
            enter = enter();
            flag = true;
            while (flag){
                switch (enter){
                    case '1':
                        GamePlotParts.part5();
                        char enter2 = enter();
                        while (true){
                            if(enter2 == '1'){
                                flag = false;
                                break;
                            }else {
                                if(enter2 =='2'){
                                    enter = '2';
                                    break;
                                }
                                System.out.println("Don't understand, please again!");
                                enter2 = enter();
                            }
                        }
                        break;
                    case '2':
                        System.out.println("The problem in motor has not been solved! \n " +
                                "and our old Porsche broken! \nGame over");
                        endGame();
                        break;
                    default:
                        System.out.println("Don't understand, please again!");
                        enter = enter();
                        break;
                }

            }

        }else {
            System.out.println("Continue did not create!");
            endGame();
        }
        minir.move(TypeOfCarPart.BODY);
        minir.injure(1);
        //
        //здесь главный бой с враогом
        GamePlotParts.part6();
        enter = enter();
        while (true){
            if(enter == '1'){
                minir.injure(villain.getLifeLevel());
                System.out.println("To be continued!");
                endGame();
                break;
            }else {
                if(enter =='2'){
                    System.out.println("Breaker hurt you the back, you was not able to survive! \n" +
                            "Game over!");
                    endGame();
                    break;
                }
                System.out.println("Don't understand, please again!");
                enter = enter();
            }
        }




    }


    public static void save() {
        Game game;
        try {
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            game = new Game();
            oos.writeObject(game);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public static void load(){
        Game game;
        FileInputStream fis = null;
            try {
                fis = new FileInputStream("temp.out");
                ObjectInputStream oin = new ObjectInputStream(fis);
                game = (Game)oin.readObject();
            }catch (IOException e) {
                System.out.println("IOException");
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException");
            }

    }

    public static void endGame(){
        System.out.println("\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\nGoodbye!\n" +
                "\n");
        GameView gameView = new GameView();
        gameView.view();
    }

    public static void newGame(){
        game = new Game();
        gameProcess();
    }
    public static void start(int typeStart){

     switch (typeStart){
         case 1:
             newGame();
             break;
         case 2:
             save();
             break;
         case 3:
             load();
             break;
         default:
             break;
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

        if(ch == 'q'){
            System.out.println("Are you sure you want to exit game? y/n");
            char enter2 = enter();
            while (true){
                if(enter2 == 'y'){
                    System.out.println("Do you want to save game? y/n");
                    char enter3 = enter();
                    while (true){
                        if(enter3 == 'y'){
                            Game.save();
                            Game.endGame();
                            break;
                        }else {
                            if(enter3=='n'){
                                Game.endGame();
                                break;
                            }
                            System.out.println("Don't understand, please again!");
                            enter3 = enter();
                        }
                    }
                    break;
                }else {
                    if(enter2 =='n'){
                        break;
                    }
                    System.out.println("Don't understand, please again!");
                    enter2 = enter();
                }
            }
        }
        return ch;
    }
}
