package variables;

import exceptions.OperationInvalideException;
import exceptions.TypeValeurInvalideException;

public class Entier extends Variable{

    int valeur; //Valeur de la Variable

    /**
     * Constructeur qui prend en parametre le nom de la variable et sa valeur
     * @param nom : nom de la variable
     * @param valeur : entier étant la valeur de la variable
     */
    public Entier(String nom, int valeur) {
        super(nom, "entier");
        this.valeur = valeur;
    }

    public Entier(){
        super("default", "entier");
        this.valeur = 0;
    }

    /**
     * Methode permettant de récupérer la valeur de la variable
     * @return la valeur de la variable (entier)
     */
    public int getValeur() throws OperationInvalideException {
        return valeur;
    }

    /**
     * Méthode permettant d'assigner une valeur à une variable
     * @param valeur : valeur qu'on souhaite assigner (entier)
     */
    public void setValeur(int valeur) {
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
