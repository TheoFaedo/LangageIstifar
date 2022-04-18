package variables;

import exceptions.OperationInvalideException;
import exceptions.TypeValeurInvalideException;

public class Decimale extends Variable{

    double valeur; //Valeur de la Variable

    /**
     * Constructeur qui prend en parametre le nom de la variable et sa valeur
     * @param nom : nom de la variable
     * @param valeur : decimale étant la valeur de la variable
     */
    public Decimale(String nom, double valeur) {
        super(nom, "decimale");
        this.valeur = valeur;
    }

    public Decimale(){
        super("default", "entier");
        this.valeur = 0.0;
    }

    /**
     * Methode permettant de récupérer la valeur de la variable
     * @return la valeur de la variable (decimale)
     */
    public double getValeur() throws OperationInvalideException {
        return valeur;
    }

    /**
     * Méthode permettant d'assigner une valeur à une variable
     * @param valeur : valeur qu'on souhaite assigner (decimale)
     */
    public void setValeur(double valeur) {
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
