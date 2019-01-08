public class SniperTower extends Tower {

    public SniperTower(double x, double y) {
        super(x, y);
        this.groundTargeting = true;
        this.airTargeting = true;
        this.dmg = 5;
        this.rate = 5;
        this.range = new Circle(x, y, 5);
    }

    public void attack(){

    }
}