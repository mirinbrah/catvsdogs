public class Field {
    public static final int SIZE = 5;
    public static final String[][] grid = new String[SIZE][SIZE];

    private static final String EMPTY = ".";

    public static void form() {
        for (int i = 0; i < SIZE; i++) {
            for (int g = 0; g < SIZE; g++) {
                grid[i][g] = EMPTY;
            }
        }
    }

    private static void place(Animal animal) {
        grid[animal.getX()][animal.getY()] = animal.getSymbol();
    }
private static void placeChest(Chest chest){
        grid[chest.getX()][chest.getY()]= chest.getSymbol();
}

    public static void line() {
        for (int k = 0; k < SIZE; k++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
public static void draw(Animal... animals){
        draw(null,animals);
}

    public static void draw(Chest сhest, Animal... animals) {
        for (Animal animal : animals) {
            place(animal);
        }
        line();
        for (int i = 0; i < SIZE; i++) {
            for (int g = 0; g < SIZE; g++) {
                if (grid[i][g].equals(EMPTY)) {
                    System.out.print("| . ");
                } else {
                    System.out.print("| " + grid[i][g]);
                }
            }
            System.out.println("|");
            line();
        }
        System.out.println();
    }
}