package fr.esgi.rpg.exceptions;
@SuppressWarnings("serial")
public class CharacterDeadException extends Exception {
    public CharacterDeadException(String message){
        super(message);
    }
}
