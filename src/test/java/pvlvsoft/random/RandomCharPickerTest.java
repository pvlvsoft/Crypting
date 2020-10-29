package pvlvsoft.random;


import org.junit.Test;

import static org.junit.Assert.*;


public class RandomCharPickerTest {


    @Test
    public void testPicking() {

        RandomCharPicker rcp = new RandomCharPicker(
                RandomCharPicker.LOWER_CASE,
                RandomCharPicker.UPPER_CASE,
                RandomCharPicker.NUMBERS
        );

        try {

            for (long i = 0; i < 1000; i++) {

                rcp.pick();
            }

        } catch (Exception e) {

            fail(e.getMessage());
        }
    }

}