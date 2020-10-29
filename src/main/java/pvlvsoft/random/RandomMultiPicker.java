package pvlvsoft.random;


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
 * <p>Interface of {@link RandomMultiPicker} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 *
 * <p></p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-29
 */
public interface RandomMultiPicker<T> {

    /**
     * <p>Returns a {@link List} of random length.</p>
     *
     * <p>The size of the list is minimum 0 and maximum the
     * length of the MultiPicker.</p>
     *
     * <p>The repetition of the items is allowed by default.</p>
     *
     * @return  {@link List} of random items. Some items may
     *          be included more then once.
     */
    public List<T> pickList();


    /**
     * <p>Returns a {@link List} of random items from the Multipicker.</p>
     *
     * <p>The repetition of the items is allowed by default.</p>
     *
     * @param size    size of the list.
     *
     * @return  {@link List} of the randomly picked items with specified size.
     *          Some items may be included more then once.
     *
     * @throws IllegalArgumentException when the size is < 0
     */
    public List<T> pickList(int size) throws IllegalArgumentException;


    /**
     * <p>Returns a {@link List} of random items with or without repetition.</p>
     *
     * <p>Minimum size of the result list is 0, the maximum may be:
     *
     * <ul>
     *     <li>equal to number of unique instances in the multipicker</li>
     *     <li>theoretically infinite (max. length of the multipicker selaer)</li>
     * </ul>
     *
     * Depends on the {@code repeat} parameter.
     * </p>
     *
     * @param repeat    specifies if the instances will or will not be
     *                  repeating.
     *
     * @return          {@link List} of randomly picked instances from the multipicker.
     */
    public List<T> pickList(boolean repeat);




    /**
     * <p>Returns a {@link List} of random items with or without repetition.</p>
     *
     * <p>Minimum size of the result list is 0, the maximum may be:
     *
     * <ul>
     *     <li>equal to number of unique instances in the multipicker</li>
     *     <li>theoretically infinite (max. length of the multipicker selaer)</li>
     * </ul>
     *
     * Depends on the {@code repeat} parameter.
     * </p>
     *
     * @param size      max size of the list
     *
     * @param repeat    specifies if the instances will or will not be
     *                  repeating.
     *
     * @return          {@link List} of randomly picked instances from the multipicker.
     *
     * @throws IllegalArgumentException when the size is < 0
     */
    public List<T> pickList(int size, boolean repeat) throws IllegalArgumentException;

}
