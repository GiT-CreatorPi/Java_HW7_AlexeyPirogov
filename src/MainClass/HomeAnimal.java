//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021 19:10

package MainClass;  // класс входит в пакет MainClass

// и является наследником абстрактного класса Animal
// нужен для хранения информации о домашних живтоных

public class HomeAnimal extends MainClass.Animal {

    protected static int counterHomeAnimals;  //количество объектов класса HomeAnimal

    // инициализатор static отвечает за зануление счётчика количества домашних животных
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterHomeAnimals = 0;
    }

    // инициализатор отвечает за создание и установку полей
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    {
        counterHomeAnimals++;   // инкремент количества домашних животных
    }

    // параметризированный конструктор для класса HomeAnimal
    public HomeAnimal(String typeAnimal, String name, boolean gender, String color, int ageMonths){
        super();    //вызов конструктора родительского класса для подсчёта общего количества животных
        // Родительский класс абстрактный !!!
        // в конкретной реализации будут вызываться блоки кода вызываемые по умолчанию - инициализаторы
        // если таких блоков не будет, то будет возникать ошибка в логике обработки данных
        // компилятор об ошибках не выдавал уведомления
        this.live = true;       // питомец живой
        this.pet = true;        // питомец домашний

        this.typeAnimal = typeAnimal;   // тип животного
        this.name = name;               // установка клички
        this.gender = gender;           // пол
        this.color = color;             // окрас
        this.ageMonths = ageMonths;     // установка возраста

        // в заисимости от типа животного устанавливаем максимальную длину бега и плаванья
        switch (typeAnimal) {
            case "cat": {
                this.maxDistanceRun = 200;    // альтернатива для кошек
                this.maxDistanceSwim = 1;     // плаванье ...
                break;
            }
            case "dog": {
                this.maxDistanceRun = 500;     // альтернатива для собак
                this.maxDistanceSwim = 10;     // плаванье ...
                break;
            }
        }
        // Определение атрибутов сытости животного и употребления еды:
        int baseCurrentSatietyAnimal = 0; // переменная отвечающая за аппетит животного у собак тело больше, чем у кошек
        int baseMaxSatietyAnimal = 0;
        int increment = 0;
        // поэтому собакам нужно больше корма
        if (this.typeAnimal == "cat") { // для кошек
            baseCurrentSatietyAnimal = 17;
            baseMaxSatietyAnimal = 35;
            increment = 5;
        } else {    // для собак
            baseCurrentSatietyAnimal = 11;
            baseMaxSatietyAnimal = 55;
            increment = 7;
        }
        this.satietyMaxCount = (int)(Math.random() * baseMaxSatietyAnimal + increment);
        this.satietyCount = (int) Math.abs(satietyMaxCount - (Math.random() * baseCurrentSatietyAnimal + increment)); // расчёт сытости в условных единицах
        // Формирование уровня satietyCount строго меньше satietyMaxCount
        while(true) {
            if (this.satietyMaxCount <= this.satietyCount) {
                this.satietyCount = (int) Math.abs(satietyMaxCount - (Math.random() * baseCurrentSatietyAnimal + increment)); // расчёт сытости в условных единицах
                continue;
            } else {
                break;
            }
        }
        // проверка условия для установки атрибута сытости
        if (this.satietyMaxCount == this.satietyCount) satiety = true;                  // установка флага сытости для животного
        else satiety = false;
        this.bite = (int)(Math.random() * 2 + 1);                  // количество еды потребляемой за один укус, прирощение сытости / убыль еды в тарелке
    }

    // Перегруженный метод для домашних животных
    public void swim(int distance) {
        super.swim(distance);
    }

    // Метод класса HomeAnimal для получения информации о всех созданных объектах класса
    protected final static int getCountHomeAnimalsProtected() {
        System.out.println("Количество объектов в классе \"HomeАnimal\": " + counterHomeAnimals);
        return counterHomeAnimals;
    }

    // Метод класса для получения данных из поля совмещённый с текстом
    // позволяет обратиться к методу c модификатором protected
    public static int getCountAnimals() {
        return getCountHomeAnimalsProtected();  // функци возвращает количество живтных
    }

    // Перегруженная функция deadAnima() абстрактного класса Animal
    // если функция будет переопределена @Override и не будет содержать вызова
    // родительской функции то подсчёт количества животных в родительском классе будет некорректный
    public void deadAnimal(){
        super.deadAnimal();     // вызов родительской функции
        counterHomeAnimals--;   // декремент счётчика
    }
}
