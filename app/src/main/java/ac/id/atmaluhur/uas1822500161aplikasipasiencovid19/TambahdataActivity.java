package ac.id.atmaluhur.uas1822500161aplikasipasiencovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TambahdataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahdata);
    }
        public void kembali (View View){
            Intent i = new Intent(this, DashboardActivity.class);
            startActivity(i);

        }

    }