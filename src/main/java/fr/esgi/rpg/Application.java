package fr.esgi.rpg;

import fr.esgi.rpg.jobs.Mage;
import fr.esgi.rpg.jobs.Warrior;

public class Application{
   public static void main(String[] args) throws Exception {
     Faction WizardSchool = new Faction("Wizard School");
     Faction Monster = new Faction("Monster");

     Mage Healer = new Mage("Healer");
     Warrior Yolan = new Warrior("Yolan");
     Warrior Godzilla = new Warrior("Godzilla");

     Yolan.join(WizardSchool);
     Godzilla.join(Monster);

     Yolan.attack(Godzilla);
     Healer.join(WizardSchool);
     Healer.join(Monster);
     Healer.showFactions();
     WizardSchool.addAlly(Monster);
     Healer.heal(Godzilla);

   }
}
