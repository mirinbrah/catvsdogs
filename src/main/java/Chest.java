import java.util.concurrent.ThreadLocalRandom;

public class Chest {
    private final int x;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    protected String symbol;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    private final int y;
    private final int value;
    private boolean taken;
    public Chest(int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value=value;
        this.symbol="\uD83C\uDF81";
    }
    public boolean isTaken(){
        return taken;
    }
    public void take(Animal animal){
        if (!isTaken() && animal.getX()==this.getX() && animal.getY()==this.getY()){
            taken=true;
            if (ThreadLocalRandom.current().nextBoolean()){
                animal.setFormidability(animal.getFormidability()+this.getValue());
                System.out.println(animal.getName()+" открыл сундук и получил "+this.getValue()+" грозности");
            }
            else {
                animal.setCourage(animal.getCourage()+this.getValue());
                System.out.println(animal.getName()+" открыл сундук и получил "+this.getValue()+" смелости");
            }
        }
    }
}
