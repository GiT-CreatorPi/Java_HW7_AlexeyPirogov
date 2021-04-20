//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021 19:10

import MainClass.*;     // подключение пакета MainClass
import ChildClass.*;    // подключение пакета ChildClass
import Things.*;        // подключение пакета Things

public class HomeWorkApp_7 {

    public static void main(String[] args) {

        // Создание экземпляра класса HomeCat
        System.out.println("Создан экземпляр класса HomeCat...\n");
        HomeCat kitty = new HomeCat("Джесси", true, "черный", 2);
        kitty.show();

        // Создание экземпляра класса Plate
        System.out.println("\nСоздан экземпляр класса Plate...");
        Plate plate = new Plate(0, "Корм для животных");
        plate.countFood();  // уточнение количества еды в тарелке
        kitty.eat(plate);   // кормёжка кота

        plate.addEatInPlate(0, "Корм для животных");
        plate.countFood();  // уточнение количества еды в тарелке
        kitty.eat(plate);   // кормёжка кота

        plate.addEatInPlate(1, "Корм для животных");
        plate.countFood();  // уточнение количества еды в тарелке
        kitty.eat(plate);   // кормёжка кота

        plate.addEatInPlate(5, "Корм для животных");
        plate.countFood();  // уточнение количества еды в тарелке
        kitty.eat(plate);   // кормёжка кота

        plate.addEatInPlate(10, "Корм для животных");
        plate.countFood();  // уточнение количества еды в тарелке
        kitty.eat(plate);   // кормёжка кота

        plate.addEatInPlate(70, "Корм для животных");
        plate.countFood();  // уточнение количества еды в тарелке
        kitty.eat(plate);   // кормёжка кота

        System.out.print("\n\n----------------------------------" +
                           "\n Пример кормеления домашних котов:" +
                           "\n----------------------------------\n");

        System.out.print("Создан массив экземпляров класса HomeCat...\n");
        HomeCat cats[] = new HomeCat[3];
        cats[0] = new HomeCat("Максик", true, "черный", 1);
        cats[1] = new HomeCat("Марфуша", false, "белая", 1);
        cats[2] = new HomeCat("Рыжик", true, "рыжий", 1);

        int i = 1;
        for (HomeCat cat : cats){
            System.out.println("\nПитомец №" + i + ":\n-------------------------");
            cat.show();
            System.out.println();
            cat.eat(plate);
            i++;
        }

        // создание экземпляра класса WildCat
        System.out.println("\n\nСоздан экземпляр класса WildCat...\n");
        WildCat kitty_2 = new WildCat();
        kitty_2.show();
        kitty_2.swim(10);
        kitty_2.eat(plate);

        System.out.print("\n\n-------------------------------" +
                           "\n Пример кормеления диких котов:" +
                           "\n-------------------------------\n");

        System.out.print("\nСоздан массив экземпляров класса WildCat...\n");
        WildCat wcats[] = new WildCat[5];
        for (int j = 0; j < wcats.length; j++) {
            wcats[j] = new WildCat();
        }

        i = 1;
        for (WildCat cat : wcats){
            System.out.println("\nДикий котей №" + i + ":\n-------------------------");
            cat.show();
            System.out.println();
            cat.eat(plate);
            i++;
        }

        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("\nПример добавления корма больше максимального значения");
        plate.addEatInPlate(600, "Корм для животных");
        plate.countFood();  // уточнение количества еды в тарелке


        System.out.println("\n--------------------------------------------------------\n" +
                           "\nПример создания тарелки c использованием непараметризированного конструктора: ");
        Plate plate2 = new Plate();
        plate2.countFood();

        System.out.print("\n\n----------------------------------" +
                           "\n Пример кормеления домашей собаки:" +
                           "\n----------------------------------\n");

        // создание экземпляра класса HomeDog
        HomeDog doggi = new HomeDog("Рыжик", true, "рыжий", 1);
        System.out.println("Создан экземпляр класса HomeDog...\n");
        doggi.show();
        doggi.eat(plate2);

        System.out.print("\n\n-------------------------------" +
                           "\n Пример кормеления диких собак:" +
                           "\n-------------------------------\n");

        System.out.println("\n\nПример создания стаи собак:");
        WildDog swarm[] = new WildDog[4];
        WildDog.createSwarm(swarm);
        WildDog.setLeader(swarm);
        WildDog.showLeader(swarm);
        WildDog.showSwarm(swarm);

        i = 1;
        for (WildDog dog : swarm){
            System.out.println("\nДикий собакен №" + i + ":\n-------------------------");
            dog.show();
            System.out.println();
            dog.eat(plate2);
            i++;
        }

        System.out.print("\n--------------------------------------" +
                         "\n Пример вывода информации о животных: " +
                         "\n--------------------------------------\n");
        Animal.getCountAnimals();       // обращение к методу класса Animal
        HomeAnimal.getCountAnimals();   // обращение к методу класса HomeAnimal
        WildAnimal.getCountAnimals();   // обращение к методу класса WildAnimal
        HomeCat.getCountAnimals();      // обращение к методу класса HomeCat
        HomeDog.getCountAnimals();      // обращение к методу класса HomeDog
        WildCat.getCountAnimals();      // обращение к методу класса WildCat
        WildDog.getCountAnimals();      // обращение к методу класса WildDog
        System.out.println("\n");
        kitty_2.deadAnimal();
        kitty_2.show();
        System.out.println();
        Animal.getCountAnimals();       // обращение к методу класса Animal
        HomeAnimal.getCountAnimals();   // обращение к методу класса HomeAnimal
        WildAnimal.getCountAnimals();   // обращение к методу класса WildAnimal
        HomeCat.getCountAnimals();      // обращение к методу класса HomeCat
        HomeDog.getCountAnimals();      // обращение к методу класса HomeDog
        WildCat.getCountAnimals();      // обращение к методу класса WildCat
        WildDog.getCountAnimals();      // обращение к методу класса WildDog

        System.out.println("\n\nПример использования методов разработанных в ДЗ №6:");
        kitty.swim(10);
        kitty.run(10);
        System.out.println();
        doggi.swim(15);
        doggi.run(350);

    }

}
