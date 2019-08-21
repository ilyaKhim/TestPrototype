package DevelopPack.Units.Objects;

import DevelopPack.Field;
import DevelopPack.Interfaces.*;

import java.util.Arrays;

import static DevelopPack.Interfaces.Orientation.*;


public class GuardTower extends CommonObject implements Orientable, Positionable, Rotatable, ShotAble {

    private Orientation orientation;
    private String name;
    private int[] position;
    private int patrons;

    public GuardTower(int hor, int vert){
        this.position = new int[]{hor-1,vert-1};
        orientation = NORTH;
        patrons = 50;
        if(Field.isEmpty(this)){
            Field.addTo(this);
        }
        if (Field.thingsOnField.contains(this)){
            System.out.println("Вы создали защитную башню."+ "\nОна расположена в квадрате "+
                    (getPositionX()+1)+"—"+(getPositionY()+1)+ "\n------------------------"); // для удобства восприятия пользователя
        }
    }


    @Override
    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public int getPositionX() {
        return position[0];
    }
    @Override
    public int getPositionY(){
        return position[1];
    }

    @Override
    public void moveForwards() {

    }

    public int[] getPosition(){
        return position;
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
    public String toString(){
        return "Защитная башня находится на позиции: " +
                (getPositionX()+1)+"—"+(getPositionY()+1)+"\nНаправлен в сторону: "+ getOrientation()+"\n------------------------";
    }


    @Override
    public void rotate(){
        switch (orientation){
            case NORTH: {
                setOrientation(EAST);
                break;
            }
            case EAST:{
                setOrientation(SOUTH);
                break;
            }
            case SOUTH:{
                setOrientation(WEST);
                break;
            }
            case WEST:{
                setOrientation(NORTH);
                break;
            }

            // TODO: 20.08.2019 сделать дефолтный метод
        }
        System.out.println(this.getClass().getSimpleName() + " повернулся на " + getOrientation()+"\n------------------------");
    }

    @Override
    public int getPatrons() {
        return this.patrons;
    }

    @Override
    public void loadPatrons() {
        this.patrons = 50;
    }

    @Override
    public void shot() {
        --patrons;
        System.out.println(this.getClass().getSimpleName()+ " произвел выстрел в сторону "+ getOrientation()+"\nОсталось " + getPatrons() +
                " патронов."+"\n------------------------");
    }
}
