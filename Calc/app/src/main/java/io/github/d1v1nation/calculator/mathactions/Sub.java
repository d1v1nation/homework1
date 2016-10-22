package io.github.d1v1nation.calculator.mathactions;

import io.github.d1v1nation.calculator.MathAction;
import io.github.d1v1nation.calculator.Operation;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *         <p/>
 *         22.10.16 of Calculator | io.github.d1v1nation.calculator.mathactions
 */
public class Sub extends Operation {
    public Sub() {
        super(new MathAction() {
            @Override
            public Double apply(Double lh, Double rh) {
                return lh - rh;
            }
        }, "-");
    }
}
