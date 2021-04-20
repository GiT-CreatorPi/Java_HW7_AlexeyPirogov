//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021 19:10

package ChildClass;

import MainClass.WildAnimal;

public class WildCat extends WildAnimal {

    protected static int counterWildCat;  //количество объектов класса HomeAnimal

    // инициализатор static отвечает за зануление счётчика количества домашних животных
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterWildCat = 0;
    }

    // инициализатор для инкремента количества домашних кошек
    {
        counterWildCat++;
    }

    // параметризированный конструктор для домашних кошек
    public WildCat(){
        super("cat");
    }

    @Override   //переопределённый метод для плавания котов
    public final void swim(int distance) {
        String gender = this.correctPrint();
        System.out.print(this.name + " увидел" + gender + " воду ... боится воды...\n");
    }

    // Метод класса для получения информации о всех созданных объектах класса HomeAnimal
    protected final static int getCountWildCat() {
        System.out.println("Количество объектов в классе \"WildCat\": " + counterWildCat);
        return counterWildCat;
    }

    // Метод класса для получения данных из поля совмещённый с текстом
    // позволяет обратиться к методу c модификатором protected
    public static int getCountAnimals() {
        return getCountWildCat();  // функци возвращает количество живтных
    }

    // Перегруженная функция deadAnimal() класса HomeAnimal
    // если функция будет переопределена @Override и не будет содержать вызова
    // родительской функции то подсчёт количества животных в родительском классе
    // будет некорректный
    public final void deadAnimal(){
        super.deadAnimal(); // вызов родительской функции
        counterWildCat--;   // декремент счётчика
    }
}
