package variables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CaractereTest {
    @ParameterizedTest
    @DisplayName("Test Caractere: méthode getValeur()")
    @ValueSource(chars = {'a','b','c','d','e','f','.',';','\n'})
    void getValeur(char val) {
        Caractere e = new Caractere("a", val);
        Assertions.assertEquals(val, e.getValeur());
    }

    @ParameterizedTest
    @DisplayName("Test Caractere: méthode getType()")
    @ValueSource(chars = {'a','b','c','d','e','f','.',';','\n'})
    void getType(char val) {
        Caractere e = new Caractere("a", val);
        Assertions.assertEquals("caractere", e.getType());
    }

    @ParameterizedTest
    @DisplayName("Test Caractere: méthode getNom()")
    @ValueSource(strings = {"a", "mavariable", "_a", "variableQuiSincremente", "i", "helloworld"})
    void getNom(String name) {
        Caractere e = new Caractere(name, 't');
        Assertions.assertEquals(name, e.getNom());
    }
    @ParameterizedTest
    @DisplayName("Test Caractere: méthode setValeur()")
    @ValueSource(chars = {'a','b','c','d','e','f','.',';','\n'})
    void setValeur(char val) {
        Caractere e = new Caractere("a", 't');
        e.setValeur(val);
        Assertions.assertEquals(val, e.getValeur());
    }
    @ParameterizedTest
    @DisplayName("Test Caractere: méthode toString()")
    @ValueSource(chars = {'a','b','c','d','e','f','.',';','\n'})
    void testToString(char val) {
        Caractere e = new Caractere("a", val);
        Assertions.assertEquals("Variable " + "a" + " de type " + "caractere" + " contenant le caractere \'" + val + "\'", e.toString());
    }
}