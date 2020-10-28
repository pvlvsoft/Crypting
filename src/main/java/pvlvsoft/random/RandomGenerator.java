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
 * <p>Interface of {@link RandomGenerator} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 *
 * <p>This interface defines basic set of methods to work with generator. It
 * set's a default mutual platform for other kinds of generators, such as
 * {@link NumericGenerator}s (specially {@link RandomIntegerGenerator}).</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 */
public interface RandomGenerator {


    /**
     * <p>Generates a random instance defined by the class.</p>
     *
     * @return  random generated instance.
     */
    public Object generate();
}
