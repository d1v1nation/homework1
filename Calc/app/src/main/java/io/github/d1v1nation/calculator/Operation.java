package io.github.d1v1nation.calculator;

import java.io.Serializable;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *         <p>
 *         19.09.16 of Calculator | io.github.d1v1nation.calculator
 */
public class Operation implements Serializable {
    private final String repr;
    private final MathAction mathOp;

    public String getRepr() {
        return repr;
    }

    public Operation(MathAction mathOp, String repr) {
        this.mathOp = mathOp;
        this.repr = repr;
    }


    public MathAction getMathOp() {
        return mathOp;
    }
}
