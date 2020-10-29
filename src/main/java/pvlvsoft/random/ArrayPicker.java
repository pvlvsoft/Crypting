package pvlvsoft.random;


import pvlvsoft.ArrayItemsManager;

import java.util.ArrayList;
import java.util.Arrays;
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
 * <p>Class of {@link ArrayPicker} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This class defines instances build over an {@link Object}{@code []}.
 * It also is an {@link RandomSinglePicker} so it can pick a random element
 * contained. It also is able to add and remove items if needed.</p>
 *
 * <p>This class uses instance of {@link PickingMethod} to resolve
 * if the instance should or should not be removed after picking.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 *
 * @see RandomSinglePicker
 * @see RandomListSinglePicker
 * @see PickingMethod
 */
public class ArrayPicker<T>
        extends ArrayItemsManager<T>
        implements RandomSinglePicker<T>, RandomMultiPicker<T> {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    //private Object[] array;
    private final PickingMethod pickingMethod;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */




    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>Private constructor preventing creation of empty instances.</p>
     */
    protected ArrayPicker() {

        this.pickingMethod = PickingMethod.UNLIMITED_USAGE;
    }


    /**
     * <p>Constructor with one parameter. Prepares the {@code ArrayPicker}
     * to use the given array of {@code T} and sets the picking method to
     * be {@link PickingMethod#UNLIMITED_USAGE}.</p>
     *
     * @param array     To be picked of
     */
    public ArrayPicker(T[] array) {

        this.array = array;
        this.pickingMethod = PickingMethod.UNLIMITED_USAGE;
    }


    /**
     * <p>Constructor defining the array to be picked of and the method
     * to be used for picking.</p>
     *
     * @param array             The array used as a container of the elements
     *                          the {@code ArrayPicker} will be picking from
     *
     * @param pickingMethod     Method used for picking.
     */
    public ArrayPicker(T[] array, PickingMethod pickingMethod) {

        this.array = array;
        this.pickingMethod = pickingMethod;
    }



    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */


    @Override
    public String toString() {
        return "ArrayPicker{" +
                "array=" + Arrays.toString(array) +
                ", pickingMethod=" + pickingMethod +
                '}';
    }


    /**
     * <p>Randomly picks an object from the given structure.</p>
     *
     * @return the random {@link T} instance from the structure.
     */
    @Override
    public T pick() {

        int size = this.size();
        T pick = null;

        if(size > 0) {

            int number = RandomIntegerGenerator.getRandomNumber(size - 1);
            pick = (T) this.array[number];

            if(this.pickingMethod.equals(PickingMethod.REMOVE_AFTER_USE)) {

                this.remove(number);
            }
        }

        return pick;
    }

    /**
     * <p>Returns a {@link List} of random length.</p>
     *
     * <p>The size of the list is minimum 0 and maximum the
     * length of the MultiPicker.</p>
     *
     * <p>The repetition of the items is allowed by default.</p>
     *
     * @return {@link List} of random items. Some items may
     * be included more then once.
     */
    @Override
    public List<T> pickList() {
        return null;
    }

    /**
     * <p>Returns a {@link List} of random items from the Multipicker.</p>
     *
     * <p>The repetition of the items is allowed by default.</p>
     *
     * @param size size of the list.
     *
     * @return {@link List} of the randomly picked items with specified size.
     * Some items may be included more then once.
     *
     * @throws IllegalArgumentException when the size is < 0
     */
    @Override
    public List<T> pickList(int size) throws IllegalArgumentException {
        return null;
    }

    /**
     * <p>Returns a {@link List} of random items with or without repetition.</p>
     *
     * <p>Minimum size of the result list is 0, the maximum may be:
     *
     * <ul>
     *     <li>equal to number of unique instances in the multipicker</li>
     *     <li>theoretically infinite (max. length of the multipicker selaer)</li>
     * </ul>
     * <p>
     * Depends on the {@code repeat} parameter.
     * </p>
     *
     * @param repeat specifies if the instances will or will not be
     *               repeating.
     *
     * @return {@link List} of randomly picked instances from the multipicker.
     */
    @Override
    public List<T> pickList(boolean repeat) {
        return null;
    }

    /**
     * <p>Returns a {@link List} of random items with or without repetition.</p>
     *
     * <p>Minimum size of the result list is 0, the maximum may be:
     *
     * <ul>
     *     <li>equal to number of unique instances in the multipicker</li>
     *     <li>theoretically infinite (max. length of the multipicker selaer)</li>
     * </ul>
     * <p>
     * Depends on the {@code repeat} parameter.
     * </p>
     *
     * @param size   max size of the list
     * @param repeat specifies if the instances will or will not be
     *               repeating.
     *
     * @return {@link List} of randomly picked instances from the multipicker.
     *
     * @throws IllegalArgumentException when the size is < 0
     */
    @Override
    public List<T> pickList(int size, boolean repeat) throws IllegalArgumentException {

        if(size < 0) {

            throw new IllegalArgumentException(String.format(
                    "Size of the list has to be greater than 0! You gave me %s",
                    size)
            );
        }

        List<T> list = new ArrayList<>();

        if(!repeat) {

            int uniques = getNumberOfUniques();

            if (uniques < size) {

                return getUniques();

            } else {

                for (int i = 0; i < size; i++) {

                    boolean done = false;

                    while (!done) {

                        int random = RandomIntegerGenerator.getRandomNumber(this.size());
                        T item = this.get(random);

                        if (!list.contains(item)) {

                            list.add(item);
                            done = true;
                        }
                    }
                }

                return list;
            }
        }

        return null;
    }

    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */


    /**
     * <p>Protected method to prevent using it wrong. This method substitutes the
     * current {@code array} with the given one.</p>
     *
     * <p>This method should be used carefully and responsibly.</p>
     *
     * @param array to substitute the current one
     */
    protected void setArray(T[] array) {

        this.array = array;
    }


    private List<T> getUniques() {

        List<T> list = new ArrayList<>();

        for (int i = 0; i < this.size(); i++) {

            if(!list.contains(this.get(i))) {

                list.add(this.get(i));

            }
        }

        return list;
    }

    private int getNumberOfUniques() {

        return getUniques().size();
    }


    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */


    public static Object[] concatArrays(Object[]... arrays) {

        int tl = 0;
        int pointer = 0;

        for (Object[] a : arrays) {

            tl = tl + a.length;
        }

        Object[] oa = new Object[tl];

        for (Object[] objects : arrays) {

            for (Object o : objects) {

                oa[pointer] = o;
                pointer++;
            }
        }

        return oa;
    }




    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    public PickingMethod getPickingMethod() {

        return pickingMethod;
    }
}
