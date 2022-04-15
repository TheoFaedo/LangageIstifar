package variables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChaineTest {
    @ParameterizedTest
    @DisplayName("Test Chaine: méthode getValeur()")
    @ValueSource(strings = {"haha", "hihi", "\'a\'", "\n\n", "hello world"})
    void getValeur(String val) {
        Chaine e = new Chaine("a", val);
        Assertions.assertEquals(val, e.getValeur());
    }

    @ParameterizedTest
    @DisplayName("Test Chaine: méthode getType()")
    @ValueSource(strings = {"haha", "hihi", "\'a\'", "\n\n", "hello world"})
    void getType(String val) {
        Chaine e = new Chaine("a", val);
        Assertions.assertEquals("chaine", e.getType());
    }

    @ParameterizedTest
    @DisplayName("Test Chaine: méthode getNom()")
    @ValueSource(strings = {"a", "mavariable", "_a", "variableQuiSincremente", "i", "helloworld"})
    void getNom(String name) {
        Chaine e = new Chaine(name, "chaine");
        Assertions.assertEquals(name, e.getNom());
    }
    @ParameterizedTest
    @DisplayName("Test Chaine: méthode setValeur()")
    @ValueSource(strings = {"haha", "hihi", "\'a\'", "\n\n", "hello world"})
    void setValeur(String val) {
        Chaine e = new Chaine("a", "chaine");
        e.setValeur(val);
        Assertions.assertEquals(val, e.getValeur());
    }
    @ParameterizedTest
    @DisplayName("Test Chaine: méthode toString()")
    @ValueSource(strings = {"haha", "hihi", "\'a\'", "\n\n", "hello world"})
    void testToString(String val) {
        Chaine e = new Chaine("a", val);
        Assertions.assertEquals("Variable " + "a" + " de type " + "chaine" + " contenant la chaine \"" + val + "\"", e.toString());
    }
}