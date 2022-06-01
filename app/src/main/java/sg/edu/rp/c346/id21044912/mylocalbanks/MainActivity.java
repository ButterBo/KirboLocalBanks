package sg.edu.rp.c346.id21044912.mylocalbanks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title;
    TextView descript;
    TextView dbs;
    TextView ocbc;
    TextView uob;
    ImageView imgdbs;
    ImageView imgocbc;
    ImageView imguob;

    String imgClicked ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate() called.");

        title = findViewById(R.id.mainTitle);
        descript = findViewById(R.id.content2);
        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);
        imgdbs = findViewById(R.id.imageViewDBS);
        imgocbc = findViewById(R.id.imageViewOCBC);
        imguob = findViewById(R.id.imageViewUOB);

        registerForContextMenu(imgdbs);
        registerForContextMenu(imgocbc);
        registerForContextMenu(imguob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == imgdbs){ //if and else if statement in order program to know which bank was clicked
            imgClicked = "apple";
        }
        else if (v == imgocbc){
            imgClicked = "banana";
        }
        else if (v == imguob){
            imgClicked = "corn";
        }
        getMenuInflater().inflate(R.menu.bank_menu, menu);
    }

    boolean fav1 = false;
    boolean fav2 = false;
    boolean fav3 = false;
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (imgClicked.equalsIgnoreCase("apple")) {
            if (id == R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbs_website)));
                startActivity(intent);
            }
            else if (id == R.id.DialSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.dbs_contact)));
                startActivity(intentCall);
            }
            else if (id == R.id.FavoriteSelection){
                if (fav1 == false){
                    dbs.setBackgroundColor(R.color.red);
                } else {
                    dbs.setBackgroundColor(R.color.tomato);
                }
            }
            return true;

        } else if (imgClicked.equalsIgnoreCase("banana")) {
            if (id == R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbc_website)));
                startActivity(intent);
            }
            else if (id == R.id.DialSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.ocbc_phone)));
                startActivity(intentCall);
            }
            else if (id == R.id.FavoriteSelection){
                if (fav2 == false){
                    ocbc.setBackgroundColor(R.color.gold);
                } else {
                    ocbc.setBackgroundColor(R.color.tomato);
                }
            }
            return true;

        } else if (imgClicked.equalsIgnoreCase("corn")){
            if (id == R.id.WebsiteSelection){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uob_website)));
                startActivity(intent);
            }
            else if (id == R.id.DialSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.uob_contact)));
                startActivity(intentCall);
            }
            else if (id == R.id.FavoriteSelection){
                if (fav3 == false){
                    uob.setBackgroundColor(R.color.gold);
                } else {
                    uob.setBackgroundColor(R.color.tomato);
                }
            }
            return true;
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {//if user chooses english
            Toast.makeText(MainActivity.this, "English is chosen ", Toast.LENGTH_SHORT).show();
            title.setText(R.string.eng_title);
            descript.setText(R.string.eng_des);
            dbs.setText(getString(R.string.eng_dbs));
            ocbc.setText(getString(R.string.eng_ocbc));
            uob.setText(getString(R.string.eng_uob));
            return true;
        } else if (id == R.id.chineseSelection) {//if user chooses chinese
            Toast.makeText(MainActivity.this, "Chinese is chosen", Toast.LENGTH_SHORT).show();
            title.setText(R.string.chin_title);
            descript.setText(R.string.chin_desc);
            dbs.setText(R.string.chin_dbs);
            ocbc.setText(R.string.chin_ocbc);
            uob.setText(R.string.chin_uob);
            return true;
        } else {
            Toast.makeText(MainActivity.this, "Error Translation", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStart() {
        Log.d("MainActivity", "onStart() called.");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d("MainActivity", "onResume() called.");
        super.onResume();
    }
    @Override
    protected void onPause() {
        Log.d("MainActivity", "onPause() called.");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.d("MainActivity", "onStop() called.");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.d("MainActivity", "onDestroy() called.");
        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        Log.d("MainActivity", "onRestart() called.");
        super.onRestart();
    }
}