package autres;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import variables.Decimale;
import variables.Entier;
import variables.Variable;

import static org.junit.jupiter.api.Assertions.*;

class InterpreteurTest {

    private static Interpreteur interpreteur;

    @BeforeAll
    static void before(){
        interpreteur = new Interpreteur();
        interpreteur.ajouterVariable(new Entier("n1", 1));
        interpreteur.ajouterVariable(new Entier("n2", 42));
        interpreteur.ajouterVariable(new Decimale("d1", 1.1));
        interpreteur.ajouterVariable(new Decimale("d2", -5.2));
    }
    @Test
    void ajouterVariable() {
        Entier e = new Entier("n", 5);
        Interpreteur i = new Interpreteur();
        i.ajouterVariable(e);
        Assertions.assertTrue(i.getVariables().get("n") != null);
    }

    @Test
    void supprimerVariable() {
        interpreteur.supprimerVariable("n1");
        Assertions.assertTrue(interpreteur.getVariables().get("n1") == null);
    }
}