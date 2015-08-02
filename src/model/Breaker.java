package model;

/**
 * Created by R2 on 02.08.2015.
 */
public class Breaker extends Character{
    public static final int MAX_LIFE_LEVEL = 3;
    public Breaker(String name){
        super(name);
        lifeLevel = 2;
    }
}
