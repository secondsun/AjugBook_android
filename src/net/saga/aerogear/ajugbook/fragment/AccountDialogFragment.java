package net.saga.aerogear.ajugbook.fragment;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.saga.aerogear.ajugbook.AjugBookApplication;
import net.saga.aerogear.ajugbook.R;
import android.app.DialogFragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class AccountDialogFragment extends DialogFragment {

	RelativeLayout view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.account, container, false);
        view = (RelativeLayout) v;
        ((AjugBookApplication)getActivity().getApplication()).loadAccount(this);
        return v;
	}

	public void setFirstName(String firstName) {
		((EditText)view.findViewById(R.id.editText1)).setText(firstName);
	}

	public void setLastName(String lastName) {
		((EditText)view.findViewById(R.id.editText2)).setText(lastName);
	}

	public void setEmail(String emailAddress) {
		((EditText)view.findViewById(R.id.editText3)).setText(emailAddress);
	}

	public void setImage(byte[] bytes) {
		ImageView i = (ImageView) view.findViewById(R.id.imageView1);
		InputStream stream = new ByteArrayInputStream(bytes);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		
		BitmapFactory.decodeStream(stream ,null, options);
		
		final int height = options.outHeight;
	    final int width = options.outWidth;
	    int inSampleSize = 1;

	    if (height > 200 || width > 500) {

	        // Calculate ratios of height and width to requested height and width
	        final int heightRatio = Math.round((float) height / (float) 200);
	        final int widthRatio = Math.round((float) width / (float) 500);

	        // Choose the smallest ratio as inSampleSize value, this will guarantee
	        // a final image with both dimensions larger than or equal to the
	        // requested height and width.
	        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
	    }
		

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    options.inSampleSize = inSampleSize;
	    stream = new ByteArrayInputStream(bytes);
		i.setImageBitmap(BitmapFactory.decodeStream(stream, null, options));
	}
	
}
