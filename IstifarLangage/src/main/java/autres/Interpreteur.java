package autres;

import instructions.AfficherInstruction;
import noeuds.Bloc;
import variables.Chaine;

public class Interpreteur {
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
}
