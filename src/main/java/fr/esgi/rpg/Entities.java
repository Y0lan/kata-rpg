package fr.esgi.rpg;

public class Entities {

    private int health;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Entities(String name, int health) {
        this.name = "entity_"+name;
        this.health = health;
        System.out.println("\nEntities " + getName() + " have been created with " + getHealth() + " point of health.");
    }
}
