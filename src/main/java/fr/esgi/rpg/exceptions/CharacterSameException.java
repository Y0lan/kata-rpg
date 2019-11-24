package fr.esgi.rpg.exceptions;

@SuppressWarnings("serial")
public class CharacterSameException extends Exception {
   public CharacterSameException(String message){
        super(message);
    }
}
