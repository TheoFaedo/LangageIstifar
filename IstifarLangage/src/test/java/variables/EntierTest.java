package variables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EntierTest {
    @ParameterizedTest
    @DisplayName("Test Entier: méthode getValeur()")
    @ValueSource(ints = {1,2,5,10,100,1000,3333,5690,-800})
    void getValeur(int val) {
        Entier e = new Entier("a", val);
        Assertions.assertEquals(val, e.getValeur());
    }

    @ParameterizedTest
    @DisplayName("Test Entier: méthode getType()")
    @ValueSource(ints = {1,2,5,10,100,1000,3333,5690,-800})
    void getType(int val) {
        Entier e = new Entier("a", val);
        Assertions.assertEquals("entier", e.getType());
    }

    @ParameterizedTest
    @DisplayName("Test Entier: méthode getNom()")
    @ValueSource(strings = {"a", "mavariable", "_a", "variableQuiSincremente", "i", "helloworld"})
    void getNom(String name) {
        Entier e = new Entier(name, 5);
        Assertions.assertEquals(name, e.getNom());
    }
    @ParameterizedTest
    @DisplayName("Test Entier: méthode setValeur()")
    @ValueSource(ints = {1,2,5,10,100,1000,3333,5690,-800})
    void setValeur(int val) {
        Entier e = new Entier("a", -5);
        e.setValeur(val);
        Assertions.assertEquals(val, e.getValeur());
    }
    @ParameterizedTest
    @DisplayName("Test Entier: méthode toString()")
    @ValueSource(ints = {1,2,5,10,100,1000,3333,5690,-800})
    void testToString(int val) {
        Entier e = new Entier("a", val);
        Assertions.assertEquals("Variable " + "a" + " de type " + "entier" + " contenant la valeur " + val, e.toString());
    }
}