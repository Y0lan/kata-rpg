package fr.esgi.rpg;

import fr.esgi.rpg.exceptions.CharacterDeadException;
import fr.esgi.rpg.exceptions.CharacterSameException;
import fr.esgi.rpg.exceptions.FactionException;
import fr.esgi.rpg.jobs.Mage;
import fr.esgi.rpg.jobs.Warriors;

public class Application{
   public static void main(String[] args) throws Exception {
     Warriors Muddy = new Warriors("Muddy");
     Mage Euyinn = new Mage("Euyinn");
     Mage Lola = new Mage("Lola");
     Faction Lolita = new Faction("Lolita");
     Lolita.addMember(Lola);
     Faction WizardSchool = new Faction("Wizard School");

     try{
         WizardSchool.addMember(Euyinn);
         WizardSchool.addMember(Muddy);
         Muddy.attack(Lola);
         WizardSchool.removeMember(Muddy);
         Muddy.attack(Lola);
         Lolita.addMember(Muddy);
         Lolita.showMembers();
         Lola.heal(Muddy);
     } catch (FactionException e){
         System.out.println(e.getMessage());
     }

   }
}
