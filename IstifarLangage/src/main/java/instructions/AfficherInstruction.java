package instructions;

import exceptions.OperationInvalideException;
import noeuds.Noeud;
import variables.Chaine;
import variables.Variable;

public class AfficherInstruction implements Noeud {

    private Variable c; //Chaine à afficher

    /**
     * Constructeur qui prend en paramètre la chaine à afficher lors de l'éxécution de l'instruction
     * @param c : chaine à afficher
     */
    public AfficherInstruction(Variable c){
        this.c = c;
    }

    /**
     * Afficher la chaine donnée en paramètre
     */
    @Override
    public void executer() throws OperationInvalideException {
        System.out.println(c);
    }
}
