public class Dog extends Animal{
    public Dog(String name,
               int age,
               int courage,
               int formidability,
                int x,
                int y
                ){
        super(name,age,courage,formidability, x, y);
        this.symbol="\uD83D\uDC36";
        this.type = "Dog";
    }
}
