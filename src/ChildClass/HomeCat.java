//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021

package ChildClass;          // принадлежность к пакету ChildClass
import MainClass.Animal;
import MainClass.HomeAnimal; // подключение пакета подключение класса HomeAnimal пакета MainClass

// Класс HomeCat является наследником класса HomeAnimal
public class HomeCat extends HomeAnimal {

    protected static int counterHomeCat;  //количество объектов класса HomeAnimal

    // инициализатор static отвечает за зануление счётчика количества домашних животных
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterHomeCat = 0;
    }

    // инициализатор для инкремента количества домашних кошек
    {
        counterHomeCat++;
    }

    // параметризированный конструктор для домашних кошек
    public HomeCat(String name, boolean gender, String color, int ageMonths){
        super("cat", name, gender, color, ageMonths);
    }

    @Override   //переопределённый метод для плавания котов
    public final void swim(int distance) {
        String gender = this.correctPrint();
        System.out.print(this.name + " увидел" + gender + " воду ... боится воды...\n");
    }

    // Метод класса для получения информации о всех созданных объектах класса HomeAnimal
    protected final static int getCountHomeCat() {
        System.out.println("Количество объектов в классе \"HomeCat\": " + counterHomeCat);
        return counterHomeCat;
    }

    // Метод класса для получения данных из поля совмещённый с текстом
    // позволяет обратиться к методу c модификатором protected
    public static int getCountAnimals() {
        return getCountHomeCat();  // функци возвращает количество живтных
    }

    // Перегруженная функция deadAnimal() класса HomeAnimal
    // если функция будет переопределена @Override и не будет содержать вызова
    // родительской функции то подсчёт количества животных в родительском классе будет некорректный
    public final void deadAnimal(){
        super.deadAnimal(); // вызов родительской функции
        counterHomeCat--;   // декремент счётчика
    }

    // Альтернативный способ декремента количества животных, не используется в работе, но привдён в как пример
    // Достоинства: меньшее количество кода, простота понимания, выше быстродействие скорее всего
    // Недостатки: счёчики спрятаны внутри классов, что может приводить к ошибкам,
    // а также необходимость писать такой же код в смежных классах для собак, необходимость
    // писать код для вывода информации о смерти животного, но данный метод уже есть в классе Animal
    public final void deadAnimalAlternative(){
        counterAnimals--;
        counterHomeAnimals--;
        counterHomeCat--;
    }
}
