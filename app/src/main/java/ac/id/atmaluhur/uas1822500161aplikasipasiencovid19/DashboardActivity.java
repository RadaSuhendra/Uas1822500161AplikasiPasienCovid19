package ac.id.atmaluhur.uas1822500161aplikasipasiencovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.*;
public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void tambah (View View){
        Intent i = new Intent(this, TambahdataActivity.class);
        startActivity(i);

    }
    public void lihat (View View){
        Intent i = new Intent(this, TampildataActivity.class);
        startActivity(i);

    }
    public void keluar (View View){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

}