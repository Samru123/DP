/*package com.example.dp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/

package com.example.dp;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.FrameLayout;
        import android.widget.Toast;

        import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Development development_frag;
    Design design_frag;
    Marking marking_frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        development_frag=new Development();
        design_frag=new Design();
        marking_frag=new Marking();

        BottomNavigationView nav=findViewById(R.id.nav);
        final FrameLayout content=findViewById(R.id.content_layout);

        change_Fragement(development_frag);

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.development:
                        change_Fragement(development_frag);
                        Animation a= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(a);
                        return true;

                    case R.id.design:
                        change_Fragement(design_frag);
                        Animation b=AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(b);
                        return true;

                    case R.id.marking:
                        change_Fragement(marking_frag);
                        Animation c= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(c);
                        return true;

                        default:return false;
                }
                //return false;
            }
        });
    }

    private void change_Fragement(Fragment fragment) {
        FragmentTransaction fragmentTransaction3=getSupportFragmentManager().beginTransaction();
        fragmentTransaction3.replace(R.id.content_layout,fragment);
        fragmentTransaction3.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.development:
                Toast.makeText(MainActivity.this,"Development",Toast.LENGTH_SHORT).show();
                break;

            case R.id.design:
                Toast.makeText(MainActivity.this,"Design",Toast.LENGTH_SHORT).show();
                break;

            case R.id.marking:
                Toast.makeText(MainActivity.this,"Marking",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
