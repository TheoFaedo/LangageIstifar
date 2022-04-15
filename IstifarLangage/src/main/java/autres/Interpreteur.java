package autres;

import instructions.AfficherInstruction;
import noeuds.Bloc;

import variables.Chaine;
import variables.Variable;

import java.util.HashMap;

public class Interpreteur {

    private HashMap<String,Variable> variables;

    public static void main(String[] args) {

        //On créer les différents noeuds

        Bloc root = new Bloc(); //Bloc contenant tout le programme

        Bloc main = new Bloc();
        AfficherInstruction afficher = new AfficherInstruction(new Chaine("nom", "hello world"));

        //On lie les noeuds
        main.ajouter(afficher);
        root.ajouter(main);

        //On lance l'éxécution du programme
        root.executer();

    }

    /**
     * Permet d'ajouter une variable dans le tableau de variables de l'interpreteur
     * @param v : variable à ajouter
     */
    public void ajouterVariable(Variable v){
        this.variables.put(v.getNom(), v);
    }
}
