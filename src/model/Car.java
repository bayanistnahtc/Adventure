package model;

import com.sun.javafx.geom.AreaOp;

import java.util.ArrayList;

/**
 * Created by R2 on 01.08.2015.
 */
public class Car {
    private String name;
    public ArrayList<CarPart> carParts;
    public ArrayList<Character> characters;

    public Car(String name){
        this.name = name;
        carParts = new ArrayList<>();
        characters = new ArrayList<>();
        setCarParts();
    }
    public String getName() {
        return name;
    }

    private void setCarParts(){
        CarPart trunk = new CarPart("trunk");

        carParts.add(trunk);
        CarPart body = new CarPart("body");
        carParts.add(body);
        CarPart wheel = new CarPart("wheel");
        carParts.add(body);
        CarPart motor = new CarPart("motor");
        trunk.nextParts.add(wheel);
        trunk.nextParts.add(body);
        wheel.nextParts.add(trunk);
        body.nextParts.add(trunk);
        body.nextParts.add(motor);
        motor.nextParts.add(body);

    }


}
