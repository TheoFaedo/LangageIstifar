package instructions;

import noeuds.Instruction;
import variables.Chaine;

public class AfficherInstruction extends Instruction {

    private Chaine c;

    public AfficherInstruction(Chaine c){
        this.c = c;
    }

    @Override
    public void executer() {
        System.out.println(c.getValeur());
    }
}
