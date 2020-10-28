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
 * <p>Enumeration of {@link PickingMethod} is an abstract container of these
 * related types.</p>
 *
 * <p>This enumeration defines the two main methods of picking an element from
 * the {@link List}.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 */
public enum PickingMethod {

    /**
     * <p>The element will be removed from the list when returning.</p>
     */
    REMOVE_AFTER_USE,

    /**
     * <p>The element stays in the list even after it's returning.</p>
     */
    UNLIMITED_USAGE

}
