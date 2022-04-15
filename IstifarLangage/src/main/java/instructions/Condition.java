package instructions;

import noeuds.Bloc;
import noeuds.Noeud;
import variables.Booleen;

public class Condition implements Noeud {

    private Booleen condition;
    private Bloc siOui; //Bloc éxécuté si la condition est vraie
    private Bloc siNon; //Bloc éxécuté si la condition est fausse

    public Condition(Booleen condition, Bloc bloc){
        this.condition = condition;
        this.siOui = bloc;
        this.siNon = null;
    }
    public Condition(Booleen condition, Bloc siOui, Bloc siNon){
        this.condition = condition;
        this.siOui = siOui;
        this.siNon = siNon;
    }


    @Override
    public void executer() {
        if(this.condition.getValeur()){
            siOui.executer();
        }else{
            if(this.siNon != null){
                siNon.executer();
            }
        }
    }
}
