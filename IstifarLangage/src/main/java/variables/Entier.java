package variables;

public class Entier extends Variable{

    int valeur;
    
    public Entier(String nom, int valeur) {
        super(nom, "entier");
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String toString() {
        return "Variable " + this.nom + " de type " + this.type + " contenant la valeur " + this.valeur;
    }

}
