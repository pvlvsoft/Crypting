package pvlvsoft.random;


import pvlvsoft.ArrayConcator;

import java.util.ArrayList;
import java.util.List;


/**
 * <i>AUTHOR OF THIS PROJECT IS NOT RESPONSIBLE FOR ANY DAMAGE TO
 * THE USER'S DEVICE CAUSED BY USING THIS SOFTWARE, NO DATA LEAKS
 * OR DATA INTEGRITY DAMAGE.</i>
 *
 * <i>THIS PIECE OF SOFTWARE WAS MADE WITH NO GUARANTEE AND SHOULD
 * NOT BE USED FOR CRITICAL INFRASTRUCTURE OF YOUR APPS. THIS
 * PROJECT WAS CREATED JUST FOR FUN.</i>
 *
 *
 * <p>Class of {@link RandomCharPicker} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p></p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 */
public class RandomCharPicker extends ArrayPicker<Character> {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */




    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    private static final int UTF16_LENGTH = 65535;
    private static final String LOWER_CASE_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CASE_STRING = LOWER_CASE_STRING.toUpperCase();
    private static final String NUMBERS_STRING = "0123456789";
    private static final String SPECIAL_CHARACTERS_STRING = "!?<>@#|%'()/\\\"*+-${}&°;,.";


    public static final char[] UTF16;

    public static final char[] LOWER_CASE;
    public static final char[] UPPER_CASE;
    public static final char[] NUMBERS;
    public static final char[] SPECIAL_CHARACTERS;


    /* =========================================================== */
    /* ====== INSTANCE INIT BLOCKS =============================== */




    /* =========================================================== */
    /* ====== STATIC INIT BLOCKS ================================= */


    static {

        UTF16 = init(new char[UTF16_LENGTH]);

        LOWER_CASE = LOWER_CASE_STRING.toCharArray();
        UPPER_CASE = UPPERCASE_CASE_STRING.toCharArray();
        NUMBERS = NUMBERS_STRING.toCharArray();
        SPECIAL_CHARACTERS = SPECIAL_CHARACTERS_STRING.toCharArray();
    }


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    private RandomCharPicker() {}


    /**
     * <p>Constructor with one parameter. Prepares the {@code ArrayPicker}
     * to use the given array of {@code T} and sets the picking method to
     * be {@link PickingMethod#UNLIMITED_USAGE}.</p>
     *
     * @param array To be picked of
     */
    public RandomCharPicker(Character[] array) {

        super(array);
    }

    /**
     * <p>Constructor defining the array to be picked of and the method
     * to be used for picking.</p>
     *
     * @param array         The array used as a container of the elements
     *                      the {@code ArrayPicker} will be picking from
     * @param pickingMethod Method used for picking.
     */
    public RandomCharPicker(Character[] array, PickingMethod pickingMethod) {

        super(array, pickingMethod);
    }


    /**
     * <p>Constructor with one parameter. Prepares the {@code ArrayPicker}
     * to use the given array of {@code T} and sets the picking method to
     * be {@link PickingMethod#UNLIMITED_USAGE}.</p>
     *
     * @param arrays To be picked of
     */
    public RandomCharPicker(Character[]... arrays) {

        super(new ArrayConcator<>(arrays).concat());
    }

    /**
     * <p>Constructor defining the array to be picked of and the method
     * to be used for picking.</p>
     *
     * @param arrays        The array used as a container of the elements
     *                      the {@code ArrayPicker} will be picking from
     * @param pickingMethod Method used for picking.
     */
    public RandomCharPicker(PickingMethod pickingMethod, Character[]... arrays) {

        super(new ArrayConcator<>(arrays).concat(), pickingMethod);
    }

    public RandomCharPicker(char[]... chars) {

        super(new ArrayConcator<Character>(chars).concat());
    }



    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */




    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */






    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */


    private static char[] init(char[] array) {

        for (int i = 0; i < array.length; i++) {

            array[i] = (char) i;
        }

        return array;
    }

    private static Character[] charArraysToObjects(char[]... arrays) {

        List<Character[]> cs = new ArrayList<>();

        for (char[] array : arrays) {

            cs.add(charsToObjects(array));
        }

        return (Character[]) concatArrays(cs.toArray());
    }


    private static Character[] charsToObjects(char[] array) {

        Character[] cs = new Character[array.length];

        for (int i = 0; i < array.length; i++) {

            cs[i] = array[i];
        }

        return cs;
    }


    public static Character[] concatArrays(Character[]... arrays) {

        int tl = 0;
        int pointer = 0;

        for (Character[] a : arrays) {

            tl = tl + a.length;
        }

        Character[] oa = new Character[tl];

        for (Character[] objects : arrays) {

            for (Character o : objects) {

                oa[pointer] = o;
                pointer++;
            }
        }

        return oa;
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */



}
