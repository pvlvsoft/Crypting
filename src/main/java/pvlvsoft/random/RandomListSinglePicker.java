package pvlvsoft.random;


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
 * <p>Class of {@link RandomListSinglePicker} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This implementation of {@link RandomSinglePicker} is a general instance
 * definition of a {@link List} random picker.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 *
 * @see RandomSinglePicker
 * @see ArrayPicker
 */
public class RandomListSinglePicker<T> implements RandomSinglePicker<T> {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    private final List<T> list;
    private final PickingMethod pickingMethod;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */




    /* =========================================================== */
    /* ====== INSTANCE INIT BLOCKS =============================== */




    /* =========================================================== */
    /* ====== STATIC INIT BLOCKS ================================= */





    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    private RandomListSinglePicker() {

        this.list = new ArrayList<>();
        this.pickingMethod = PickingMethod.UNLIMITED_USAGE;
    }


    public RandomListSinglePicker(List<T> list) {

        this.list = list;
        this.pickingMethod = PickingMethod.UNLIMITED_USAGE;
    }


    public RandomListSinglePicker(List<T> list, PickingMethod method) {

        this.list = list;
        this.pickingMethod = method;
    }


    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */

    /**
     * <p>Generates a random instance defined by the class.</p>
     *
     * @return random generated instance.
     */
    @Override
    public T pick() {

        int listSize = this.list.size();
        T toBeReturned = null;

        if(listSize > 0) {

            toBeReturned = this.list.get(RandomIntegerGenerator.getRandomNumber(listSize - 1));

            if(this.pickingMethod.equals(PickingMethod.REMOVE_AFTER_USE)) {

                this.list.remove(toBeReturned);
            }
        }

        return toBeReturned;
    }


    /**
     * <p>Returns size of the list represented by {@code int}-formed number.</p>
     *
     * @return number of elements the picker chooses from.
     */
    public int size() {

        return this.list.size();
    }

    /**
     * <p>Adds the given element to the list of this generator picks.</p>
     *
     * @param toBeAdded Element to be added.
     */
    public void add(T toBeAdded) {

        this.list.add(toBeAdded);
    }


    /**
     * <p>Removes the given {@code T} instance from the list.</p>
     *
     * @param toBeRemoved   instance to be removed from this.
     */
    public void remove(T toBeRemoved) {

        this.list.remove(toBeRemoved);
    }


    /**
     * <p>Removes instance by it's index from the list.</p>
     *
     * @param index representation of an instance in the
     *              list to be used to remove by.
     */
    public void remove(int index) {

        this.list.remove(index);
    }




    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */






    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */




    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */

    public List<T> getList() {

        return list;
    }

    public PickingMethod getPickingMethod() {

        return pickingMethod;
    }
}
