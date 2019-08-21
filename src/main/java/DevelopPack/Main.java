package DevelopPack;

import DevelopPack.Interfaces.Orientation;
import DevelopPack.Units.GameThings;
import DevelopPack.Units.Objects.GuardTower;
import DevelopPack.Units.Objects.Rock;
import DevelopPack.Units.Objects.Wind;
import DevelopPack.Units.Transport.CommonTransport;
import DevelopPack.Units.Transport.Tank;
import DevelopPack.Units.Transport.Tractor;


import java.util.ArrayList;
import java.util.List;

import static DevelopPack.Field.*;

public class Main {
    public static void main(String[] args) {
        new Field();

        ArrayList<GameThings> list = new ArrayList<>();
        GuardTower guardTower = new GuardTower(1,1);
        list.add(guardTower);
        Rock rock = new Rock(2,2);
        list.add(rock);
        Wind wind = new Wind(Orientation.NORTH);
        list.add(wind);
        Tank tank = new Tank(3,3);
        list.add(tank);
        Tractor tractor = new Tractor(4,4);
        list.add(tractor);

        for (GameThings thing: list){
            thing.moveForwards();
            thing.rotate();
            thing.shot();
        }

        viewField();



    }
}
