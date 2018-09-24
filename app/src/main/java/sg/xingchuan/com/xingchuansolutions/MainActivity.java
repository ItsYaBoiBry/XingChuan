package sg.xingchuan.com.xingchuansolutions;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_appointments;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_calculator;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_contacts;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_home;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_likes;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_media;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_products;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_profile;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_sales_order;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_scanner;
import sg.xingchuan.com.xingchuansolutions.homefragments.fragment_settings;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView leftDrawer;
    Toolbar toolbar;
    FragmentTransaction ft;
    FrameLayout content;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        leftDrawer = findViewById(R.id.left_drawer);
        content = findViewById(R.id.content);
        title = findViewById(R.id.title);

        leftDrawer.setItemIconTintList(null);

        configureNavigationDrawer();
        configureToolbar();

        if (savedInstanceState == null) {
            replacefragment(new fragment_home());
        }

    }
    public void replacefragment(Fragment fragment) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.commit();
    }
    public void CloseDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    public void OpenDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    private void configureToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionbar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    private void configureNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.left_drawer);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.menu_home:
                        title.setText("");
                        replacefragment(new fragment_home());
                        CloseDrawer();
                        return true;
                    case R.id.menu_profile:
                        title.setText(getText(R.string.label_profile));
                        replacefragment(new fragment_profile());
                        CloseDrawer();
                        return true;
                    case R.id.menu_media:
                        title.setText(getText(R.string.label_media));
                        replacefragment(new fragment_media());
                        CloseDrawer();
                        return true;
                    case R.id.menu_contacts:
                        title.setText(getText(R.string.label_contacts));
                        replacefragment(new fragment_contacts());
                        CloseDrawer();
                        return true;
                    case R.id.menu_appointments:
                        title.setText(getText(R.string.label_appointments));
                        replacefragment(new fragment_appointments());
                        CloseDrawer();
                        return true;
                    case R.id.menu_scanner:
                        title.setText(getText(R.string.label_scanner));
                        replacefragment(new fragment_scanner());
                        CloseDrawer();
                        return true;
                    case R.id.menu_products:
                        title.setText(getText(R.string.label_products));
                        replacefragment(new fragment_products());
                        CloseDrawer();
                        return true;
                    case R.id.menu_likes:
                        title.setText(getText(R.string.label_likes));
                        replacefragment(new fragment_likes());
                        CloseDrawer();
                        return true;
                    case R.id.menu_sales_order:
                        title.setText(getText(R.string.label_sales_order));
                        replacefragment(new fragment_sales_order());
                        CloseDrawer();
                        return true;
                    case R.id.menu_calculator:
                        title.setText(getText(R.string.label_calculator));
                        replacefragment(new fragment_calculator());
                        CloseDrawer();
                        return true;
                    case R.id.menu_settings:
                        title.setText(getText(R.string.label_settings));
                        replacefragment(new fragment_settings());
                        CloseDrawer();
                        return true;
                }
                return false;
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            // Android home
            case android.R.id.home:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    CloseDrawer();
                    return true;
                } else {
                    OpenDrawer();
                    return true;
                }

        }

        return false;
    }
}
