package autres;

import instructions.AfficherInstruction;
import noeuds.Bloc;
import noeuds.Instruction;
import variables.Chaine;

public class Interpreteur {
    public static void main(String[] args) {
        Bloc root = new Bloc();
        Bloc main = new Bloc();
        Instruction afficher = new AfficherInstruction(new Chaine("nom", "hello world"));

        main.ajouter(afficher);
        root.ajouter(main);

        root.executer();

    }
}
