//Дисциплина: Java.Уровень 1
//Домашнее задание №: 7 "Практика ООП и работа со строками"
//Студент: Алексей Пирогов
//Дата: 20.04.2021 19:10

package Things;

public class Plate {

    private int food;           // поле внутри класса отражающее количество еды
    private String typeFood;    // специальный корм
    private int maxCountFood;   // максимальное количество еды в тарелке

    // Непараметризироанный конструктор класса Plate
    public Plate() {    // конструктор класса для создания пустых тарелок
        this.food = (int)(Math.random() * 490 + 10);  // количество еды от 10 до 500
        typeFood = "Корм для животных"; // тип еды
        maxCountFood = 500; // в тарелку помещается максимально 500 едииц еды
    }

    // Параметризированный конструктор класса Plate
    public Plate(int countFood, String typeFood) {     // конструктор класса
        this.food = countFood;          // количество еды
        this.typeFood = typeFood;       // вид еды
        this.maxCountFood = 500;        // максимальное количество еды в тарелке
    }

    // Метод для добавления еды в тарелку
    public final int addEatInPlate(int countFood, String typeFood) {     //добавление количества еды
        System.out.println("\nРабота метода addEatInPlate:");
        System.out.println("Сделана попытка добавить в тарелку " + countFood + " еды.");
        if ((this.food + countFood) <= this.maxCountFood) {
            if (this.food == this.maxCountFood) {
                System.out.print("Достигнуто максимальное количество еды в тарелке! Невозможно добавить еду.\n");
            } else {
                System.out.print("В тарелку добавлено " + countFood + " еды.");
                this.food += countFood;   // добавление еды в тарелку
            }
        } else {
            System.out.print("В тарелку добавлено " + (this.maxCountFood - this.food) + " еды. Достигнуто максимальное количество еды в тарелке!\n");
            this.food += this.maxCountFood - this.food;
        }
        return this.food;       // метод возвращает обновлённое количество еды в тарелке
    }

    // Метод для уменьшения количества еды в тарелке
    public final int subEatInPlate(int subBite){
        if (this.food != 0) //{
            this.food -= subBite;
//        } else {
//            // System.out.print("В тарелке нет еды! (нужно добавить еду)\n");
//        }
        return this.food;
    }

    // Методы для проверки количества еды в тарелке
    public final int countFood() {    // количество еды в тарелке
        System.out.print("Количестово еды в тарелке: " + this.food + " / " + this.maxCountFood + " ");
        if (this.food == 0) {
            System.out.print("\t... пустая тарелка ... \n");
        } else {
            System.out.println("\nТип еды: " + this.typeFood);
        }
        System.out.println();
        return this.food;
    }
}
