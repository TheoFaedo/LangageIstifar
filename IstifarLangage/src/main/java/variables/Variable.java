package variables;

import exceptions.OperationInvalideException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Variable {
        
        protected String nom; //Nom de la variable
        protected String type; //Type de la variable

    /**
     * Constructeur d'une variable générique (sans valeur)
     * @param nom : nom de la variable
     * @param type : type de la variable
     */
    public Variable(String nom, String type) {
            this.nom = nom;
            this.type = type;
    }
    
    /**
     * Méthode permettant de récupérer le nom de la variable
     * @return le nom de la variable
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Méthode permettant de récupérer le type de la variable
     * @return le type de la variable
     */
    public String getType() {
        return type;
    }
    
    /**
     * Méthode permettant d'assigner un nom à la variable
     * @param nom : nom qu'on souhaite assigner
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode toString de la classe
     */
    public String toString() {
        return "Variable " + this.nom + " de type " + this.type;
    }
}
