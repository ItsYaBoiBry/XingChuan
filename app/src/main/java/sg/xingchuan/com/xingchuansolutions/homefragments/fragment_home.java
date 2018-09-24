package sg.xingchuan.com.xingchuansolutions.homefragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import sg.xingchuan.com.xingchuansolutions.R;
import sg.xingchuan.com.xingchuansolutions.content.ActivityLeaderboard;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_home extends Fragment {
    LinearLayout llHomeLeaderboard, llHomeAppointments,llHomeProducts;

    public fragment_home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_home, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llHomeLeaderboard = view.findViewById(R.id.ll_home_leaderboard);
        llHomeAppointments = view.findViewById(R.id.ll_home_appointments) ;
        llHomeProducts = view.findViewById(R.id.ll_home_products);
        llHomeLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ActivityLeaderboard.class));
            }
        });
    }
}
