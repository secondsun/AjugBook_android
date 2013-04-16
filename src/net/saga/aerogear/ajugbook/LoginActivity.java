package net.saga.aerogear.ajugbook;


import net.saga.aerogear.ajugbook.callback.LogoutCallback;
import net.saga.aerogear.ajugbook.callback.PostCallback;
import net.saga.aerogear.ajugbook.fragment.AccountDialogFragment;
import net.saga.aerogear.ajugbook.fragment.LoginDialogFragment;
import net.saga.aerogear.ajugbook.vo.Post;

import org.jboss.aerogear.android.pipeline.LoaderPipe;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LoginActivity extends ListActivity {
    
	private LoginDialogFragment loginDialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
        reload();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	AjugBookApplication app = (AjugBookApplication) getApplication();
    	if (app.isLoggedIn()) {
    		getMenuInflater().inflate(R.menu.logoff, menu);
    	} else {
    		getMenuInflater().inflate(R.menu.login, menu);
    	}
        return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.login:
			loginDialog = new LoginDialogFragment();
			loginDialog.show(getFragmentManager(), "DIALOG");
			return true;
		case R.id.logout:
			AjugBookApplication app = (AjugBookApplication) getApplication();
			app.logout(this, new LogoutCallback());
			return true;
		case R.id.enroll:
			return true;
		case R.id.account:
			new AccountDialogFragment().show(getFragmentManager(), "DIALOG");
			return true;
		case R.id.photos:
			return true;
		default:
			break;
		}
    	return super.onMenuItemSelected(featureId, item);
    }
    
    public void dismissLogin() {
		if (loginDialog.isVisible()) {
			invalidateOptionsMenu();
			loginDialog.dismiss();
		}
	}

	public void reload() {
		AjugBookApplication app = (AjugBookApplication) getApplication();
		LoaderPipe<Post> postPipe = app.getPostPipe(this);
		postPipe.reset();
		postPipe.read(new PostCallback());
	}
}
