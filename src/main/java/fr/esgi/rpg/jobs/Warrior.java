package fr.esgi.rpg.jobs;
import fr.esgi.rpg.Character;
import fr.esgi.rpg.Faction;
import fr.esgi.rpg.exceptions.CharacterDeadException;
import fr.esgi.rpg.exceptions.CharacterSameException;
import fr.esgi.rpg.exceptions.FactionException;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        getAttackPower();
        setHealing(1);
        setType("Warrior");
        getInformation();
    }

    public void getInformation(){
        System.out.println("Name : " + this.getName());
        System.out.println("Health : " + this.getHealth());
        System.out.println("Status: " + this.getStatus());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Healing: " + this.getHealing());
    }


    public void attack(Character target) throws Exception {
        if(target.isDead()){
            System.out.println(this.getName() + " is dead."  +this.getName() + " can not attack a dead.");
            throw new CharacterDeadException("Dead character attacked.");
        }

        if(this.isDead()){
            System.out.println(this.getName() + "is dead." + this.getName() + " can not attack.");
            throw new CharacterDeadException("Dead character attacking.");
        }

        if(this == target)  System.out.println(target.getName() + " just attacked itself!");
        if(this != target)  System.out.println("\n" + this.getName() + " attacked " + target.getName());

        if(this.sameFaction(target)){
            System.out.println("\nCan not attack member of the same Faction!");
            throw new CharacterSameException("Character in the same faction can not attack themselves!");
        }

        if(this.factionAreFriends(target)){
            System.out.println("\n" + this.getName() + " is in a faction friends with a faction " + target.getName() + " is member of. Can not attack people from Friendly faction.");
            throw new FactionException("Can not attack an ally of a friendly faction");
        }

        this.getAttackPower();
        System.out.println("\n" + target.getName() + " took " + this.getAttack() + " damage!");
        target.setHealth((int) (target.getHealth() - this.getAttack()));

        if(target.getHealth() == 0) target.setDead();
    }

    public void getAttackPower(){
        this.setAttack(Math.round(Math.random() * 9));
    }
    public void heal(Character target) throws Exception {
        if(target != this) throw new CharacterSameException(this.getName() + " is a warrior. A warrior can only heal itself (trying to heal " + target.getName() + " )");
        if(this.isDead()){
            System.out.println("\n" + this.getName() + "is dead." + this.getName() + " can not heal.");
            throw new CharacterDeadException("Dead character trying to heal.");
        }
        System.out.println("\n" + this.getName() + " healed himself!");
        System.out.println("\n" + this.getName() + " got +" + this.getHealing() + " point of health!");
        target.setHealth(this.getHealth() + (int) this.getHealing());
    }

}
