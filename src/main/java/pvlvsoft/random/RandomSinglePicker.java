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
 * <p>Interface of {@link RandomSinglePicker} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 *
 * <p>This interface defines the base of the set of lists (and not only lists)
 * which can give you a random item from themself.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 *
 * @see RandomListSinglePicker
 * @see ArrayPicker
 */
public interface RandomSinglePicker<T> {


    /**
     * <p>Randomly picks an object from the given structure.</p>
     *
     * @return  the random {@link T} instance from the structure.
     */
    public T pick();
}
