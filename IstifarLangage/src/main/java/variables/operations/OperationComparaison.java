package variables.operations;

import exceptions.OperationInvalideException;
import variables.Booleen;
import variables.Entier;

public class OperationComparaison extends Booleen {

    private Entier n1, n2;
    private char operation;

    public OperationComparaison(String nom, Entier n1, Entier n2, char op){
        super(nom, false);
        this.n1 = n1;
        this.n2 = n2;
        this.operation = op;
    }

    /**
     * Méthode getValeur modifiée pour retourner le resultat des deux entier de l'opération entre les deux entiers de l'instance
     * @return : opération entre les deux entier
     */
    @Override
    public boolean getValeur() throws OperationInvalideException{
        switch(this.operation){
            case '>':
                return n1.getValeur() > n2.getValeur();
            case '<':
                return n1.getValeur() < n2.getValeur();
            default:
                throw new OperationInvalideException();
        }
    }
}
