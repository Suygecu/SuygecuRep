package mcmodding.pepsa.suygecu.handler.item;


public class Items2 {
    private String name;
    private static int weight;

    public Items2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public static int getWeight() {
        return weight;
    }

    public String getName() {

        return name;
    }




}
