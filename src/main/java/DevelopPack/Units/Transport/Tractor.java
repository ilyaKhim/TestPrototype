package DevelopPack.Units.Transport;

import DevelopPack.Field;

import java.util.Arrays;

public class Tractor extends CommonTransport {

    public Tractor(int hor, int vert) { // TODO: 20.08.2019  обработать исключение при создании экземпляра вне поля.
        super(hor, vert);
        if (Field.thingsOnField.contains(this)){
            System.out.println("Вы создали трактор."+ "\nОн расположен в квадрате "+
                    (getPositionX()+1)+"—"+(getPositionY()+1)+ "\n------------------------"); // для удобства восприятия пользователя
        }
    }

    @Override
    public String toString(){
        return "Трактор стоит в квадрате "+ (getPositionX()+1)+"—"+(getPositionY()+1)+ ".\nПовернут в сторону " + getOrientation()+"\n------------------------";
    }


    @Override
    public void shot() {
    }
}
