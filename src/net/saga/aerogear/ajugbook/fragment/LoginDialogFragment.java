package net.saga.aerogear.ajugbook.fragment;

import net.saga.aerogear.ajugbook.AjugBookApplication;
import net.saga.aerogear.ajugbook.R;
import net.saga.aerogear.ajugbook.callback.LoginCallback;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LoginDialogFragment extends DialogFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.login, container, false);
        
		Button button = (Button)v.findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View button) {
				String username = ((TextView)v.findViewById(R.id.username)).getText().toString();
				String password = ((TextView)v.findViewById(R.id.password)).getText().toString();
				((AjugBookApplication)getActivity().getApplication()).login(username, password, getActivity(), new LoginCallback());
			}
		});

        return v;	}
	
}
