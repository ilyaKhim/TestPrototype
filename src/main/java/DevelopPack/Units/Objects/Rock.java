package DevelopPack.Units.Objects;

import DevelopPack.Field;
import DevelopPack.Interfaces.Positionable;

import java.util.Arrays;

public class Rock extends CommonObject implements Positionable {

    private int[] position;
    public Rock(int hor, int vert){
        this.position = new int[]{hor-1,vert-1} ;
        System.out.println("Вы разместили глыбу в квадрате " +
                (getPositionX()+1)+"—"+(getPositionY()+1)+"\n------------------------");
        Field.addTo(this);
    }

    @Override
    public boolean setPosition(int[] position) {
        if(Field.isBounded(position)){
            Field.removeFrom(this);
            this.position = position;
            Field.addTo(this);
            return true;
        }
        return false;
    }

    @Override
    public int[] getPosition() {
        return this.position;
    }

    @Override
    public int getPositionX() {
        return getPosition()[0];
    }

    @Override
    public int getPositionY() {
        return getPosition()[1];
    }

    @Override
    public void moveForwards() {

    }

    @Override
    public void rotate() {
    }

    @Override
    public void shot() {
    }

    @Override
    public String toString(){
        return "Глыба лежит в квадрате "+ (getPositionX()+1)+"—"+(getPositionY()+1)+"\n------------------------";
    }

}
