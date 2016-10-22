package io.github.d1v1nation.calculator.calcbuttons;

import android.view.View;
import android.widget.Button;

import io.github.d1v1nation.calculator.CalcLogic;
import io.github.d1v1nation.calculator.Operation;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *         <p>
 *         19.09.16 of Calculator | io.github.d1v1nation.calculator.calcbuttons
 */
public class OperalOnClickListener implements Button.OnClickListener {

    private final Operation op;
    private final CalcLogic calcLogic;

    public OperalOnClickListener(Operation op, CalcLogic calcLogic) {
        this.op = op;
        this.calcLogic = calcLogic;
    }

    @Override
    public void onClick(View v) {
        calcLogic.setCurrentOp(op);
    }
}
