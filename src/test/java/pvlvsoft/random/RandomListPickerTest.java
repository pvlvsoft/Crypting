package pvlvsoft.random;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class RandomListPickerTest {

    private static List<Integer> NUMBERS;

    @Before
    public void setUp() {

        NUMBERS = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            NUMBERS.add(i);
        }
    }


    @Test
    public void pick_LPM_REPEATING() {

        RandomListPicker<Integer> rlp = new RandomListPicker<>(NUMBERS, PickingMethod.UNLIMITED_USAGE);
        Integer defaultNumber = rlp.pick();

        int rows = 10000;
        boolean pickedAgain = false;

        for (int i = 0; i < rows; i++) {

            if(rlp.pick().equals(defaultNumber)) {

                pickedAgain = true;
                break;
            }
        }

        if(!pickedAgain) {

            fail(String.format("Number was not picked again even after %s rows of picking.", rows));
        }
    }


    @Test
    public void pick_LPM_WITHOUT_REPEATING() {

        RandomListPicker<Integer> rlp = new RandomListPicker<>(NUMBERS, PickingMethod.REMOVE_AFTER_USE);
        Integer defaultNumber = rlp.pick();

        int rows = 10000;
        int finished = 0;
        boolean unique = true;

        for (int i = 0; i < rows; i++) {

            Integer pick = rlp.pick();

            if(pick != null) {

                if (pick.equals(defaultNumber)) {

                    finished = i;
                    unique = false;
                    break;
                }

            } else {

                break;
            }
        }

        if(!unique) {

            fail(String.format("Number was picked again after %s of %s rows of picking.", finished, rows));
        }
    }
}