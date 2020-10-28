package pvlvsoft.random;


import java.math.BigDecimal;
import java.math.BigInteger;


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
 * <p>Interface of {@link NumericGenerator} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 *
 * <p></p>
 *
 * @author Vojtech Pavlu
 * @version 2020-10-28
 */
public interface NumericGenerator extends RandomGenerator {

    /**
     * <p>Returns a range the {@link NumericGenerator} is generating numbers from.</p>
     *
     * @return  {@link BigDecimal} interpretation of the size of the
     *          range the generator operates in.
     */
    public BigDecimal getRange();
}
