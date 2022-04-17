package variables.operations;

import exceptions.OperationInvalideException;
import variables.Booleen;

public class OperationBooleenne extends Booleen{

    private Booleen b1, b2;
    private char operation;

    public OperationBooleenne(String nom, Booleen b1, Booleen b2, char op){
        super(nom, false);
        this.b1 = b1;
        this.b2 = b2;
        this.operation = op;
    }

    public OperationBooleenne(String nom, Booleen b1){
        super(nom, false);
        this.b1 = b1;
        this.b2 = null;
        this.operation = '!';
    }

    /**
     * Méthode getValeur modifiée pour retourner le resultat des deux entier de l'opération entre les deux entiers de l'instance
     * @return : opération entre les deux entier
     */
    @Override
    public boolean getValeur() throws OperationInvalideException {
        switch(this.operation){
            case '&':
                return b1.getValeur() && b2.getValeur();
            case '|':
                return b1.getValeur() || b2.getValeur();
            case '!':
                return !b1.getValeur();
            default:
                throw new OperationInvalideException();
        }
    }
}
