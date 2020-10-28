package pvlvsoft.random;


import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class ArrayPickerTest {

    private static String[] STRINGS;

    @Before
    public void setup() {

        STRINGS = new String[5];

        STRINGS[0] = "A";
        STRINGS[1] = "B";
        STRINGS[2] = "C";
        STRINGS[3] = "D";
        STRINGS[4] = "E";
    }


    /**
     * Test the repetition - if the value is or is not removed after it is picked.
     */
    @Test
    public void pick_REPEATED() {

        int length = STRINGS.length;

        ArrayPicker<String> array = new ArrayPicker<>(STRINGS, PickingMethod.UNLIMITED_USAGE);

        for (int i = 0; i < 2; i++) {

            array.pick();
        }

        if(array.size() < length) {

            fail("In this case, there should have been no removals in the array!");
        }
    }


    /**
     * Test the repetition - if the value is or is not removed after it is picked.
     */
    @Test
    public void pick_WITHOUT_REPETITION() {

        int length = STRINGS.length;

        ArrayPicker<String> array = new ArrayPicker<>(STRINGS, PickingMethod.REMOVE_AFTER_USE);

        for (int i = 0; i < 2; i++) {

            array.pick();
        }

        if(array.size() == length) {

            fail("In this case, there should have been a few removals in the array!");
        }
    }


    /**
     * <p>Tests the adding method.</p>
     */
    @Test
    public void add() {

        String addedValue = "F";

        ArrayPicker<String> array = new ArrayPicker<>(STRINGS, PickingMethod.UNLIMITED_USAGE);

        array.add(addedValue);

        assertEquals(array.size(), 6);
        assertEquals(array.getArray()[5], addedValue);
    }
}