package io.github.d1v1nation.calculator.calcbuttons;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import io.github.d1v1nation.calculator.CalcLogic;
import io.github.d1v1nation.calculator.Operation;


public class ButtonFactory {

    private CalcLogic calcLogic;
    private Context ctx;

    public ButtonFactory(Context ctx, CalcLogic calcLogic) {
        this.ctx = ctx;
        this.calcLogic = calcLogic;
    }

    public Button produceNumeral(String numeral) {
        Button b =  new Button(ctx);


        // appearance
        b.setBackgroundColor(0xC0DEBABE);
        b.setText(numeral);
        b.setTextSize(20);

        //OCL
        b.setOnClickListener(new NumeralOnClickListener(numeral, calcLogic));

        return b;
    }

    public Button produceOperal(Operation op) {
        Button b = new Button(ctx);

        //appearance
        b.setBackgroundColor(0xDEADBEEF);
        b.setText(op.getRepr());
        b.setTextSize(15);

        //OCL
        b.setOnClickListener(new OperalOnClickListener(op, calcLogic));

        return b;
    }

    public Button produceEquator() {
        Button b = new Button(ctx);

        //appearance
        b.setBackgroundColor(0xC0C1C0C1);
        b.setText("=");
        b.setTextSize(20);

        //OCL
        b.setOnClickListener(new EqOnClickListener(calcLogic));

        return b;
    }

    public Button produceClr() {
        Button b = new Button(ctx);

        //appearance
        b.setBackgroundColor(0xC0C1C0C1);
        b.setText("C");
        b.setTextSize(15);

        //OCL
        b.setOnClickListener(new ClrOnClickListener(calcLogic));

        //strange requirements
        b.getResources().getI

        return b;
    }

}
