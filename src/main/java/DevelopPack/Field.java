package DevelopPack;

import DevelopPack.Interfaces.Orientation;
import DevelopPack.Units.GameThings;

import java.util.*;

public class Field {

    private static final int SIZE = 5;
    public static GameThings[][] field = null;
    public static ArrayList<GameThings> thingsOnField = null;

    public Field(){
        field =new GameThings[SIZE][SIZE];
        thingsOnField = new ArrayList<>();
    }

    public static boolean isBounded(int[] position){
        if(position[0] >= 0 && position[0]<5 && position[1]>=0 && position[1]<5){
            return true;
        }
        return false;
    }

    /*public static boolean isMovementAvailable(GameThings things, Orientation orientation){
        switch (orientation){
            case EAST:{
                if(things.getPositionY()==4){
                    System.out.println("Впереди стена. east");
                    return false;
                }
            }
            case SOUTH:{
                if(things.getPositionX()==4){
                    System.out.println("Впереди стена south.");
                    return false;

                }
            }
            case WEST:{
                if(things.getPositionY()==0){
                    System.out.println("Впереди стена. west");
                    return false;
                }
            }
            case NORTH:{
                if(things.getPositionX()==0){
                    System.out.println("Впереди стена.north");
                    return false;
                }
            }
        }
        return true;
    }*/

    public static boolean isEmpty(GameThings thing) {
        if (field[thing.getPositionX()][thing.getPositionY()] != null) {
            System.out.println("Вы попытались создать "+thing.getClass().getSimpleName()+" в клетке "+
                    (thing.getPositionX()+1)+"—"+(thing.getPositionY()+1)+".\nЭта клетка поля уже занята " +
                    field[thing.getPositionX()][thing.getPositionY()].getClass().getSimpleName()
                    +".\nПопробуйте создать "+ thing.getClass().getSimpleName()+" в другом месте.\n------------------------");
            thingsOnField.remove(thing);
            return false;
        }
        return true;
    }

    public static void addTo(GameThings thing) {
        if (!thingsOnField.contains(thing)) thingsOnField.add(thing);
        if (thing.getPosition() != null) {
            if (isEmpty(thing)) {
                field[thing.getPosition()[0]][thing.getPosition()[1]] = thing;
            }
        }
    }


    public static void viewAllThings(){
        System.out.println("Содержимое того, что находится на поле: ");
        for (GameThings gameThings : thingsOnField) {
            System.out.println(gameThings.getClass().getSimpleName());
        }
        System.out.println("------------------------");
    }

    public static void viewField(){
        for (int i = 1; i<=field.length; i++){
            for (int j = 1; j<= field.length; j++){
                try{
                    System.out.print(field[i-1][j-1].getClass().getSimpleName()+" ");
                } catch (NullPointerException e){
                    System.out.print(field[i-1][j-1]+" ");
                }
            }
            if(i==3) System.out.print("           — состояние поля.");
            System.out.println();
        }
        System.out.println("------------------------");


    }

    public static void removeFrom(GameThings thing){
        field[thing.getPosition()[0]][thing.getPosition()[1]] = null;
        thingsOnField.remove(thing);
    }

}


