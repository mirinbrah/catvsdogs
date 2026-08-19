import java.util.concurrent.ThreadLocalRandom;

public class Dog extends Animal{
    private static final int PATROL_RADIUS=3;
    private int patrolX;
    private int patrolY;
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
        this.patrolX=x;
        this.patrolY=y;
    }

    public void patrol(){
        while (true){
            int newX=getX();
            int newY=getY();
            switch (ThreadLocalRandom.current().nextInt(5)){
                case 0->newX++;
                case 1->newX--;
                case 2->newY++;
                case 3->newY--;
                case 4->{ }
            }
            int  distanceFromCenter = Math.abs(newX - patrolX)
                    + Math.abs(newY - patrolY);
            if (newX>=0 && newX<Field.SIZE &&
                newY>=0 && newY<Field.SIZE &&
                distanceFromCenter<=PATROL_RADIUS){
                setX(newX);
                setY(newY);
                return;
            }
        }
    }
}
