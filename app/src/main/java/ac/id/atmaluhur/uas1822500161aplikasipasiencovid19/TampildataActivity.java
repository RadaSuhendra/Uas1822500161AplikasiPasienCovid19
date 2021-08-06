package ac.id.atmaluhur.uas1822500161aplikasipasiencovid19;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TampildataActivity extends AppCompatActivity {
    private  String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    ArrayList<HashMap<String,String>> pasienlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampildata);
        pasienlist = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listviewpasien);
        new AmbilDataMakanan().execute();

    }
    private class AmbilDataMakanan extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(TampildataActivity.this, "Loading Data...", Toast.LENGTH_LONG).show();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String url= "http//192.168.1.3/pasien/data_pasien.php";
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "data dari php: "+jsonStr);
            if (jsonStr !=null){
                try{
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray data_pasien = jsonObject.getJSONArray("makanan");
                    for (int i = 0; i<data_pasien.length();i++){
                        JSONObject c = data_pasien.getJSONObject(i);
                        HashMap <String,String> detail_makanan = new HashMap<>();
                        detail_makanan.put("NIK", c.getString("NIK"));
                        detail_makanan.put("Nama", c.getString("Nama"));
                        detail_makanan.put("Gejala", c.getString("Gejala"));
                        detail_makanan.put("Alamat", c.getString("Alamat"));
                        pasienlist.add(detail_makanan);

                    }
                } catch (final JSONException e)
                {
                    Log.e(TAG, "Gagal kirim Data"+ e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "gagal kirim Data :"+ e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }else{
                Toast.makeText(getApplicationContext(), "Data kosong" , Toast.LENGTH_LONG).show();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ListAdapter adapter= new SimpleAdapter(TampildataActivity.this, pasienlist,
                    R.layout.activity_pasien, new String[]{"nama", "gejala", "alamat"},
                    new int[]{R.id.txtnama, R.id.txtgejala, R.id.txtalamat});
            lv.setAdapter(adapter);
        }
    }

}