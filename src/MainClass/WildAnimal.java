//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021

package MainClass; // класс входи в пакет MainClass

// и является наследником абстрактного класса Animal
// нужен для хранения информации о домашних живтоных

public class WildAnimal extends MainClass.Animal {

    protected static int counterWildAnimals;  //количество объектов класса WildAnimal

    // инициализатор static отвечает за зануление счётчика количества домашних животных
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterWildAnimals = 0;
    }

    // инициализатор для инкремента количества домашних кошек
    {
        counterWildAnimals++;
    }

    // параметризированный конструктор для класса HomeAnimal
    public WildAnimal(String typeAnimal){
        super();    //вызов конструктора родительского класса для подсчёта общего количества животных
        // Родительский класс абстрактный !!!
        // в конкретной реализации будут вызываться блоки кода вызываемые по умолчанию - инициализаторы
        // если таких блоков не будет, то будет возникать ошибка в логике обработки данных
        // компилятор об ошибках не выдавал уведомления
        this.live = true;               // питомец живой
        this.pet = false;               // питомец домашний
        this.typeAnimal = typeAnimal;   // тип животного
        if (Math.random() * 100 <= 50) this.gender = false;     // пол опрелеляется произвольным образом
        else this.gender = true;        // самец, если
        this.ageMonths = (int)(Math.random() * 120 + 6);   // установка возраста произвольным образом
        // определение окраса произвольным образом
        String colorAnimal[] = {"Сер", "Бел", "Черн", "Рыж", "Коричнев", "Черепахов", "Двухцветн"};
        // если самец рыжий, то требуется корректный вывод
        if (this.gender == true){
            int num = (int)(Math.random() * 7);
            if (colorAnimal[num] == "Рыж") this.color = colorAnimal[num] + "ий";
            else this.color = colorAnimal[num] + "ый";
        }   // если самка, то вывод окончания "ая"
        else this.color = colorAnimal[(int)(Math.random() * 7)] + "ая";
        // установка клички для животного в соответствии с окрасом и одомашненностью
        if (this.pet == false) {    // для самок
            if (this.gender == true) {
                this.name = this.color + " (дикий)";
            } else {
                this.name = this.color + " (дикая)";
            }
        }
        // в заисимости от типа животного устанавливаем максимальную длину бега и плаванья
        // дикие животные будут бегать и плавать больше, чем домашние животные
        switch (typeAnimal) {
            case "cat": {
                this.maxDistanceRun = 300;    // альтернатива для кошек
                this.maxDistanceSwim = 1;     // плаванье ...
                break;
            }
            case "dog": {
                this.maxDistanceRun = 600;     // альтернатива для собак
                this.maxDistanceSwim = 10;     // плаванье ...
                break;
            }
        }
        // Определение атрибутов сытости животного и употребления еды:
        // Для диких животные аппетит будет больше
        int baseCurrentSatietyAnimal = 0; // переменная отвечающая за аппетит животного у собак тело больше, чем у кошек
        int baseMaxSatietyAnimal = 0;
        int increment = 0;
        // поэтому собакам нужно больше корма
        if (this.typeAnimal == "cat") { // для кошек
            baseCurrentSatietyAnimal = 3;
            baseMaxSatietyAnimal = 45;
            increment = 10;
        } else {    // для собак
            baseCurrentSatietyAnimal = 2;
            baseMaxSatietyAnimal = 65;
            increment = 8;
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
        this.bite = (int)(Math.random() * 4 + 2);   // количество еды потребляемой за один укус, прирощение сытости / убыль еды в тарелке
    }

    // Перегруженный метод для домашних животных
    public void swim(int distance) {
        super.swim(distance);
    }

    //Метод класса для получения информации о всех созданных объектах класса HomeAnimal
    protected final static int getCountWildAnimals() {
        System.out.println("Количество объектов в классе \"WildАnimal\": " + counterWildAnimals);
        return counterWildAnimals;
    }

    // Метод класса для получения данных из поля совмещённый с текстом
    // позволяет обратиться к методу c модификатором protected
    public static int getCountAnimals() {
        return getCountWildAnimals();  // функци возвращает количество живтных
    }

    // перегруженная функция deadAnimal() абстрактного класса Animal
    // если функция будет переопределена @Override и не будет содержать вызова
    // родительской функции то подсчёт количества животных в родительском классе
    // будет некорректный
    public void deadAnimal(){
        super.deadAnimal();     // вызов родительской функции
        counterWildAnimals--;   // декремент счётчика
    }

}
