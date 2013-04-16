package net.saga.aerogear.ajugbook;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import net.saga.aerogear.ajugbook.vo.Post;
import android.content.ClipData.Item;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PostListAdapter extends ArrayAdapter<Post> {

	private List<Post> posts;

	public PostListAdapter(Context context, int textViewResourceId,
			List<Post> objects) {
		super(context, textViewResourceId, objects);
		posts = objects;
	}

	@Override
	public View getView(int position, View v, ViewGroup parent) {

		if (v == null) {
			LayoutInflater vi = (LayoutInflater) super.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.post_layout, null);
		}

		Post post = (Post) posts.get(position);

		if (post != null) {

			RelativeLayout postLayout = (RelativeLayout) v;
			ImageView i = (ImageView) postLayout.findViewById(R.id.image);
			InputStream stream = new ByteArrayInputStream(post.getImage().getImageBytes());
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
		    stream = new ByteArrayInputStream(post.getImage().getImageBytes());
			i.setImageBitmap(BitmapFactory.decodeStream(stream, null, options));
			TextView username = (TextView) postLayout
					.findViewById(R.id.usern_name);
			username.setText(post.getAuthorUsername());
			TextView status = (TextView) postLayout.findViewById(R.id.status);
			status.setText(post.getText());
		}
		return v;

	}

}
