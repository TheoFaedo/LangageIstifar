package instructions;

import noeuds.Noeud;
import variables.Chaine;

public class AfficherInstruction implements Noeud {

    private Chaine c;

    public AfficherInstruction(Chaine c){
        this.c = c;
    }

    @Override
    public void executer() {
        System.out.println(c.getValeur());
    }
}
