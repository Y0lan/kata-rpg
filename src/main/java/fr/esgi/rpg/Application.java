package fr.esgi.rpg;

import fr.esgi.rpg.jobs.Mage;
import fr.esgi.rpg.jobs.Warrior;

public class Application{
   public static void main(String[] args) throws Exception {
       /* First iteration: Characters */
      Warrior James = new Warrior("James");
      James.setHealth(1000000);
      System.out.println("James health can not go above 100 : " + James.getHealth());
      James.setHealth(-10000);
      System.out.println("James health can not go below 0 : " + James.getHealth());
      James.getInformation();

      /* JAMES IS DEAD */
      Warrior Toto = new Warrior("Toto");
      //Toto.attack(James); // DOES NOT WORK
      Mage Mickey = new Mage("Mickey");
      Toto.attack(Mickey);

     /* ITERATION WARRIOR */
      Mickey.heal(Mickey); //Mage can heal itself

      /* no time for more test ... */

   }
}
