public class Cat extends Animal{
    public Cat(String name,
               int age,
               int courage,
               int formidability,
               int x,
               int y
               ){
        super(name,age,courage,formidability, x, y );
        this.symbol="\uD83D\uDC08";
        this.type = "Cat";
    }
}
