package fr.esgi.rpg;

import fr.esgi.rpg.exceptions.CharacterDeadException;
import fr.esgi.rpg.exceptions.CharacterSameException;

import java.util.ArrayList;
import java.util.List;

enum Status { DEAD(false), ALIVE(true); Status(boolean state) { this.state=state; } boolean state; }


public abstract class Character {
    private int health;


    private Status status;
    private String name;
    private String type;
    private long attack;
    private long healing;
    private List<Faction> Factions = new ArrayList<Faction>();

    public List<Faction> getFactions() {
        return Factions;
    }

    public void addFaction(Faction faction) {
        if(!this.Factions.contains(faction)) Factions.add(faction);
    }

    public void removeFaction(Faction faction){
        if(this.Factions.contains(faction)) Factions.remove(faction);
    }

    public boolean sameFaction(Character character){
        for(Faction hisFaction:character.Factions) if(this.Factions.contains(hisFaction)) return true;
        return false;
    }

    public Status getStatus() {
        return status;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public long getAttack() {
        return attack;
    }

    public long getHealing() {
        return healing;
    }


    public void setAttack(long attack) {
        this.attack = attack;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }


    public String getName() {
        return name;
    }

    public Character(String name) {
        this.name = name;
        this.health = 100;
        status = Status.ALIVE;
        System.out.println("------------------------------");
        System.out.println("A new character " + name + " have been created.");
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        System.out.println("\n" + this.name + " have " + this.health + " health now.");
    }

    public boolean isAlive() {
        return this.status == Status.ALIVE;
    }

    public boolean isDead(){
        return this.status == Status.DEAD;
    }

    public void setDead() {
        System.out.println("\n" + this.name + " is now dead. RIP.");
        this.status = Status.DEAD;
    }

    public void setAlive() {
        System.out.println("\n" + this.name + " is now alive. \\o/");
        this.status = Status.ALIVE;
    }

    public void SetHealth(int health) {
        if(health < 0) this.health = 0;
        if(health > 100) this.health = 100;
        else this.health = health;
    }
}
