package noeuds;

import java.util.ArrayList;
import java.util.List;

public class Bloc implements Noeud {

    private List<Noeud> fils; //Liste des noeuds fils du noeud
    
   
    /**
     * Constructeur d'un bloc
     * @param fils : liste des noeuds fils du bloc
     */
    public Bloc(List<Noeud> fils) {
        this.fils = fils;
    }

    /**
     * Constructeur d'un bloc sans fils
     */
    public Bloc() {
        this.fils = new ArrayList<Noeud>();
    }

    /**
     * Méthode permettant d'ajouter un noeud fils au noeud
     * @param fils : fils qu'on souhaiter ajouter
     */
    public void ajouter(Noeud fils) {
        this.fils.add(fils);
    }

    /**
     * Méthode permettant de récupérer les fils du noeud
     * @return la liste des fils du noeud
     */
    public List<Noeud> getFils() {
        return this.fils;
    }


    /**
     * Méthode qui éxécute les instructions de tout les noeuds fils dans l'ordre
     */
    @Override
    public void executer() {
        for(Noeud n : fils){
            n.executer();
        }
    }
}
    

