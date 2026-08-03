public class Field {
    public static final int SIZE=5;
    public static final char[][] grid=new char[SIZE][SIZE];

    public static void form(){
        for (int i=0;i<SIZE;i++){
            for (int g=0;g<SIZE;g++){
                grid[i][g]='.' ;
            }
        }
    }
    public static void line(){
        for (int k=0;k<SIZE;k++){
            System.out.print("+---");
        }
        System.out.println("+");
    }
    public static void draw(){
        form();
        line();
        for (int i=0;i<SIZE;i++) {
            System.out.print("| ");

            for (int g = 0; g < SIZE; g++) {
                System.out.print(grid[i][g]+" | ");
            }
            System.out.println();
            line();
        }
        System.out.println();
    }
}