package starwars.app.starwarsse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

/**
 * Created by cba on 2017-09-13.
 */

public class SplashScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        if(!isNetworkAvailable()){

            AlertDialog.Builder checkBuilder = new AlertDialog.Builder(SplashScreen.this, R.style.CustomDialogTheme);
            checkBuilder.setTitle("Error!");
            checkBuilder.setMessage("No internet Connection found!");
            checkBuilder.setCancelable(false);

            checkBuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            checkBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alert = checkBuilder.create();
            alert.show();
        }
        else {
            if (isNetworkAvailable()){

                Thread tr=new Thread(){
                    public  void  run(){
                        try {
                            sleep(3000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            startActivity(new Intent(SplashScreen.this,MainActivity.class));
                            finish();
                        }
                    }
                };
                tr.start();
            }
        }
    }

    private boolean isNetworkAvailable(){
        ConnectivityManager manager =(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null;
    }
}