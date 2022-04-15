package autres;

import instructions.AfficherInstruction;
import noeuds.Bloc;

import noeuds.Noeud;
import variables.Chaine;
import variables.Variable;

import java.util.HashMap;

public class Interpreteur {

    private HashMap<String,Variable> variables;
    private Noeud root;

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
     * Constructeur de l'interpreteur
     */
    public Interpreteur(){
        this.root = new Bloc();
        this.variables = new HashMap<String,Variable>();
    }

    /**
     * Permet d'ajouter une variable dans le tableau de variables de l'interpreteur
     * @param v : variable à ajouter
     */
    public void ajouterVariable(Variable v){
        this.variables.put(v.getNom(), v);
    }

    /**
     * Méthode permettant de supprimer une variable dans le tableau des variables de l'interpreteur
     * @param nomVariable : nom de la variable à supprimer
     */
    public void supprimerVariable(String nomVariable){
        this.variables.remove(nomVariable);
    }

    /**
     * Méthode permettant de récupérer le tableau de variables de l'interpreteur
     * @return le tableau des variables de l'interpreteur
     */
    public HashMap<String, Variable> getVariables() {
        return variables;
    }
    
}
