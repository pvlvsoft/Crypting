package pvlvsoft.random;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class RandomIntegerGeneratorTest {


    /**
     * <p>This test is checking if the exception is thrown correctly,
     * when the minimum is higher than the maximum.</p>
     */
    @Test
    public void minimumValidityCheck_SuccessScenario() {

        RandomGenerator rig = null;

        try {

             rig = new RandomIntegerGenerator();

        } catch (RuntimeException re) {

            fail("The exception should not be thrown! - " + re.getMessage());
        }

        try {

            rig = new RandomIntegerGenerator(35);

        } catch (RuntimeException re) {

            fail("The exception should not be thrown! - " + re.getMessage());
        }

        try {

            rig = new RandomIntegerGenerator(0);

        } catch (RuntimeException re) {

            fail("The exception should not be thrown! - " + re.getMessage());
        }

        try {

            rig = new RandomIntegerGenerator(50, 150);

        } catch (RuntimeException re) {

            fail("The exception should not be thrown! - " + re.getMessage());
        }
    }


    /**
     * <p>This test is checking if the exception is thrown correctly,
     * when the minimum is higher than the maximum.</p>
     */
    @Test
    public void minimumValidityCheck_WrongScenario() {

        RandomGenerator rig = null;

        try {

            rig = new RandomIntegerGenerator(-10);
            fail("The exception should have been thrown!");

        } catch (RuntimeException re) {

            assertTrue(true);
        }

        try {

            rig = new RandomIntegerGenerator(10,-10);
            fail("The exception should have been thrown!");

        } catch (RuntimeException re) {

            assertTrue(true);
        }
    }


    /**
     * <p>Tests if all the values are in the defined field.</p>
     *
     * <p>Fails when it gets number greater than 5 or smaller than -5.</p>
     */
    @Test
    public void generate_inclusive() {

        RandomIntegerGenerator rg = new RandomIntegerGenerator(-5,5);

        for (int i = 0; i < 100; i++) {

            Integer num = rg.generate();

            if((num < -5) || (num > 5)) {

                fail(String.format("The number has to be in the range of -5 to 5. The result is %s.", num));
            }
        }
    }


    /**
     * <p>This test is checking if the bounds are correctly included.</p>
     *
     * <p>Fails when they are not.</p>
     */
    @Test
    public void generate_bounds() {

        int lowerBound = -10;
        int upperBound = 10;
        int rows = 10000;

        RandomIntegerGenerator rg = new RandomIntegerGenerator(lowerBound, upperBound);

        boolean lower = false;
        boolean upper = false;

        for (int i = 0; i < rows; i++) {

            Integer num = rg.generate();

            if(num == lowerBound) {

                lower = true;

            } else if(num == upperBound) {

                upper = true;
            }

            if(lower && upper) {

                break;
            }
        }

        if(!lower || !upper) {

            fail(String.format("One of the bounds was not accessed successfully in %s rows! " +
                    "Was returned: Lower one: %s; Upper one: %s", rows, lower, upper));
        }
    }


    /**
     * <p>Tests if the specified {@link RandomIntegerGenerator} returns the correct range size.</p>
     */
    @Test
    public void range_size() {

        assertEquals(new RandomIntegerGenerator(0).getRange(), new BigDecimal(1));
        assertEquals(new RandomIntegerGenerator(0, 5).getRange(), new BigDecimal(6));
        assertEquals(new RandomIntegerGenerator(-5, 5).getRange(), new BigDecimal(11));
        assertEquals(new RandomIntegerGenerator(-5, -1).getRange(), new BigDecimal(5));
    }
}