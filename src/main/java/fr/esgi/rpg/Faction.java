package fr.esgi.rpg;

import fr.esgi.rpg.exceptions.FactionException;

import java.util.*;

public class Faction {
    private List<Character> Characters = new ArrayList<Character>();
    private List<Faction> Allies = new ArrayList<Faction>();
    private String name;

    public Faction(String name) {
        this.setName(name);
        System.out.println("\nNew faction " + this.name + " have just been created.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Faction(String name){
        this.setName(name);
    }


    void addToFaction(Character character) throws FactionException {
        if(this.Characters.contains(character)) throw new FactionException(character.getName() + " already is part of the faction " + this.name);
        else {
            this.Characters.add(character);
        }
    }

    public void addMember(Character character) throws FactionException {
        if(this.Characters.contains(character)) throw new FactionException(character.getName() + " already is part of the faction " + this.name);
        else{
            this.addToFaction(character);
            character.join(this);
            System.out.println("New member " + character.getName() + " joined " + this.name + "! Welcome!");
        }
    }
    void removeFromFaction(Character character) throws FactionException {
        if(this.Characters.contains(character)) {
            this.Characters.remove(character);
        }
        else throw new FactionException(character.getName() + " is not a member of the faction " + this.name);
    }

    void removeMember(Character character) throws FactionException {
        if(this.Characters.contains(character)) {
            removeFromFaction(character);
            character.leave(this);
            System.out.println(character.getName() + " left faction " + this.name + "... Bye!");
        }
        else throw new FactionException(character.getName() + " is not a member of the faction " + this.name);
    }

    void addAlly(Faction faction) throws FactionException {
        if(this.Allies.contains(faction)) throw new FactionException("Can not add " + faction.name + " as ally because it is already an ally of " + this.name);
        if(faction == this) throw new FactionException("Can not add yourself as an ally");
        System.out.println("\n" + faction.name + " added as a friend of " + this.name);
        this.Allies.add(faction);
        faction.Allies.add(this);
    }

    void removeAlly(Faction faction) throws FactionException {
        if(!this.Allies.contains(faction)) throw new FactionException(faction.name + " is not an ally of " + this.name + ". Can not remove non existent ally.");
        System.out.println("\n" + faction.name + " removed as a friend of " + this.name);
        this.Allies.remove(faction);
        faction.Allies.remove(this);
    }
    void showMembers(){
        int index = 0;
        System.out.println("\nMEMBERS OF FACTIONS " + this.name);
        System.out.println("-----------");
        for (Character character:Characters) {
            System.out.println(index++ + " - " + character.getName() + " (" + character.getHealth() + " / 100) : " + character.getType());
        }
    }

    public boolean isMember(Character search){
        for (Character character:Characters) if(character == search) return true;
        return false;
    }
    public boolean isFriend(Faction search){
        for (Faction faction:Allies) if(faction == search) return true;
        return false;
    }
    void showFriends(){
        int index = 0;
        System.out.println("\nFRIENDS OF FACTION " + this.name);
        System.out.println("---------");
        for(Faction ally:Allies){
            System.out.println(index++ + " - " + ally.getName());
        }
    }
}
