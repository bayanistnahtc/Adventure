package model;

import java.util.ArrayList;

/**
 * Created by R2 on 01.08.2015.
 */
public  class CarPart {
    private String name;
    private boolean work;
    public ArrayList<CarPart> nextParts;

    public CarPart (String name){
        this.name = name;
        this.work = true;
        nextParts = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void breakDown(){
        work = false;
    }
    public void repaired(){
        work = true;
    }


}
