package practice.creational_patterm.prototype_pattern;

public class Tree implements PubgTree{

    private int height;
    private int width;
    private String colour;
    private String treeType;

    private int x;
    private int y;

    public Tree(int height, int width, String colour, String treeType) {
        this.height = height;
        this.width = width;
        this.colour = colour;
        this.treeType = treeType;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public PubgTree clone() {
        return new Tree(this.height,this.width,this.colour,this.treeType);
    }


}
