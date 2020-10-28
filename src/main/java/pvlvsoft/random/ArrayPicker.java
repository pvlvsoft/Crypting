package pvlvsoft.random;


import java.util.Vector;


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
 * It also is an {@link RandomPicker} so it can pick a random element
 * contained. It also is able to add and remove items if needed.</p>
 *
 * <p>This class uses instance of {@link PickingMethod} to resolve
 * if the instance should or should not be removed after picking.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 *
 * @see pvlvsoft.random.RandomPicker
 * @see RandomListPicker
 * @see PickingMethod
 */
public class ArrayPicker<T> implements RandomPicker<T> {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    private Object[] array;
    private final PickingMethod pickingMethod;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */




    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>Private constructor preventing creation of empty instances.</p>
     */
    private ArrayPicker() {

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
     * <p>Returns size of the list represented by {@code int}-formed number.</p>
     *
     * @return number of elements the picker chooses from.
     */
    @Override
    public int size() {

        return this.array.length;
    }

    /**
     * <p>Adds the given element to the list of this generator picks.</p>
     *
     * @param toBeAdded Element to be added.
     */
    @Override
    public void add(T toBeAdded) {

        Object[] array = new Object[this.size() + 1];

        if (this.size() >= 0) {

            System.arraycopy(this.array, 0, array, 0, this.size());
        }

        array[this.size()] = toBeAdded;

        this.array = array;
    }

    /**
     * <p>Removes the given {@code T} instance from the list.</p>
     *
     * @param toBeRemoved instance to be removed from this.
     */
    @Override
    public void remove(T toBeRemoved) {

        Object[] array = new Object[this.size() - 1];

        for (int i = 0; i < array.length; i++) {

            if(!this.array[i].equals(toBeRemoved)) {

                array[i] = this.array[i];
            }
        }

        this.array = array;
    }

    /**
     * <p>Removes instance by it's index from the list.</p>
     *
     * @param index representation of an instance in the
     *              list to be used to remove by.
     */
    @Override
    public void remove(int index) {

        Object[] array = new Object[this.size() - 1];

        for (int i = 0; i < this.size(); i++) {

            if(i < index) {

                array[i] = this.array[i];

            } else if(i > index) {

                array[i-1] = this.array[i];
            }
        }

        this.array = array;
    }




    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */




    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */




    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */

    public Object[] getArray() {

        return array;
    }

    public PickingMethod getPickingMethod() {

        return pickingMethod;
    }
}
