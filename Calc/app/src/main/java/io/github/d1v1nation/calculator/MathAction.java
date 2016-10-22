package io.github.d1v1nation.calculator;

import java.io.Serializable;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *         <p/>
 *         19.09.16 of Calculator | io.github.d1v1nation.calculator
 */
public interface MathAction extends Serializable {
    Double apply(Double lh, Double rh);
}
