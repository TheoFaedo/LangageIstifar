package autres;

import exceptions.OperationInvalideException;
import instructions.AfficherInstruction;
import noeuds.Bloc;

import noeuds.Noeud;
import variables.Chaine;
import variables.Variable;

import java.util.HashMap;

public class Interpreteur {

    private HashMap<String,Variable> variables;
    private Noeud root;

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

    /**
     * Méthode qui retourne le Noeud root de l'interpreteur
     * @return Noeud root de l'interpreteur
     */
    public Noeud getRoot(){
        return this.root;
    }

    /**
     * Méthode qui permet l'éxécution du programme lorsque tout les noeuds ont été chargés.
     */
    public void executerInterpreteur(){
        try{
            this.root.executer();
        }catch(OperationInvalideException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
