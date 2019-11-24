package fr.esgi.rpg.jobs;
import fr.esgi.rpg.Character;
import fr.esgi.rpg.exceptions.CharacterDeadException;
import fr.esgi.rpg.exceptions.CharacterSameException;
import fr.esgi.rpg.exceptions.MageException;

public class Mage extends Character {

    /* CONSTRUCTOR */
    public Mage(String name) {
        super(name);
        getHealingPower();
        setAttack(0);
        setType("Mage");
        this.getInformation();
    }



    private void getHealingPower(){
        this.setHealing((int) Math.round((Math.random() * 5) + 5));
    }

    public void attack(Character target) throws MageException {
        throw new MageException("Mage can not attack");
    }

    public void heal(Character target) throws Exception {

        if(target.isDead()){
            System.out.println("\n" + target.getName() + " is dead."  +this.getName() + " can not heal a dead.");
            throw new CharacterDeadException("Dead character attempted to be healed.");
        }

        if(this.isDead()){
            System.out.println("\n" + this.getName() + "is dead." + this.getName() + " can not heal.");
            throw new CharacterDeadException("Dead character trying to heal.");
        }

        if(this == target) System.out.println("\n" + target.getName() + " is healing itself!");

        if(this != target) System.out.println("\n" + target.getName() + " is being healed by " + this.getName());

        if(!this.noFaction() && !this.sameFaction(target) && !this.factionAreFriends(target)) throw new CharacterSameException("\nA character can only heal people of his own Faction or friendly faction");
        this.getHealingPower();
        System.out.println("healing power set at : " + this.getHealing());
        target.setHealth((int) (target.getHealth() + this.getHealing()));
        System.out.println("\n" + target.getName() + " got +" + this.getHealing() + " point of health!");
        System.out.println("\n" + target.getName() + " health : " + target.getHealth());
    }

}
