package com.jarrell.reboot;


import java.io.IOException;
import java.util.concurrent.TimeoutException;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Toast;
import com.jarrell.reboot.R;
import com.stericson.RootTools.*;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RootTools.debugMode = false;

        if (RootTools.isRootAvailable()) {
		        	if (RootTools.isAccessGiven()) {
		        		CommandCapture command = new CommandCapture(0, "reboot recovery");
		        		try {
							RootTools.getShell(true).add(command).waitForFinish();
						} catch (InterruptedException e) {
							
						} catch (IOException e) {
							
						} catch (TimeoutException e) {
							
						} catch (RootDeniedException e) {
							
						}
		                finish();
		        	}
        } else {
            makeToast("Root is not available!");
            finish();
        }

    }

    public void makeToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
