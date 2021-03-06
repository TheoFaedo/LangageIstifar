package noeuds;

import exceptions.OperationInvalideException;

public interface Noeud {
   /**
    * Fonction récursive qui peut éxécuter une instruction et/ou éxécuter d'autres noeuds
    */
   void executer() throws OperationInvalideException;
}