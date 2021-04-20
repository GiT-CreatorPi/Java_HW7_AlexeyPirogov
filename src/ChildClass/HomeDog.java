//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021 19:10

package ChildClass;          // класс входит в пакет ChildClass
import MainClass.HomeAnimal; // подключение пакета подключение класса HomeAnimal пакета MainClass

// Класс HomeDog является наследником класса HomeAnimal
public class HomeDog extends HomeAnimal {

    protected static int counterHomeDog;  //количество объектов класса HomeAnimal

    // инициализатор static отвечает за зануление счётчика количества домашних животных
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterHomeDog = 0;
    }

    // инициализатор для инкремента количества домашних кошек
    {
        counterHomeDog++;
    }

    // параметризированный конструктор для домашних кошек
    public HomeDog(String name, boolean gender, String color, int ageMonths){
        super("dog", name, gender, color, ageMonths);
    }

    // Метод класса для получения информации о всех созданных объектах класса HomeAnimal
    protected final static int getCountHomeDog() {
        System.out.println("Количество объектов в классе \"HomeDog\": " + counterHomeDog);
        return counterHomeDog;
    }

    // Метод класса для получения данных из поля совмещённый с текстом
    // позволяет обратиться к методу c модификатором protected
    public static int getCountAnimals() {
        return getCountHomeDog();  // функци возвращает количество живтных
    }

    // Перегруженная функция deadAnimal() класса HomeAnimal
    // если функция будет переопределена с использованием @Override и не будет содержать вызова
    // родительской функции, то подсчёт количества животных в родительском классе будет некорректный
    public final void deadAnimal(){
        super.deadAnimal(); // вызов родительской функции
        counterHomeDog--;   // декремент счётчика
    }

    // Альтернативный способ декремента количества животных, не используется в работе, но привдён в как пример
    // Достоинства: меньшее количество кода, простота понимания, выше быстродействие скорее всего
    // Недостатки: счёчики спрятаны внутри классов, что может приводить к ошибкам,
    // а также необходимость писать такой же код в смежных классах для собак, необходимость
    // писать код для вывода информации о смерти животного, но данный метод уже есть в классе Animal
    public final void deadAnimalAlternative(){
        counterAnimals--;
        counterHomeAnimals--;
        counterHomeDog--;
    }

}
