package DevelopPack.Units.Transport;

import DevelopPack.Field;
import DevelopPack.Interfaces.*;
import DevelopPack.Units.GameThings;

import java.util.Arrays;

import static DevelopPack.Interfaces.Orientation.*;

public abstract class CommonTransport extends GameThings implements Moveable, Rotatable, Positionable, Orientable {

    private Orientation orientation;
    private int[] position;
    public CommonTransport(int hor, int vert){
        this.position = new int[]{hor-1, vert-1}; // позиция на карте
        orientation = NORTH; // дефолтное направление
        if(Field.isEmpty(this) && Field.isBounded(this.position)){
                Field.addTo(this);
        }



    }


    public void action(String command){
        switch (command){
            case "W":
            case "w":    {
                moveForwards();
                break;
            }
            case "t":
            case "T": {
                rotate();
                break;
            }

        }

    }

    @Override
    public void rotate(){
        switch (this.orientation){
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

        }
        System.out.println(this.getClass().getSimpleName() + " повернулся на " + getOrientation()+"\n------------------------");
    }

    @Override
    public void moveForwards() {
        boolean temp;
        try{
                switch (this.getOrientation()){
                    case EAST: {
                        temp = setPosition(new int[]{this.getPositionX(), this.getPositionY()+1});
                        if(temp){
                          break;
                        } else System.out.println("Не удалось переместиться. Вы направлены в сторону "+ getOrientation()+
                                ". Необходимо повернуться.");
                        return;
                    }
                    case SOUTH:{
                        temp=setPosition(new int[]{this.getPositionX()+1, this.getPositionY()});
                        if(temp){
                            break;
                        } else System.out.println("Не удалось переместиться. Вы направлены в сторону "+ getOrientation()+
                                ". Необходимо повернуться.");
                        return;
                    }
                    case WEST:{
                        temp=setPosition(new int[]{this.getPositionX(), this.getPositionY()-1});
                        if(temp){
                            break;
                        } else System.out.println("Не удалось переместиться. Вы направлены в сторону "+ getOrientation()+
                                ". Необходимо повернуться.");
                        return;
                    }
                    case NORTH:{
                           temp= setPosition(new int[]{this.getPositionX()-1, this.getPositionY()});
                        if(temp){
                            break;
                        } else System.out.println("Не удалось переместиться. Вы направлены в сторону "+ getOrientation()+
                                ". Необходимо повернуться.");
                        return;
                        }

            }
            System.out.println(this.getClass().getSimpleName() +" продвинулся на " + getOrientation()+"\n------------------------");

        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
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
    public int[] getPosition(){
        return position;
    }

    @Override
    public boolean setPosition(int[] position) {

        if(Field.isBounded(position)){
            Field.removeFrom(this);
            this.position  = position;
            Field.addTo(this);
            return true;
        }
        return false;


    }

    public void view(){
        System.out.println(this.getClass().getSimpleName()+"\nнаходится на позиции: "
                + Arrays.toString(getPosition())+"\nНаправлен в сторону: "+ getOrientation()+"\n------------------------");
    }

}
