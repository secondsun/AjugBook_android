package net.saga.aerogear.ajugbook.callback;

import net.saga.aerogear.ajugbook.LoginActivity;

import org.jboss.aerogear.android.pipeline.AbstractActivityCallback;

import android.util.Log;

public class LogoutCallback extends AbstractActivityCallback<Void> {

	private static final long serialVersionUID = 1L;

	@Override
	public void onSuccess(Void data) {
		((LoginActivity)getActivity()).invalidateOptionsMenu();
		((LoginActivity)getActivity()).reload();
	}

	@Override
	public void onFailure(Exception e) {
		Log.e("LOGIN", e.getMessage(), e);
	}

}
