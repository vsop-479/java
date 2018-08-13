package algorithm.catSort.model;

public class Cat {
    private Color color;
    private String name;

    public Cat (Color color, String name){
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                color + name +
                '}';
    }
}
