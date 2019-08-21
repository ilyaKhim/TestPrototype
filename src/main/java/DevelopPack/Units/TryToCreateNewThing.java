package DevelopPack.Units;

import DevelopPack.Field;

import java.util.Scanner;

public class TryToCreateNewThing <T>{

    public void whatYouWant(){
        new Field();


        System.out.println("Итак, Добро пожаловать в настольную игру 'Поле Битвы 2000'. Прежде чем приступить к созданию юнита,\n" +
                "я должен уточнить что ответы принимаются только в виде цифр.\nИтак, какого юнита вы хотите создать?\n"+
                "1. Строение\n2. Транспорт");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        switch (answer){
            case 1:

                break;
            case 2:

                break;
        }
    }

    /*public CommonTransport makeTransport() throws NoSuchFieldException {
        return new Tank("test", 1,2);
    }*/

}
