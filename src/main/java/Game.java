import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);

    public void run(){
        gameStart();
    }

    public void gameStart(){
        System.out.println("Начало игры, сейчас вы создадите кошку и собаку");
        System.out.println("введите имя собаки");
        String dogName = input.nextLine();
        System.out.println("введите возраст собаки");
        int dogAge = input.nextInt();
        System.out.println("введите храбрость собаки");
        int dogCourage = input.nextInt();
        System.out.println("введите грозность собаки");
        int dogFormidability = input.nextInt();
        CreateDog(dogName,dogAge,dogCourage,dogFormidability);
    }
    public static Dog CreateDog(String name, int age, int courage, int formidability){
        Dog sobaka = new Dog(name,age,courage,formidability);
        System.out.println("создана собака со статами: "
                + sobaka.getName()
                + " " + sobaka.getAge()
                + " " + sobaka.getCourage()
                + " " + sobaka.getFormidability());
        return sobaka;
    }
    public static Cat CreateCat(String name, int age, int courage, int formidability){
        Cat koshka = new Cat(name,age,courage,formidability);
        return koshka;
    }
}
