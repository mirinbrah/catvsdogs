import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);

    public void run() {
        gameStart();
    }

    public void gameStart() {
        System.out.println("Начало игры, сейчас вы создадите кошку и собаку");
        System.out.println("введите имя собаки");
        String dogName = input.nextLine();
        System.out.println("введите возраст собаки");
        int dogAge = input.nextInt();//
        System.out.println("введите храбрость собаки");
        int dogCourage = input.nextInt();//
        System.out.println("введите грозность собаки");
        int dogFormidability = input.nextInt();//
        input.nextLine();
        Dog sobaka=CreateDog( dogName, dogAge, dogCourage, dogFormidability);
        System.out.println("введите имя кота:");
        String catName=input.nextLine();//
        System.out.println("введите возраст кота:");
        int catAge = input.nextInt();//
        System.out.println("введите храбрость ");
        int catCourage = input.nextInt();//
        System.out.println("введите грозность кота");
        int catFormidability = input.nextInt();//
        Cat koshka=CreateCat(catName, catAge, catCourage, catFormidability);

        System.out.println("начинается сражение "+sobaka.getName() +" с " + koshka.getName());
        while (!koshka.isFleeing() && !sobaka.isFleeing()){
            koshka.fight(sobaka);
            sobaka.show();
            sobaka.fight(koshka);
            koshka.show();
        }
        if(koshka.isFleeing()){
            System.out.println("собака победила");
        } else {
            System.out.println("кошка победила");
        }
    }

    public static Dog CreateDog(String name, int age, int courage, int formidability) {
        Dog sobaka = new Dog(name, age, courage, formidability);
        System.out.println("создана собака со статами: "
                + sobaka.getName()
                + " " + sobaka.getAge()
                + " " + sobaka.getCourage()
                + " " + sobaka.getFormidability());
        return sobaka;
    }



    public static Cat CreateCat(String name, int age, int courage, int formidability) {
        Cat koshka = new Cat(name, age, courage, formidability);
        System.out.println("создана кот со статами: "
                + koshka.getName()
                + " " + koshka.getAge()
                + " " + koshka.getCourage()
                + " " + koshka.getFormidability());
        return koshka;
    }

}

