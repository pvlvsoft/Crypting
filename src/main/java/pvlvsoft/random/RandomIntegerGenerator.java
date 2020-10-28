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


    /* =========================================================== */
    /* ====== INSTANCE INIT BLOCKS =============================== */


    {
        random = new Random();
    }


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    public RandomIntegerGenerator() {

        this.lowerBound = 0;
        this.upperBound = Integer.MAX_VALUE;
    }


    public RandomIntegerGenerator(Integer upperBound) {

        if(upperBound < 0) {

            throw new IllegalArgumentException(String.format(DEFAULT_ERROR_MESSAGE, 0, upperBound));
        }

        this.lowerBound = 0;
        this.upperBound = upperBound;
    }

    public RandomIntegerGenerator(Integer lowerBound, Integer upperBound) {

        if(upperBound < lowerBound) {

            throw new IllegalArgumentException(String.format(DEFAULT_ERROR_MESSAGE, lowerBound, upperBound));
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }



    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */




    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */


    /**
     * <p>Generates a random instance defined by the class.</p>
     *
     * <p>The random number is generated using the upper and lower bound.</p>
     *
     * @return  random generated instance.
     */
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
