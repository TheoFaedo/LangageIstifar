package variables;

import exceptions.OperationInvalideException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DecimaleTest {
    @ParameterizedTest
    @DisplayName("Test Decimale: méthode getValeur()")
    @ValueSource(doubles = {0.5,0.5e5,50.0,10.5,111.54,4.52E10,0.54,-1.1e10,-8.54})
    void getValeur(double val) throws OperationInvalideException{
        Decimale e = new Decimale("a", val);
        Assertions.assertEquals(val, e.getValeur());
    }

    @ParameterizedTest
    @DisplayName("Test Decimale: méthode getType()")
    @ValueSource(doubles = {0.5,0.5e5,50.0,10.5,111.54,4.52E10,0.54,-1.1e10,-8.54})
    void getType(double val) {
        Decimale e = new Decimale("a", val);
        Assertions.assertEquals("decimale", e.getType());
    }

    @ParameterizedTest
    @DisplayName("Test Decimale: méthode getNom()")
    @ValueSource(strings = {"a", "mavariable", "_a", "variableQuiSincremente", "i", "helloworld"})
    void getNom(String name) {
        Decimale e = new Decimale(name, 5);
        Assertions.assertEquals(name, e.getNom());
    }
    @ParameterizedTest
    @DisplayName("Test Decimale: méthode setValeur()")
    @ValueSource(doubles = {0.5,0.5e5,50.0,10.5,111.54,4.52E10,0.54,-1.1e10,-8.54})
    void setValeur(double val) throws OperationInvalideException {
        Decimale e = new Decimale("a", -5);
        e.setValeur(val);
        Assertions.assertEquals(val, e.getValeur());
    }
    @ParameterizedTest
    @DisplayName("Test Decimale: méthode toString()")
    @ValueSource(doubles = {0.5,0.5e5,50.0,10.5,111.54,4.52E10,0.54,-1.1e10,-8.54})
    void testToString(double val) {
        Decimale e = new Decimale("a", val);
        Assertions.assertEquals(val + "", e.toString());
    }
}