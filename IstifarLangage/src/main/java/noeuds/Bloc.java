package noeuds;

import java.util.ArrayList;
import java.util.List;

public class Bloc implements Noeud {

    private List<Noeud> fils;
    
    public Bloc(List<Noeud> fils) {
        this.fils = fils;
    }

    public Bloc() {
        this.fils = new ArrayList<Noeud>();
    }

    public void ajouter(Noeud fils) {
        this.fils.add(fils);
    }

    public List<Noeud> getFils() {
        return this.fils;
    }
    
}
    

