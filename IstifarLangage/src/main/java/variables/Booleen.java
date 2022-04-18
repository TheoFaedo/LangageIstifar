package variables;

import exceptions.OperationInvalideException;
import exceptions.TypeValeurInvalideException;

public class Booleen extends Variable{

    boolean valeur; //Valeur de la Variable

    /**
     * Constructeur qui prend en parametre le nom de la variable et sa valeur
     * @param nom : nom de la variable
     * @param valeur : booleen étant la valeur de la variable
     */
    public Booleen(String nom, boolean valeur) {
        super(nom, "booleen");
        this.valeur = valeur;
    }

    public Booleen(){
        super("default", "booleen");
        this.valeur = false;
    }

    /**
     * Methode permettant de récupérer la valeur de la variable
     * @return la valeur de la variable (booleen)
     */
    public boolean getValeur() throws OperationInvalideException {
        return valeur;
    }

    /**
     * Méthode permettant d'assigner une valeur à une variable
     * @param valeur : valeur qu'on souhaite assigner (booleen)
     */
    public void setValeur(boolean valeur) {
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
