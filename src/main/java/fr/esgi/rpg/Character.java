package fr.esgi.rpg;

import fr.esgi.rpg.exceptions.CharacterDeadException;
import fr.esgi.rpg.exceptions.CharacterSameException;
import fr.esgi.rpg.Faction;
import fr.esgi.rpg.exceptions.FactionException;

import java.util.ArrayList;
import java.util.List;

enum Status { DEAD(false), ALIVE(true); Status(boolean state) { this.state=state; } boolean state; }


public abstract class Character {
    /* ATTRIBUTE */
    private int health;
    private Status status;
    private String name;
    private String type;
    private long attack;
    private long healing;
    private List<Faction> Factions = new ArrayList<>();

    /* CONSTRUCTOR */
    public Character(String name) {
        this.name = name;
        this.health = 100;
        status = Status.ALIVE;
        System.out.println("------------------------------");
        System.out.println("A new character " + name + " have been created.");
    }

    /* SETTER */
    protected void setType(String type) {
        this.type = type;
    }


    protected void setAttack(long attack) {
        this.attack = attack;
    }

    protected void setHealing(int healing) {
        this.healing = healing;
    }

    public void setDead() {
        System.out.println("\n" + this.name + " is now dead. RIP.");
        this.status = Status.DEAD;
    }

    public void setAlive() {
        System.out.println("\n" + this.name + " is now alive. \\o/");
        this.status = Status.ALIVE;
    }

    public void setHealth(int health) {
        if (health < 0) this.health = 0;
        else this.health = Math.min(health, 100);
        if(this.health == 0) this.status = Status.DEAD;
    }

    /* GETTER */

    public int getHealth() {
        return health;
    }

    public Status getStatus() {
        return status;
    }

    public List<Faction> getFactions() {
        return Factions;
    }


    String getType() {
        return this.type;
    }

    protected long getAttack() {
        return attack;
    }

    protected long getHealing() {
        return healing;
    }

    protected void getInformation() {
        System.out.println("Name : " + this.getName());
        System.out.println("Health : " + this.getHealth());
        System.out.println("Status: " + this.getStatus());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Healing: " + this.getHealing());
    }

    public String getName() {
        return name;
    }

    /* VERIFICATION */

    protected boolean sameFaction(Character character) {
        for (Faction hisFaction : character.Factions) if (this.Factions.contains(hisFaction)) return true;
        return false;
    }

    protected boolean noFaction() {
        return countFactions() == 0;
    }

    protected boolean factionAreFriends(Character character) {
        for (Faction factionCharacter : character.getFactions()) {
            for (Faction factionOrigin : this.getFactions()) {
                if (factionOrigin.isFriend(factionCharacter)) return true;
            }
        }
        return false;
    }

    public boolean isAlive() {
        return this.status == Status.ALIVE;
    }

    public boolean isDead() {
        return this.status == Status.DEAD;
    }

    /* ACTIONS */
    void join(Faction faction) throws FactionException {
        if (!this.Factions.contains(faction)) {
            System.out.println(this.name + " joined " + faction.getName());
            Factions.add(faction);
            faction.addMember(this);
        }
    }

    void leave(Faction faction) throws FactionException {
        if (this.Factions.contains(faction)) {
            System.out.println(this.name + " left " + faction.getName());
            Factions.remove(faction);
            faction.removeFromFaction(this);
        }
    }
    public void showFactions(){
        System.out.println("FACTION " + this.name + " IS MEMBER OF");
        System.out.println("-----------");
        for(Faction faction:getFactions()){
            System.out.println(faction.getName());
        }
    }

    private int countFactions(){
        int c = 0;
        for(Faction faction:Factions){
            c++;
        }
        return c;
    }

}
