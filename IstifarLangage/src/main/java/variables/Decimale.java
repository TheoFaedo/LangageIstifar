package variables;

public class Decimale extends Variable{

    double valeur;
    
    public Decimale(String nom, double valeur) {
        super(nom, "decimale");
        this.valeur = valeur;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public String toString() {
        return "Variable " + this.nom + " de type " + this.type + " contenant la valeur " + this.valeur;
    }

}
