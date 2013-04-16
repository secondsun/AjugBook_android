package net.saga.aerogear.ajugbook.callback;

import net.saga.aerogear.ajugbook.LoginActivity;

import org.jboss.aerogear.android.http.HeaderAndBody;
import org.jboss.aerogear.android.pipeline.AbstractActivityCallback;

import android.util.Log;

public class LoginCallback extends AbstractActivityCallback<HeaderAndBody> {

	private static final long serialVersionUID = 1L;

	@Override
	public void onSuccess(HeaderAndBody data) {
		((LoginActivity)getActivity()).dismissLogin();
		((LoginActivity)getActivity()).reload();
	}

	@Override
	public void onFailure(Exception e) {
		Log.e("LOGIN", e.getMessage(), e);
	}

}
