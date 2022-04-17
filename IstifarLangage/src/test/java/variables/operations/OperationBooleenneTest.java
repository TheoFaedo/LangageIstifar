package variables.operations;

import exceptions.OperationInvalideException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import variables.Booleen;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationBooleenneTest {

    @ParameterizedTest
    @DisplayName("Test getValeur et")
    @MethodSource("et")
    void getValeurEt(Booleen b1, Booleen b2, char op) throws OperationInvalideException {
        OperationBooleenne ob = new OperationBooleenne("a",b1,b2,op);
        Assertions.assertTrue(ob.getValeur() == (b1.getValeur() && b2.getValeur()));
    }

    @ParameterizedTest
    @DisplayName("Test getValeur ou")
    @MethodSource("ou")
    void getValeurOu(Booleen b1, Booleen b2, char op) throws OperationInvalideException {
        OperationBooleenne ob = new OperationBooleenne("a",b1,b2,op);
        Assertions.assertTrue(ob.getValeur() == (b1.getValeur() || b2.getValeur()));
    }

    @ParameterizedTest
    @DisplayName("Test getValeur non")
    @MethodSource("non")
    void getValeurNon(Booleen b1) throws OperationInvalideException {
        OperationBooleenne ob = new OperationBooleenne("a",b1);
        Assertions.assertTrue(ob.getValeur() == (!b1.getValeur()));
    }

    @ParameterizedTest
    @DisplayName("Test getValeur non")
    @MethodSource("mauvaisesOperations")
    void testGetValeurMauvaisesOperations(Booleen b1, Booleen b2, char op) throws Exception{

        OperationBooleenne ob = new OperationBooleenne("nom", b1, b2, op);

        assertThrows(OperationInvalideException.class,
                ()->{
                    ob.getValeur();
                });

    }


    /*****************
     *
     *  SET DE VALEURS
     *
     ****************/

    static Stream<Arguments> et(){
        return Stream.of(
                Arguments.of(new Booleen("a", false), new Booleen("a", false), '&'),
                Arguments.of(new Booleen("a", false), new Booleen("a", true), '&'),
                Arguments.of(new Booleen("a", true), new Booleen("a", false), '&'),
                Arguments.of(new Booleen("a", true), new Booleen("a", true), '&')
        );
    }

    static Stream<Arguments> ou(){
        return Stream.of(
                Arguments.of(new Booleen("a", false), new Booleen("a", false), '|'),
                Arguments.of(new Booleen("a", false), new Booleen("a", true), '|'),
                Arguments.of(new Booleen("a", true), new Booleen("a", false), '|'),
                Arguments.of(new Booleen("a", true), new Booleen("a", true), '|')
        );
    }

    static Stream<Arguments> non(){
        return Stream.of(
                Arguments.of(new Booleen("a", false)),
                Arguments.of(new Booleen("a", true))
        );
    }
    static Stream<Arguments> mauvaisesOperations(){
        return Stream.of(
                Arguments.of(new Booleen("a", false), new Booleen("a", false), 'a'),
                Arguments.of(new Booleen("a", false), new Booleen("a", true), '*'),
                Arguments.of(new Booleen("a", true), new Booleen("a", false), '-'),
                Arguments.of(new Booleen("a", true), new Booleen("a", true), '"')
        );
    }

}