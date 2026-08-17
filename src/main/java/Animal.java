public class Animal {
    protected String name;
    protected int age;
    protected int courage;
    protected int formidability;
    protected String type;
    protected int x;
    protected int y;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFormidability(int formidability) {
        this.formidability = formidability;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    protected String symbol;

    public Animal(String name,
                  int age,
                  int courage,
                  int formidability,
                  int x,
                  int y
                  ){
        this.name = name;
        this.age = age;
        this.courage = courage;
        this.formidability = formidability;
        this.x=x;
        this.y=y;
        this.symbol=symbol;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCourage() {
        return courage;
    }

    public int getFormidability() {
        return formidability;
    }

    public String getType() {
        return type;
    }

    public void setCourage(int courage){
            this.courage=courage;

    }

    public void fight(Animal enemy){
        int newCourage=getCourage()-enemy.getFormidability();
        if (newCourage<0){
            newCourage=0;
        }
        setCourage(newCourage);
    }
    public boolean isFleeing(){
        return getCourage()<=0;
    }
    public void show(){
        System.out.println(getName()+" состояние: "
        +getCourage());
    }
}
