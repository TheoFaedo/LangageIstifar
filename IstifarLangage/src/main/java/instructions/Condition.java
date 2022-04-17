package instructions;

import exceptions.OperationInvalideException;
import noeuds.Bloc;
import noeuds.Noeud;
import variables.Booleen;

public class Condition implements Noeud {

    private Booleen condition;
    private Bloc siOui; //Bloc éxécuté si la condition est vraie
    private Bloc siNon; //Bloc éxécuté si la condition est fausse

    /**
     * Constructeur qui ne prends en paramètre qu'un seul bloc qui s'éxécutera si et seulement si la condition fournie est vraie
     * Permet de réaliser un si unique
     * @param condition : condition demandée pour l'éxécution du bloc
     * @param bloc : bloc à éxécuter si la condition est vraie
     */
    public Condition(Booleen condition, Bloc bloc){
        this.condition = condition;
        this.siOui = bloc;
        this.siNon = null;
    }
    /**
     * Constructeur qui ne prends en paramètre qu'un seul bloc qui s'éxécutera si et seulement si la condition fournie est vraie
     * Permet de réaliser un si unique
     * @param condition : condition demandée pour l'éxécution du siOui
     * @param siOui : bloc à éxécuter si la condition est vraie
     * @param siNon : bloc à éxécuter si la condition est fausse
     */
    public Condition(Booleen condition, Bloc siOui, Bloc siNon){
        this.condition = condition;
        this.siOui = siOui;
        this.siNon = siNon;
    }


    /**
     * Méthode éxécuter de l'instruction condition
     * Execute le bloc siOui si la condition de l'instruction est vraie
     * Execute le bloc siNon si la condition de l'instructio nest fausse et que ce bloc existe
     */
    @Override
    public void executer() throws OperationInvalideException {
        if(this.condition.getValeur()){
            siOui.executer();
        }else{
            if(this.siNon != null){
                siNon.executer();
            }
        }
    }
}
