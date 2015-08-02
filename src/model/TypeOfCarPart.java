package model;

/**
 * Created by R2 on 02.08.2015.
 */
public enum TypeOfCarPart {
    OUTSIDE, TRUNK, BODY, WHEEL, MOTOR, FAR;
    public static TypeOfCarPart getType(int number)
    {
        return TypeOfCarPart.values()[number];
    }

    public static int getNumber(TypeOfCarPart typeOfCarPart)
    {
        return typeOfCarPart.ordinal();
    }
}
