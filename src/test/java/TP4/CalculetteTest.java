package TP4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculetteTest {

    @Test
    void additionSimple() {
        assertEquals(7, Calculette.polonaiseInverse("3 4 +"));
    }

    @Test
    void exempleDuMain() {
        assertEquals(2, Calculette.polonaiseInverse("3 4 + 2 * 7 /"));
    }

    @Test
    void expressionComplexe() {
        assertEquals(14, Calculette.polonaiseInverse("5 1 2 + 4 * + 3 -"));
    }

    @Test
    void multiplicationEtAddition() {
        assertEquals(10, Calculette.polonaiseInverse("2 3 * 4 +"));
    }

    @Test
    void divisionEntiereTronquee() {
        assertEquals(2, Calculette.polonaiseInverse("7 3 /"));
        assertEquals(-2, Calculette.polonaiseInverse("-7 3 /"));
    }

    @Test
    void nombresNegatifs() {
        assertEquals(-1, Calculette.polonaiseInverse("-3 2 +"));
    }

    @Test
    void operandeUnique() {
        assertEquals(42, Calculette.polonaiseInverse("42"));
    }

    @Test
    void divisionParZero() {
        assertThrows(ArithmeticException.class, () -> Calculette.polonaiseInverse("1 0 /"));
    }

    @Test
    void operateurInvalide() {
        assertThrows(IllegalArgumentException.class, () -> Calculette.polonaiseInverse("2 2 ^"));
    }

    @Test
    void operandesInsuffisants() {
        assertThrows(java.util.EmptyStackException.class, () -> Calculette.polonaiseInverse("1 +"));
    }
}