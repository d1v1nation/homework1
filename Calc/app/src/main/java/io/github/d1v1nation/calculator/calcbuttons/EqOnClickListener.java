package io.github.d1v1nation.calculator.calcbuttons;

import android.view.View;
import android.widget.Button;

import io.github.d1v1nation.calculator.CalcLogic;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *         <p/>
 *         22.10.16 of Calculator | io.github.d1v1nation.calculator.calcbuttons
 */
public class EqOnClickListener implements Button.OnClickListener {
    private final CalcLogic updater;

    public EqOnClickListener(CalcLogic updater) {
        this.updater = updater;
    }

    @Override
    public void onClick(View v) {
        this.updater.calculate();
    }
}
