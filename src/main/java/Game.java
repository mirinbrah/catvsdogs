import java.util.Scanner;

public class Game {
    private static final int CAT_START_X = 0;
    private static final int CAT_START_Y = 0;
    private static final int DOG_START_X = Field.SIZE - 1;
    private static final int DOG_START_Y = Field.SIZE - 1;
private static final int CHEST_VALUE=5;
    private final Scanner input = new Scanner(System.in);

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

        Dog sobaka = createDog(dogName, dogAge, dogCourage, dogFormidability);
        System.out.println("введите имя кота:");
        String catName=input.nextLine();//
        System.out.println("введите возраст кота:");
        int catAge = input.nextInt();//
        System.out.println("введите храбрость ");
        int catCourage = input.nextInt();//
        System.out.println("введите грозность кота");
        int catFormidability = input.nextInt();//
        Cat koshka = createCat(catName, catAge, catCourage, catFormidability);

        Chest chest=new Chest(Field.SIZE/2,Field.SIZE/2,CHEST_VALUE);

        System.out.println("\nУправляйте котом: W - вверх, A - влево, S - вниз, D - вправо.");
        Field.draw(chest, koshka, sobaka);

        while (true) {
            System.out.print("Ваш ход: ");
            String command = input.next().trim().toLowerCase();
            if (!moveCat(koshka, command)) {
                System.out.println("Нельзя так ходить. Используйте W, A, S или D.");
                continue;
            }
            chest.take(koshka);

            if (koshka.getX() == sobaka.getX() && koshka.getY() == sobaka.getY()) {
                fight(koshka, sobaka, chest);
                return;
            }

            sobaka.patrol();
            chest.take(sobaka);
            if (koshka.getX() == sobaka.getX() && koshka.getY() == sobaka.getY()) {
                fight(koshka, sobaka, chest);
                return;
            }

            Field.draw(chest, koshka, sobaka);
        }
    }

    private boolean moveCat(Cat cat, String command) {
        int newX = cat.getX();
        int newY = cat.getY();
        switch (command) {
            case "w" -> newX--;
            case "a" -> newY--;
            case "s" -> newX++;
            case "d" -> newY++;
            default -> { return false; }
        }
        if (newX < 0 || newX >= Field.SIZE || newY < 0 || newY >= Field.SIZE) {
            return false;
        }
        cat.setX(newX);
        cat.setY(newY);
        return true;
    }

    private void fight(Cat cat, Dog dog, Chest chest) {
        System.out.println("\nНачинается сражение " + cat.getName() + " с " + dog.getName() + "!");
        while (!cat.isFleeing() && !dog.isFleeing()) {
            dog.fight(cat);
            dog.show();
            if (!dog.isFleeing()) {
                cat.fight(dog);
                cat.show();
            }
        }
        if (dog.isFleeing()) {
            Field.draw(chest, cat);
            System.out.println("Кот победил. Игра пройдена!");
        } else {
            Field.draw(chest, dog);
            System.out.println("Собака победила. Игра проиграна!");
        }

    }

    public static Dog createDog(String name, int age, int courage, int formidability) {
        Dog sobaka = new Dog(name, age, courage, formidability, DOG_START_X, DOG_START_Y);
        System.out.println("создана собака со статами: "
                + sobaka.getName()
                + " " + sobaka.getAge()
                + " " + sobaka.getCourage()
                + " " + sobaka.getFormidability());
        return sobaka;
    }



    public static Cat createCat(String name, int age, int courage, int formidability) {
        Cat koshka = new Cat(name, age, courage, formidability, CAT_START_X, CAT_START_Y);
        System.out.println("создана кот со статами: "
                + koshka.getName()
                + " " + koshka.getAge()
                + " " + koshka.getCourage()
                + " " + koshka.getFormidability());
        return koshka;
    }

}
