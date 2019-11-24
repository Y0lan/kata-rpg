package fr.esgi.rpg;

import fr.esgi.rpg.exceptions.CharacterDeadException;
import fr.esgi.rpg.exceptions.CharacterSameException;
import fr.esgi.rpg.exceptions.FactionException;

import java.util.ArrayList;
import java.util.List;

enum Status { DEAD(false), ALIVE(true); Status(boolean state) { this.state=state; } boolean state; }


public abstract class Character {
    private int health;
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
        System.out.println("\n" + this.name + " have " + this.health + " health now.");
    }


    private Status status;
    public Status getStatus() {
        return status;
    }


    private String name;
    private String type;
    private long attack;
    private long healing;
    private List<Faction> Factions = new ArrayList<Faction>();

    public List<Faction> getFactions() {
        return Factions;
    }

    public void join(Faction faction) throws FactionException {
        if(!this.Factions.contains(faction)){
            System.out.println(this.name + " joined " + faction.getName());
            Factions.add(faction);
            faction.addMember(this);
        }
    }

    public void leave(Faction faction) throws FactionException {
        if(this.Factions.contains(faction)){
            System.out.println(this.name + " left " + faction.getName());
            Factions.remove(faction);
            faction.removeFromFaction(this);
        }
    }

    public boolean sameFaction(Character character){
        for(Faction hisFaction:character.Factions) if(this.Factions.contains(hisFaction)) return true;
        return false;
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

    public boolean factionAreFriends(Character character){
        for(Faction factionCharacter:character.getFactions()){
            for(Faction factionOrigin:this.getFactions()){
                if(factionOrigin.isFriend(factionCharacter)) return true;
            }
        }
        return false;
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

    public void showFactions(){
        System.out.println("FACTION " + this.name + " IS MEMBER OF");
        System.out.println("-----------");
        for(Faction faction:getFactions()){
            System.out.println(faction.getName());
        }
    }
}
