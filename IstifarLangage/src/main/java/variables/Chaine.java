package variables;

public class Chaine extends Variable{

    String valeur;
    
    public Chaine(String nom, String valeur) {
        super(nom, "chaine");
        this.valeur = valeur;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String toString() {
        return "Variable " + this.nom + " de type " + this.type + " contenant la chaine \"" + this.valeur + "\"";
    }

}
