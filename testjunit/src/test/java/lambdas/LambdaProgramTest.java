package lambdas;

import org.junit.Test;

import static org.junit.Assert.*;

public class LambdaProgramTest {
    @Test
    public void getNumTest() {
        assertEquals(22, LambdaProgram.getNum( () -> 22 ));
        assertEquals(22, LambdaProgram.getNum( () -> 11 + 11 ));
        assertEquals(11, LambdaProgram.getNum( () -> 22 / 2 ));
    }

    @Test
    public void FunctionOneArgumentTest() {
        assertEquals(100, LambdaProgram.func(d -> d * 10));
        assertEquals(
                20,
                LambdaProgram.func(
                        new TwoFunctionalInterface() {
                            @Override
                            public int doOneNum(int digit) {
                                return digit + 10;
                            }
                        }
                )
        );
        assertEquals(0, LambdaProgram.func(d -> d - 10));
    }

    @Test
    public void equalsTwoDigitsTest() {
        assertTrue(LambdaProgram.equalsNums((a, b) -> a < b));
        assertFalse(LambdaProgram.equalsNums((a, b) -> a > b));
        assertFalse(LambdaProgram.equalsNums((a, b) -> a == b));
        assertTrue(LambdaProgram.equalsNums((a, b) -> a != b));
    }
}
