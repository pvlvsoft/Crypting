package pvlvsoft.random;


import java.math.BigDecimal;
import java.util.Random;


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
 * <p>Class of {@link RandomIntegerGenerator} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p></p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 */
public class RandomIntegerGenerator implements NumericGenerator {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    private final Random random;
    private final Integer lowerBound;
    private final Integer upperBound;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    private static final String DEFAULT_ERROR_MESSAGE =
            "Given minimum (%s) has to be smaller or equal to maximum (%s)!";

    public static final int DEFAULT_MINIMUM = 0;
    public static final int DEFAULT_MAXIMUM = Integer.MAX_VALUE;


    /* =========================================================== */
    /* ====== INSTANCE INIT BLOCKS =============================== */


    {
        random = new Random();
    }


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>Non-parametric constructor which specifies the bounds to
     * {@code 0} to {@code 2147483647} (integer max value).</p>
     *
     * <p>All the numbers are inclusive, which means the number
     * can be {@code 0} to {@code 2147483647}.</p>
     */
    public RandomIntegerGenerator() {

        this.lowerBound = DEFAULT_MINIMUM;
        this.upperBound = DEFAULT_MAXIMUM;
    }


    /**
     * <p>Random integer number generator constructor defined by
     * it's bounds. All the numbers are inclusive, which means
     * the number can be {@code 0} to {@code upperBound}.</p>
     *
     * <p>This one is defined by it's upper bound only.</p>
     *
     * @param upperBound                The number which should be
     *                                  the maximum possible returned.
     *
     * @throws IllegalArgumentException When the maximum possible number
     *                                  is smaller than {@code {@value DEFAULT_MINIMUM}}.
     */
    public RandomIntegerGenerator(Integer upperBound) throws IllegalArgumentException {

        if(upperBound < DEFAULT_MINIMUM) {

            throw new IllegalArgumentException(String.format(DEFAULT_ERROR_MESSAGE, DEFAULT_MINIMUM, upperBound));
        }

        this.lowerBound = DEFAULT_MINIMUM;
        this.upperBound = upperBound;
    }



    /**
     * <p>Random integer number generator constructor defined by
     * it's bounds. All the numbers are inclusive, which means
     * the number can be {@code lowerBound} to {@code upperBound}.</p>
     *
     * <p>This one is defined by it's lower and upper bound.</p>
     *
     * @param lowerBound                The number which should be
     *                                  the minimum possible returned.
     *
     * @param upperBound                The number which should be
     *                                  the maximum possible returned.
     *
     * @throws IllegalArgumentException When the maximum possible number
     *                                  is smaller than {@code lowerBound}.
     */
    public RandomIntegerGenerator(Integer lowerBound, Integer upperBound) {

        if(upperBound < lowerBound) {

            throw new IllegalArgumentException(String.format(DEFAULT_ERROR_MESSAGE, lowerBound, upperBound));
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }



    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */

    /**
     * <p>Generates a random instance defined by the class.</p>
     *
     * <p>The random number is generated using the upper and lower bound.</p>
     *
     * @return  random generated instance.
     */
    @Override
    public Integer generate() {

        return lowerBound + random.nextInt(upperBound - lowerBound + 1);
    }



    /**
     * <p>Returns a range the {@link NumericGenerator} is generating numbers from.</p>
     *
     * @return {@link BigDecimal} interpretation of the size of the
     * range the generator operates in.
     */
    @Override
    public BigDecimal getRange() {

        return new BigDecimal(this.upperBound).subtract(new BigDecimal(this.lowerBound)).add(new BigDecimal(1));
    }



    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {

        return super.toString();
    }



    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */





    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */




    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */

    public Integer getLowerBound() {

        return lowerBound;
    }

    public Integer getUpperBound() {

        return upperBound;
    }
}
