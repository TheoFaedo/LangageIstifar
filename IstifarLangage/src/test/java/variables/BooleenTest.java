package variables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BooleenTest {
    @ParameterizedTest
    @DisplayName("Test Booleen: méthode getValeur()")
    @ValueSource(booleans = {true,false})
    void getValeur(boolean val) {
        Booleen e = new Booleen("a", val);
        Assertions.assertEquals(val, e.getValeur());
    }

    @ParameterizedTest
    @DisplayName("Test Booleen: méthode getType()")
    @ValueSource(booleans = {true,false})
    void getType(boolean val) {
        Booleen e = new Booleen("a", val);
        Assertions.assertEquals("booleen", e.getType());
    }

    @ParameterizedTest
    @DisplayName("Test Booleen: méthode getNom()")
    @ValueSource(strings = {"a", "mavariable", "_a", "variableQuiSincremente", "i", "helloworld"})
    void getNom(String name) {
        Booleen e = new Booleen(name, false);
        Assertions.assertEquals(name, e.getNom());
    }
    @ParameterizedTest
    @DisplayName("Test Booleen: méthode setValeur()")
    @ValueSource(booleans = {true,false})
    void setValeur(boolean val) {
        Booleen e = new Booleen("a", false);
        e.setValeur(val);
        Assertions.assertEquals(val, e.getValeur());
    }
    @ParameterizedTest
    @DisplayName("Test Booleen: méthode toString()")
    @ValueSource(booleans = {true,false})
    void testToString(boolean val) {
        Booleen e = new Booleen("a", val);
        Assertions.assertEquals("Variable " + "a" + " de type " + "booleen" + " contenant la valeur " + val, e.toString());
    }
}