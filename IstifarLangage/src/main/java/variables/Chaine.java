package variables;

import exceptions.OperationInvalideException;
import exceptions.TypeValeurInvalideException;

public class Chaine extends Variable{

    String valeur; //Valeur de la Variable

    /**
     * Constructeur qui prend en parametre le nom de la variable et sa valeur
     * @param nom : nom de la variable
     * @param valeur : chaine étant la valeur de la variable
     */
    public Chaine(String nom, String valeur) {
        super(nom, "chaine");
        this.valeur = valeur;
    }

    public Chaine(){
        super("default", "entier");
        this.valeur = null;
    }


    /**
     * Methode permettant de récupérer la valeur de la variable
     * @return la valeur de la variable (chaine)
     */
    public String getValeur() throws OperationInvalideException {
        return valeur;
    }

    /**
     * Méthode permettant d'assigner une valeur à une variable
     * @param valeur : valeur qu'on souhaite assigner (chaine)
     */
    public void setValeur(String valeur) {
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
