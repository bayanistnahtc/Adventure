package model;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by R2 on 01.08.2015.
 */
public abstract class Character {
    public static final int MAX_LIFE_LEVEL = 10;
    public static final int MIN_LIFE_LEVEL = 1;
    public static final int BACKPACK_SIZE = 3;
    private String name;
    protected int lifeLevel;
    public TypeOfCarPart typeOfCarPart = TypeOfCarPart.OUTSIDE;


    public Character(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void move(TypeOfCarPart typeOfCarPart){
        if(this.typeOfCarPart != TypeOfCarPart.FAR){
            this.typeOfCarPart = typeOfCarPart;
            injure(1);
        }
    }

    /**
     * power can't be less than zero
     * @param power
     * @return
     */
    public boolean injure(int power){
        if (power < 0){
            return false;
        }
        this.lifeLevel-=power;
        if(this.lifeLevel < MIN_LIFE_LEVEL){
            this.typeOfCarPart = TypeOfCarPart.FAR;
        }
        return true;
    }

    public int getLifeLevel(){
        return lifeLevel;
    }


}
