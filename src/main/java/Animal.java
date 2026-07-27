public class Animal {
    protected String name;
    protected int age;
    protected int courage;
    protected int formidability;
    protected String type;

    public Animal(String name,
                  int age,
                  int courage,
                  int formidability){
        this.name = name;
        this.age = age;
        this.courage = courage;
        this.formidability = formidability;
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
