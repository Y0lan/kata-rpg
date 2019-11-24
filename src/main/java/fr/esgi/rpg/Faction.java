package fr.esgi.rpg;

import fr.esgi.rpg.exceptions.FactionException;

import java.util.*;

public class Faction {
    private List<Character> Characters = new ArrayList<Character>();
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


    void addMember(Character character) throws FactionException {
        if(this.Characters.contains(character)) throw new FactionException(character.getName() + " already is part of the faction " + this.name);
        else {
            this.Characters.add(character);
            character.addFaction(this);
            System.out.println("New member " + character.getName() + " joined " + this.name + "! Welcome!");
        }
    }

    void removeMember(Character character) throws FactionException {
        if(this.Characters.contains(character)) {
            this.Characters.remove(character);
            character.removeFaction(this);
            System.out.println(character.getName() + " left faction " + this.name + "... Bye!");
        }
        else throw new FactionException(character.getName() + " is not a member of the faction " + this.name);
    }

    void showMembers(){
        int index = 0;
        System.out.println("\nMEMBERS OF FACTIONS " + this.name);
        System.out.println("-----------");
        for (Character character:Characters) {
            System.out.println(index++ + " - " + character.getName() + " (" + character.getHealth() + " / 100) : " + character.getType());
        }
    }
}
