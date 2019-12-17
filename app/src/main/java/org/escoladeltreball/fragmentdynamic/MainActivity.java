package org.escoladeltreball.fragmentdynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.button);
        boton.setOnClickListener(this);

        LinearLayout linearLayoutHideSoft = findViewById(R.id.layoutprincipal);
        linearLayoutHideSoft.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.layoutprincipal):

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

                try {
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (NullPointerException npe) {
                    Log.d("MethodManager", npe.getMessage() + " " + npe.getCause());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("MethodManager", e.getMessage() + " " + e.getCause());
                }

                break;

            case (R.id.button):
                BlankFragment fragment = new BlankFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.layoutprincipal, fragment, "Blank_fragment")
                        .commit();
                break;
            default:

                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
