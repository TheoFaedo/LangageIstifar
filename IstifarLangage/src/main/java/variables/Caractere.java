package variables;

public class Caractere extends Variable{

    char valeur; //Valeur de la Variable

    /**
     * Constructeur qui prend en parametre le nom de la variable et sa valeur
     * @param nom : nom de la variable
     * @param valeur : caractere étant la valeur de la variable
     */public Caractere(String nom, char valeur) {
        super(nom, "caractere");
        this.valeur = valeur;
    }

    /**
     * Methode permettant de récupérer la valeur de la variable
     * @return la valeur de la variable (caractere)
     */
    public char getValeur() {
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
    public String toString() {
        return "Variable " + this.nom + " de type " + this.type + " contenant le caractere \'" + this.valeur + "\'";
    }

}
