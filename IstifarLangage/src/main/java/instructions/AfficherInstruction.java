package instructions;

import exceptions.OperationInvalideException;
import noeuds.Noeud;
import variables.Chaine;

public class AfficherInstruction implements Noeud {

    private Chaine c; //Chaine à afficher

    /**
     * Constructeur qui prend en paramètre la chaine à afficher lors de l'éxécution de l'instruction
     * @param c : chaine à afficher
     */
    public AfficherInstruction(Chaine c){
        this.c = c;
    }

    /**
     * Afficher la chaine donnée en paramètre
     */
    @Override
    public void executer() throws OperationInvalideException {
        System.out.println(c.getValeur());
    }
}
