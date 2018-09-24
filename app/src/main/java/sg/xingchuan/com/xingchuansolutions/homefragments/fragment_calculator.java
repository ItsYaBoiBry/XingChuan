package sg.xingchuan.com.xingchuansolutions.homefragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import sg.xingchuan.com.xingchuansolutions.R;

public class fragment_calculator extends Fragment {
    EditText etRV, etNumberOfDuration, etDepositAmount, etTotalAmount;
    Button calculate;
    private static DecimalFormat df2 = new DecimalFormat(".##");
    NestedScrollView scrollView;

    public fragment_calculator() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etRV = view.findViewById(R.id.et_rv);
        etDepositAmount = view.findViewById(R.id.et_deposit_amount);
        etNumberOfDuration = view.findViewById(R.id.et_number_of_duration);
        etTotalAmount = view.findViewById(R.id.et_total_amount);
        calculate = view.findViewById(R.id.btn_calculate);
        scrollView = view.findViewById(R.id.scrollView);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidated()) {
                    Snackbar.make(scrollView, "Fill in the missing details", Snackbar.LENGTH_LONG).show();
                } else {
                    final Dialog dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.calculation_dialog);
                    TextView tvPrice = dialog.findViewById(R.id.tvPrice);
                    TextView btnReCalculate = dialog.findViewById(R.id.btn_recalculate);
                    tvPrice.setText(String.format("$%s", df2.format(calculate())));
                    btnReCalculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            etDepositAmount.setText("");
                            etRV.setText("");
                            etNumberOfDuration.setText("");
                            etTotalAmount.setText("");
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        });
    }

    private boolean isValidated() {
        if (etTotalAmount.getText().toString().equals("")
                && etDepositAmount.getText().toString().equals("")
                && etNumberOfDuration.getText().toString().equals("")
                && etRV.getText().toString().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private Double calculate() {
        Double depositamount = Double.parseDouble(etDepositAmount.getText().toString());
        Double totalamount = Double.parseDouble(etTotalAmount.getText().toString());
        Double numberofduration = Double.parseDouble(etNumberOfDuration.getText().toString());
        Double rv = Double.parseDouble(etRV.getText().toString());
        Double calculation = (totalamount - depositamount) / numberofduration;
        return calculation;
    }

}
