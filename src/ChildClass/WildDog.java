//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021 19:10

package ChildClass;

import MainClass.WildAnimal;

public class WildDog extends WildAnimal {

    protected static int counterWildDog;  //количество объектов класса WildAnimal

    // инициализатор static отвечает за зануление счётчика количества домашних животных
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterWildDog = 0;
    }

    // инициализатор для инкремента количества домашних кошек
    {
        counterWildDog++;
    }

    // параметризированный конструктор для домашних кошек
    public WildDog(){
        super("dog");
    }

    // Метод класса Dog для создания стаи
    public static void createSwarm(WildDog[] swarm){
        for (int i = 0; i < swarm.length; i++){
            swarm[i] = new WildDog();
        }
    }

    // Метод для установки лидера в стае
    public static int setLeader(WildDog[] swarm){
        int numLeader = (int)Math.random() * 4;
        swarm[numLeader].leader = true;
        System.out.println("Лидер: \n" + swarm[numLeader].name);
        return numLeader;
    }

    // Метод класса Dog для отображения лидера
    public final static void showLeader(WildDog[] swarm){
        for (int i = 0; i < swarm.length; i++){
            if (swarm[i].leader == true)
                System.out.println("Лидер стаи: " + swarm[i].name);
        }
        System.out.println();
    }

    // Метод класса Dog для отображения стаи
    public final static void showSwarm(WildDog[] swarm){
        for (int i = 0; i < swarm.length; i++){
            swarm[i].show();
            System.out.println();
        }
    }

    // Метод класса для получения информации о всех созданных объектах класса HomeAnimal
    protected final static int getCountWildDog() {
        System.out.println("Количество объектов в классе \"WildDog\": " + counterWildDog);
        return counterWildDog;
    }

    // Метод класса для получения данных из поля совмещённый с текстом
    // позволяет обратиться к методу c модификатором protected
    public static int getCountAnimals() {
        return getCountWildDog();  // функци возвращает количество живтных
    }

    // Перегруженная функция deadAnimal() класса HomeAnimal
    // если функция будет переопределена @Override и не будет содержать вызова
    // родительской функции то подсчёт количества животных в родительском классе
    // будет некорректный
    public final void deadAnimal(){
        super.deadAnimal(); // вызов родительской функции
        counterWildDog--;   // декремент счётчика
    }

}
