package variables.operations;

import exceptions.OperationInvalideException;
import exceptions.TypeValeurInvalideException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import variables.Entier;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperationEntierTest {


    @ParameterizedTest
    @DisplayName("Test des additions")
    @MethodSource("additions")
    void testGetValeurAddition(Entier e1, Entier e2, char op) throws Exception{
        OperationEntier oe = new OperationEntier("nom", e1, e2, op);
        Assertions.assertTrue(oe.getValeur() == (e1.getValeur() + e2.getValeur()));
    }

    @ParameterizedTest
    @DisplayName("Test des soustractions")
    @MethodSource("soustractions")
    void testGetValeurSoustraction(Entier e1, Entier e2, char op) throws Exception{
        OperationEntier oe = new OperationEntier("nom", e1, e2, op);
        Assertions.assertTrue(oe.getValeur() == (e1.getValeur() - e2.getValeur()));
    }

    @ParameterizedTest
    @DisplayName("Test des multiplications")
    @MethodSource("multiplications")
    void testGetValeurMultiplication(Entier e1, Entier e2, char op) throws Exception{
        OperationEntier oe = new OperationEntier("nom", e1, e2, op);
        Assertions.assertTrue(oe.getValeur() == (e1.getValeur() * e2.getValeur()));
    }

    @ParameterizedTest
    @DisplayName("Test des divisions")
    @MethodSource("divisions")
    void testGetValeurDivision(Entier e1, Entier e2, char op) throws Exception{
        OperationEntier oe = new OperationEntier("nom", e1, e2, op);
        Assertions.assertTrue(oe.getValeur() == (e1.getValeur() / e2.getValeur()));
    }

    @ParameterizedTest
    @DisplayName("Test des divisions par zero")
    @MethodSource("divisionParZero")
    void testGetValeurDivisionParZero(Entier e1, Entier e2, char op) throws Exception{

        OperationEntier oe = new OperationEntier("nom", e1, e2, op);

        assertThrows(ArithmeticException.class,
                ()->{
                    oe.getValeur();
                });
    }

    @ParameterizedTest
    @DisplayName("Test operations invalides")
    @MethodSource("mauvaisesOperations")
    void testGetValeurMauvaisesOperations(Entier e1, Entier e2, char op) throws Exception{

        OperationEntier oe = new OperationEntier("nom", e1, e2, op);

        assertThrows(OperationInvalideException.class,
                ()->{
                    oe.getValeur();
                });

    }

    /*****************
     *
     *  SET DE VALEURS
     *
     ****************/

    static Stream<Arguments> additions(){
        return Stream.of(
                Arguments.of(new Entier("a", 1), new Entier("a", 1), '+'),
                Arguments.of(new Entier("a", 50), new Entier("a", 9), '+'),
                Arguments.of(new Entier("a", -5), new Entier("a", -5), '+'),
                Arguments.of(new Entier("a", -5), new Entier("a", 10), '+'),
                Arguments.of(new Entier("a", 10), new Entier("a", -5), '+')
        );
    }

    static Stream<Arguments> soustractions(){
        return Stream.of(
                Arguments.of(new Entier("a", 1), new Entier("a", 1), '-'),
                Arguments.of(new Entier("a", 50), new Entier("a", 9), '-'),
                Arguments.of(new Entier("a", -5), new Entier("a", -5), '-'),
                Arguments.of(new Entier("a", -5), new Entier("a", 10), '-'),
                Arguments.of(new Entier("a", 10), new Entier("a", -5), '-')
        );
    }
    static Stream<Arguments> multiplications(){
        return Stream.of(
                Arguments.of(new Entier("a", 1), new Entier("a", 1), '*'),
                Arguments.of(new Entier("a", 0), new Entier("a", 9), '*'),
                Arguments.of(new Entier("a", -5), new Entier("a", -5), '*'),
                Arguments.of(new Entier("a", -5), new Entier("a", 10), '*'),
                Arguments.of(new Entier("a", 10), new Entier("a", -5), '*')
        );
    }

    static Stream<Arguments> divisions(){
        return Stream.of(
                Arguments.of(new Entier("a", 1), new Entier("a", 1), '/'),
                Arguments.of(new Entier("a", 50), new Entier("a", 9), '/'),
                Arguments.of(new Entier("a", -5), new Entier("a", -5), '/'),
                Arguments.of(new Entier("a", -5), new Entier("a", 10), '/'),
                Arguments.of(new Entier("a", 10), new Entier("a", -5), '/')
        );
    }

    static Stream<Arguments> divisionParZero(){
        return Stream.of(
                Arguments.of(new Entier("a", 1), new Entier("a", 0), '/'),
                Arguments.of(new Entier("a", 50), new Entier("a", 0), '/'),
                Arguments.of(new Entier("a", -5), new Entier("a", 0), '/'),
                Arguments.of(new Entier("a", -5), new Entier("a", 0), '/'),
                Arguments.of(new Entier("a", 10), new Entier("a", 0), '/')
        );
    }

    static Stream<Arguments> mauvaisesOperations(){
        return Stream.of(
                Arguments.of(new Entier("a", 1), new Entier("a", 0), 'g'),
                Arguments.of(new Entier("a", 50), new Entier("a", 0), 'è'),
                Arguments.of(new Entier("a", -5), new Entier("a", 0), 'm'),
                Arguments.of(new Entier("a", -5), new Entier("a", 0), '"'),
                Arguments.of(new Entier("a", 10), new Entier("a", 0), '.')
        );
    }
}