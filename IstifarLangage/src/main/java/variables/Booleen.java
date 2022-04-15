package variables;

public class Booleen extends Variable{

    boolean valeur;

    public Booleen(String nom, boolean valeur) {
        super(nom, "booleen");
        this.valeur = valeur;
    }

    public boolean getValeur() {
        return valeur;
    }

    public void setValeur(boolean valeur) {
        this.valeur = valeur;
    }

    public String toString() {
        return "Variable " + this.nom + " de type " + this.type + " contenant la valeur " + this.valeur;
    }

}
