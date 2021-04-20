//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021 19:10

package MainClass;      // принадлежность к пакету MainClass
import Things.Plate;    // подключение пакета Things для работы метода eat()

// Супер класс Animal является абстрактным классом и определяет общие черты для дочерних классов.
// Данный класс хранит в себе информацию о атрибутах животных, а также ряде методов отражающих поведение животных.
// Объекты абстрактного класса Animal нельзя создавать

public abstract class Animal {

    protected static int counterAnimals;  //количество объектов класса Animal

    // ------------------ Атрибуты сущности животное -----------------------
    // описание атрибутов сущности задаётся в дочерникх классах
    public boolean live;                  // живой/мертвый, задаётся в дочерних классах
    public boolean pet;                   // статус одомашненности
    public String typeAnimal;             // вид животного не используется в конструкторе Animal
    public boolean leader;                // животное лидер в стае, если речь идёт о стае диких животных
    public int numSwarm;                  // номер стаи для адресации и нициализации элемента в множестве стай
    public String name;                   // кличка
    public String color;                  // цвет животного
    public int ageMonths;                 // возраст в месяцах
    public boolean gender;                // пол животного
    public int maxDistanceRun;            // максимальная дистанция для бега
    public int maxDistanceSwim;           // максимальная дистанция для плаванья
    public int satietyCount;              // сытость в количественном выражении
    public int satietyMaxCount;           // максимальная сытость для животного
    public int bite;                      // количество еды поглощаемое животным за один укус
    public boolean satiety;               // статус сытости

    static {    // инициализация счётчика с количеством животных
        counterAnimals = 0;
    }

    {   // инкремент количества животных
        counterAnimals++;
    }

    // абстрактный класс не может содержать в себе конструкторов, но може содержать инициализаторы
    // конструктор Animal() - запрещён!!!

    // ------------------ Методы сущности животное -----------------------

    // Метод для выода информации о животном с учётом рода
    // Особенность: носит вспомогательных характер
    public final String correctPrint() {
        if(this.gender == true) return "";  // для окончание слов при выводе информации о самоцах
        else return "a";                    // для окончание слов при выводе информации о самках
    }

    // Метод для вывода информации о экземпляре класса
    public final void show() {
        if (name == null) System.out.println("Цвет: " + color + "\nВозраст: " + ageMonths + " мес. (полных лет: " + ageMonths/12 + ")");
        else System.out.println("Кличка питомца: " + name + "\nЦвет: " + color + "\nВозраст: " + ageMonths + " мес. (полных лет: " + ageMonths / 12 + ")");
        if (live == true) {
            System.out.print("Вид животного: ");
            switch (typeAnimal) {
                case "cat": System.out.print("кошки\n"); break;
                case "dog": System.out.print("собаки\n"); break;
            }
            System.out.print("Сытость животного: " + this.satietyCount + "/" + this.satietyMaxCount + ".");
            System.out.print(" Иллюстрация сытости: 0 [");
            for (int i = 0; i < satietyMaxCount; i++){
                if (i < this.satietyCount)
                    System.out.print("#");
                else
                    System.out.print(".");
                if (i == satietyMaxCount - 1)
                    System.out.print("] " + this.satietyMaxCount + ", ед.");
            }
            System.out.print("\nСытость животного: ~ " + (int)((double)(this.satietyCount) / (double)(this.satietyMaxCount) * 100) + "%.");
            System.out.print(" Иллюстрация сытости: 0 [");
            int maxRepeat = (int)((double)(this.satietyCount) / (double)(this.satietyMaxCount) * 100);
            for (int i = 0; i < 100; i++) {
                if (i <= maxRepeat)
                    if (this.satietyCount == 0) System.out.print(".");
                    else System.out.print("#");
                else
                    System.out.print(".");
                if (i == 99)
                    System.out.print("] 100, %");
            }
            System.out.println("\nАппетит: " + this.bite);
            if (this.satiety == true) System.out.print("Животное сыто!");
        } else {
            System.out.print("Вид животного: ");
            switch (typeAnimal) {
                case "cat": System.out.print("кошачьи\n"); break;
                case "dog": System.out.print("собачьи\n"); break;
            }
            System.out.println("К сожалению, животное уже умерло...\n");
        }
    }

    // метод для извлечения звуков передаваемых в качестве параметра
    public void voice(String animalVoice){
        System.out.println(this.name + ":" + animalVoice);
        if(live == false) System.out.println("К сожалению, животное уже умерло...");
    }

    // метод для бега животного
    public final void run(int distance) {
        String gen = correctPrint();
        System.out.print(this.name);
        // исключение деления на ноль
        if (this.maxDistanceSwim == 0) {
            System.out.println(" животное не умеет бегать... ");
            return; // функция ничего не возвращает
        }
        if(distance < 0) {    //если в функцию передано отрицательное направление движения
            distance = Math.abs(distance);
            System.out.print(" ... подскочил" + gen +" на месте для переориентации в пространстве и времени ... (хочет бежать в обратном направлении)\n" + this.name);
        }
        //Печать перебежек животного на заданную дистанцию:
        int count = (int)(distance / this.maxDistanceRun); // получения числа итераций для цикла с перебежками
        for (int i = 0; i <= count; i++) {  // цикл отражающий перебежки животного
            if(i != 0) System.out.print(this.name);
            //Вывод инфомации если distance == maxDistanceRun, а также если distance == 0
            if ((distance <= this.maxDistanceRun) && (distance > 0)) {
                System.out.print(" побежал" + gen + " " + distance +" метров ... Пробежал" + gen + " " + distance + " метров, устал" + gen + " и захотел" + gen + " на ручки...\n");
                break;
            }
            if (distance == 0) {
                System.out.print(" хотел" + gen +" бежать ..., да не побежал" + gen + " ... (0 метров)\n");
                break;
            }
            if (distance > this.maxDistanceRun) {
                System.out.print(" Побежал" + gen + " " + distance + " метров ... Пробежал" + gen + " " + this.maxDistanceRun + " метров и готовится для следующего рывка...\n");
                distance -= this.maxDistanceRun;
            } else {
                System.out.print(" Побежал" + gen + " " + distance + " метров ... Пробежал" + gen + " " + distance + " метров и пропал" + gen + " где-то там...\n");
            }
        }
    }

    //метод для плавания животного, модификатор final нельзя использовать, т.к. будет переопределён для класса Cat
    public void swim(int distance) {
        String gen = correctPrint();
        System.out.print(this.name);
        // исключение деления на ноль
        if (this.maxDistanceSwim == 0) {
            System.out.println(" не умеет плавать, все мокрое выскочило из воды... ");
            return; // функция ничего не возвращает
        }
        if(distance < 0) {    //если в функцию передано отрицательное направление движения
            distance = Math.abs(distance);
            System.out.print(" ... сменил" + gen +" курс на месте для переориентации в пространстве и времени ... (хочет пыть в обратном направлении)\n" + this.name);
        }
        //Печать перебежек животного на заданную дистанцию:
        int count = (int)(distance / this.maxDistanceSwim); // получения числа итераций для цикла с перебежками
        for (int i = 0; i <= count; i++) { // цикл отражающий перебежки животного
            if(i != 0) System.out.print(this.name);
            //Вывод инфомации если distance == maxDistanceRun, а также если distance == 0
            if ((distance <= this.maxDistanceSwim) && (distance > 0)) {
                System.out.print(" Поплыл" + gen + "... Проплыл" + gen + " " + distance + " метров.\n");
                break;
            }
            if (distance == 0) {
                System.out.print(" хотел" + gen +" плыть ..., да не поплыл" + gen + " ... (0 метров)\n");
                break;
            }
            if (distance > this.maxDistanceSwim) {
                System.out.print(" поплыл" + gen + " " + distance + " метров ... Поплыл" + gen + " " + this.maxDistanceSwim + " метров и остановил" + gen + "ся для следующего рывка...\n");
                distance -= this.maxDistanceSwim;
            } else {
                System.out.print(" поплыл" + gen + " " + distance + " метров ... Поплыл" + gen + " " + distance + " метров и остановил" + gen + "ся уже где-то там...\n");
            }
        }
    }

    // Метод для вывода характерного звука того или иного животного
    public String typeAnimalForVoice(){
        String result;
        if (this.typeAnimal == "cat")
            result = "мур-мур-мур";
        else
            result = "ав-ав-ав";
        return result;
    }

    // Метод позволяет животному поесть из тарелки
    public final void eat(Plate plate){
        // Вывод информации об исходном состоянии системы животное-тарелка
        System.out.println("Исходное состояние: сытость животного: " + this.satietyCount + "/" + this.satietyMaxCount + ", количество корма в тарелке: " + plate.subEatInPlate(0) + " ед.еды.\n----------------");
        // Вывод информации о необходимости добавить еды, если тарелка пустая или в ней мнимое количество еды (используется как защита)
        if(this.satiety == true) {
            this.voice(" Человек " + this.typeAnimalForVoice() + "! А я сыт уже, давай бери меня на ручки!");
        }
        else
        {
            if ((plate.subEatInPlate(0) <= 0) && (this.satiety != true)) {
                this.voice(" Человек, со всей ответственностью заявляю, что в тарелке пусто! Дай еды, а я тебя любить условной любовью буду после!!!");
            } else {
                // Проверка разности this.satietyMaxCount и this.satietyCount, если меньше или равна одному укусу, то ...
                if ((this.satietyMaxCount - this.satietyCount) <= this.bite) {
                    // проверка количества корма в тарелке 0 или меньше минимального приёма пищи
                    if ((plate.subEatInPlate(0) == 0) || (plate.subEatInPlate(0) <= this.bite)) {
                        // экземпляр класса доедает, что есть в тарелке и сигнализирует, что хочет ещё еды (!)
                        this.satietyCount += plate.subEatInPlate(0);
                        System.out.println(this.name + ": делает кусь на " + plate.subEatInPlate(0) + " ед. еды, состояние сытости: " + this.satietyCount + "; корма в тарелке осталось: " + plate.subEatInPlate(plate.subEatInPlate(0)) + " единиц. \t (кусь, чтобы доесть всё, что есть в тарелке)");
                        plate.subEatInPlate(plate.subEatInPlate(0));
                        System.out.print("----------------\n");
                        if (this.satietyMaxCount == this.satietyCount) {
                            this.satiety = false;
                        }
                        this.voice(" Человек, а в тарелке пусто! На заверином языке: \"Дай-дай-дай ещё еды!\"");
                    } else {
                        plate.subEatInPlate(this.satietyMaxCount - this.satietyCount); //  ... уменьшение количества корма в тарелке ...
                        this.satietyCount += this.satietyMaxCount - this.satietyCount;  // ... прирощение сытости
                        System.out.println(this.name + ": " + 1 + "-ин" + " кусь, состояние сытости: " + this.satietyCount + "; корма в тарелке осталось: " + plate.subEatInPlate(0) + " ед.еды. \t (насыщение до максимума с первого кусь)");
                        System.out.println("----------------");
                        // проверка условия this.satietyMaxCount == this.satietyCount
                        if (this.satietyMaxCount == this.satietyCount) {
                            this.satiety = true;
                        }   // переход в конец метода, т.к. животное сытое
                    }
                }
                // если условие this.satietyMaxCount  и this.satietyCount не равны друг другу, а также
                // сытость не равна единице, то инициация цикла поедания еды из тарелки
                int i = 1;  // счётчик количества укусов корма
                // проверка условия сытости животного, если условие не выполняется, то выход
                while ((this.satietyCount != this.satietyMaxCount) && (this.satiety != true)) {
                    // набор условий для выхода:
                    // если в тарелке пусто, экземпляр класса в методе eat выводит информацию, что в тарелке пусто
                    if ((plate.subEatInPlate(0) == 0) || (plate.subEatInPlate(0) <= this.bite)) {
                        // экземпляр доедает, что есть в тарелке
                        this.satietyCount += plate.subEatInPlate(0);
                        System.out.println(this.name + ": " + i + "-й" + " кусь на " + plate.subEatInPlate(0) + " ед. еды, состояние сытости: " + this.satietyCount + "; корм в тарелке: " + plate.subEatInPlate(plate.subEatInPlate(0)) + " ед.еды. \t (кусь, чтобы доесть всё, что есть в тарелке)");
                        plate.subEatInPlate(plate.subEatInPlate(0));
                        System.out.print("----------------\n");
                        if (this.satietyMaxCount != this.satietyCount) {
                            this.voice(" Человек, в тарелке пусто! Я съел те жалкие крохи, что были мне даны! Ещё! Мне до полной сытости не хватает: " + (this.satietyMaxCount - this.satietyCount) + ".");
                        }
                        break;
                    } else {   // если в тарелке есть корм, то экземпляр класса кушает
                        // если уровень голода больше, чем можно скушать за раз, то кушает до полного насыщения
                        if ((this.satietyMaxCount - this.satietyCount) >= this.bite) {
                            plate.subEatInPlate(this.bite);  // декремент количества еды в тарелке
                            this.satietyCount += this.bite;  // инкремент сытости
                            System.out.println(this.name + ": " + i + "-й" + " кусь, состояние сытости: " + this.satietyCount + "; корм в тарелке: " + plate.subEatInPlate(0) + " ед. еды. \t (обычный кусь)");
                            i++;    // инкремент количества обращений к тарелке (кусь)
                        }
                        // если уровень голода меньше, чем можно скушать за раз, то ест до насышения разницу между
                        if (((this.satietyMaxCount - this.satietyCount) < this.bite) && ((this.satietyMaxCount - this.satietyCount) != 0)) {
                            plate.subEatInPlate(this.satietyMaxCount - this.satietyCount);
                            this.satietyCount += this.satietyMaxCount - this.satietyCount;
                            System.out.println(this.name + ": " + i + "-й" + " кусь, состояние сытости: " + this.satietyCount + "; корм в тарелке: " + plate.subEatInPlate(0) + " ед. еды. \t (необычный кусь, доедание до максимума)");
                            System.out.print("----------------\n");
                        }
                        // проверка условия this.satietyMaxCount == this.satietyCount
                        if (this.satietyMaxCount == this.satietyCount) {
                            this.satiety = true;
                            break;  // выход из цикла, если экземпляр класса насытился
                        }
                    }
                }
                // вывод информации о сытости животного
                if (this.satiety == true) {
                    this.voice(" " + this.typeAnimalForVoice() + "...  (сытый и явно под эндорфином и дофамином после поедания корма)");
                }
                // если сытость не наступала, то вывод информации о необходимости положить ёщё корма
                if ((this.satiety != true) && (this.satietyMaxCount != this.satietyCount)) {
                    this.voice(" " + this.typeAnimalForVoice() + "... а дай ещё еды, человек?!");
                }
                System.out.println("Вывод итогового состояния: cытость животного: " + this.satietyCount + "/" + this.satietyMaxCount + ", количество корма в тарелке: " + plate.subEatInPlate(0) + " ед.еды.");
                return;
            }
        }
        return;
    }

    // Метод абстрактного класса Animal для отражения смерти животного
    public void deadAnimal(){
        this.live = false;  // установка атрибута в false - нет жизни
        counterAnimals--;   // декремент количества животных
        if(this.gender == true) // вывод сообжения в зависимости от пола животного
            System.out.print(this.name + " умер...");
        else
            System.out.print(this.name + " умерла...");
    }

    // Метод абстрактного класса Animal для получения информации о всех созданных объектах класса Animal
    // Особенность: метод выводит информацию в консоль о количестве с текстовым пояснением
    protected final static int getCountAnimalsProtected() {
        System.out.println("Количество объектов в классе \"Аnimal\": " + counterAnimals);
        return counterAnimals;  // функци возвращает количество живтных
    }

    // Метод абстрактного класса для получения данных из поля совмещённый с текстом
    // позволяет обратиться к методу c модификатором protected
    public static int getCountAnimals() {
        return getCountAnimalsProtected();  // функци возвращает количество живтных
    }

    // Альтернативный метод для получения данных по количеству животных
    // обращается непосредственно к счётчику counterAnimals
    // public static int getCounterAnimalsAlt() {
    //    return counterAnimals;  // функци возвращает количество животных
    // }
}
