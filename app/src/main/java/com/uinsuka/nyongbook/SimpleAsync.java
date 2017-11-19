package com.uinsuka.nyongbook;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Raka Adi Nugroho on 11/18/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class SimpleAsync extends AsyncTask<Void, Void, String> {
    TextView tampil;

    public SimpleAsync(TextView tampil) {
        this.tampil = tampil;
    }

    @Override
    protected String doInBackground(Void... params) {
        Random random   = new Random();
        int i   = random.nextInt(11);

        int s   = i * 400;

        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Aku Berhasil dihitung, jadi " + s;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tampil.setText(s);
    }
}
