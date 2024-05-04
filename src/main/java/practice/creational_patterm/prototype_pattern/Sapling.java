package practice.creational_patterm.prototype_pattern;


public class Sapling implements PubgTree{

    private int height;
    private int width;
    private String colour;

    private int x;
    private int y;

    public Sapling(int height, int width, String colour) {
        this.height = height;
        this.width = width;
        this.colour = colour;
    }


    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public PubgTree clone() {
        return new Sapling(this.height,this.width,this.colour);
    }
}
