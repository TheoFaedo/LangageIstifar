package variables;

public class Caractere extends Variable{

    char valeur;
    
    public Caractere(String nom, char valeur) {
        super(nom, "caractere");
        this.valeur = valeur;
    }

    public char getValeur() {
        return valeur;
    }

    public void setValeur(char valeur) {
        this.valeur = valeur;
    }

    public String toString() {
        return "Variable " + this.nom + " de type " + this.type + " contenant le caractere \'" + this.valeur + "\'";
    }

}
