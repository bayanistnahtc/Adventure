package model;

import java.util.Stack;

/**
 * Created by R2 on 01.08.2015.
 */
public class Debagling extends Character{
    Stack<Inventory> backpack;
    private static final int MAX_LIFE_LEVEL = 10;
    public Debagling(String name) {
        super(name);
        lifeLevel = MAX_LIFE_LEVEL ;
        backpack = new Stack<>();
    }
    /**
     *
     * @return null - if backpack is empty
     */
    public Inventory getBackpack() {
        if(!backpack.empty()){
            return backpack.pop();
        }
        return null;
    }

    public boolean putIntoBackpack(Inventory inventory){
        if(backpack.size() >= BACKPACK_SIZE){
            return false;
        }else {
            backpack.push(inventory);
            return true;
        }
    }
    public int getBackpackSize(){
        return backpack.size();
    }

    /**
     * power can't be less than zero
     * @param value
     * @return
     */
    public boolean improveHealth(int value){
        if (value < 0){
            return false;
        }
        if(lifeLevel + value >= MAX_LIFE_LEVEL ){
            lifeLevel = MAX_LIFE_LEVEL ;
        }else {
            lifeLevel+=value;
        }
        return true;
    }

}
