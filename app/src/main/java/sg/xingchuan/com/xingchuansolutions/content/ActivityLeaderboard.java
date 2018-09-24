package sg.xingchuan.com.xingchuansolutions.content;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import sg.xingchuan.com.xingchuansolutions.R;
import sg.xingchuan.com.xingchuansolutions.models.LeaderboardProfile;

public class ActivityLeaderboard extends AppCompatActivity {
    Toolbar toolbar;
    Button btnLeaderboardProfile, btnLeaderboardIncentive;
    TextView tvMonth,tvMonthOnly, tvUserSale;
    TextView tvCount, tvName, tvSales;
    CircleImageView ivProfileImage;
    LinearLayout  llLeaderboard;
    NestedScrollView svLeaderboardView,svIncentiveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        toolbar = findViewById(R.id.toolbar);
        btnLeaderboardIncentive = findViewById(R.id.btn_leaderboard_incentives);
        btnLeaderboardProfile = findViewById(R.id.btn_leaderboard_profile);
        tvMonth = findViewById(R.id.tvMonth);
        tvMonthOnly = findViewById(R.id.tv_month);
        llLeaderboard = findViewById(R.id.ll_leaderboard);
        svLeaderboardView = findViewById(R.id.sv_leaderboard_view);
        svIncentiveView = findViewById(R.id.sv_incentive_view);
        tvUserSale = findViewById(R.id.tv_user_sale);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnLeaderboardIncentive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTab(1);
            }
        });
        btnLeaderboardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTab(0);
            }
        });
        dummydata();

    }
    private void SelectTab(int button){
        if(button==0){
            btnLeaderboardProfile.setBackground(getDrawable(R.drawable.leaderboard_tab_selected));
            btnLeaderboardProfile.setTextColor(getColor(R.color.white));
            btnLeaderboardIncentive.setBackground(null);
            btnLeaderboardIncentive.setTextColor(getColor(R.color.black));
            svLeaderboardView.setVisibility(View.VISIBLE);
            svIncentiveView.setVisibility(View.GONE);
        }else if(button==1){
            btnLeaderboardIncentive.setBackground(getDrawable(R.drawable.leaderboard_tab_selected));
            btnLeaderboardIncentive.setTextColor(getColor(R.color.white));
            btnLeaderboardProfile.setBackground(null);
            btnLeaderboardProfile.setTextColor(getColor(R.color.black));
            svLeaderboardView.setVisibility(View.GONE);
            svIncentiveView.setVisibility(View.VISIBLE);
        }
    }
    private View rowview(LeaderboardProfile leaderboardProfile){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.leaderboard_list_row,null,true);
        tvCount = view.findViewById(R.id.tv_count);
        tvCount.setText(leaderboardProfile.getCount());
        tvSales = view.findViewById(R.id.tv_sale);
        tvSales.setText(leaderboardProfile.getSales());
        tvName = view.findViewById(R.id.tv_name);
        tvName.setText(leaderboardProfile.getName());
        ivProfileImage = view.findViewById(R.id.iv_profile_image);
        Glide.with(ActivityLeaderboard.this).load(leaderboardProfile.getImagelink()).into(ivProfileImage);
        return view;
    }
    public void dummydata(){
        tvMonth.setText("For the month of: "+ "July");
        tvMonthOnly.setText("July");
        tvUserSale.setText("$200 cash");
        ArrayList<LeaderboardProfile> leaderboardProfiles = new ArrayList<>();
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        leaderboardProfiles.add(new LeaderboardProfile("1","http://www.ehostingcentre.com/gravo/uploads/3b071f4fc1ce850d8b567d5ac1c0067c36e7fec4.png","$10000","Bryan Low"));
        for(int i = 0; i < leaderboardProfiles.size(); i++){
            llLeaderboard.addView(rowview(leaderboardProfiles.get(i)));
        }
        SelectTab(0);
    }
}
