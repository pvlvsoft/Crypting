package pvlvsoft.random;


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
 * <p>Interface of {@link RandomPicker} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 *
 * <p>This interface defines the base of the set of lists (and not only lists)
 * which can give you a random item from themself.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 *
 * @see RandomListPicker
 * @see ArrayPicker
 */
public interface RandomPicker<T> {


    /**
     * <p>Randomly picks an object from the given structure.</p>
     *
     * @return  the random {@link T} instance from the structure.
     */
    public T pick();


    /**
     * <p>Returns size of the list represented by {@code int}-formed number.</p>
     *
     * @return  number of elements the picker chooses from.
     */
    public int size();


    /**
     * <p>Adds the given element to the list of this generator picks.</p>
     *
     * @param toBeAdded     Element to be added.
     */
    public void add(T toBeAdded);


    /**
     * <p>Removes the given {@code T} instance from the list.</p>
     *
     * @param toBeRemoved   instance to be removed from this.
     */
    public void remove(T toBeRemoved);


    /**
     * <p>Removes instance by it's index from the list.</p>
     *
     * @param index representation of an instance in the
     *              list to be used to remove by.
     */
    public void remove(int index);
}
