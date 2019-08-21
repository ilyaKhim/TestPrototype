package DevelopPack.Units.Objects;

import DevelopPack.Field;
import DevelopPack.Interfaces.Orientable;
import DevelopPack.Interfaces.Orientation;

public class Wind extends CommonObject implements Orientable {

    private Orientation orientation;
    public Wind(Orientation orientation){
        this.orientation = orientation;
        System.out.println("... И тут подул ветер...на "+ getOrientation()+"\n------------------------");
    }

    public int[] getPosition(){
        return null;
    }

    @Override
    public int getPositionX() {
        return 0;
    }

    @Override
    public int getPositionY() {
        return 0;
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
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString(){
        return "Ветер дует на "+getOrientation()+"\n------------------------";
    }

}
