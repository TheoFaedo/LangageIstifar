package variables;

import exceptions.OperationInvalideException;
import exceptions.TypeValeurInvalideException;

public class Caractere extends Variable{

    char valeur; //Valeur de la Variable

    /**
     * Constructeur qui prend en parametre le nom de la variable et sa valeur
     * @param nom : nom de la variable
     * @param valeur : caractere étant la valeur de la variable
     */
    public Caractere(String nom, char valeur) {
        super(nom, "caractere");
        this.valeur = valeur;
    }

    public Caractere(){
        super("default", "entier");
        this.valeur = 'c';
    }

    /**
     * Methode permettant de récupérer la valeur de la variable
     * @return la valeur de la variable (caractere)
     */
    public char getValeur() throws OperationInvalideException {
        return valeur;
    }

    /**
     * Méthode permettant d'assigner une valeur à une variable
     * @param valeur : valeur qu'on souhaite assigner (caractere)
     */
    public void setValeur(char valeur) {
        this.valeur = valeur;
    }

    /**
     * Méthode toString de la classe
     * @return chaine représentant l'objet
     */
    public String toString(){
        try{
            return this.getValeur() + "";
        }catch (OperationInvalideException e){
            return "Operation inconnue";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Erreur";
    }

}
