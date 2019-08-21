package DevelopPack.Units.Transport;

import DevelopPack.Field;
import DevelopPack.Interfaces.ShotAble;

import java.util.Arrays;

public class Tank extends CommonTransport implements ShotAble {

    private int patrons;

    public Tank(int hor, int vert)  {
        super(hor, vert);
        patrons = 100;
        if(Field.thingsOnField.contains(this)){
            System.out.println("Вы создали танк."+ "\nОн расположен в квадрате "+
                    (getPositionX()+1)+"—"+(getPositionY()+1) +"\nЗапас патрон: " + getPatrons()+"\n------------------------");
        }



    }

    @Override
    public int getPatrons() {
        return patrons;

    }

    @Override
    public void loadPatrons(){
        this.patrons = 100;
    }


    @Override
    public void shot() {
        --patrons;
        System.out.println(this.getClass().getSimpleName()+ " произвел выстрел в сторону "+ getOrientation()+"\nОсталось " + getPatrons() +
                " патронов."+"\n------------------------");
    }

    @Override
    public String toString(){
        return "Танк находится на позиции: " + (getPositionX()+1)+"—"+(getPositionY()+1)+"\nНаправлен в сторону: "+ getOrientation()+"\nЗапас патронов: "+getPatrons()+"\n------------------------";

    }

}
