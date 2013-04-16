package net.saga.aerogear.ajugbook.callback;

import java.util.List;

import net.saga.aerogear.ajugbook.PostListAdapter;
import net.saga.aerogear.ajugbook.R;
import net.saga.aerogear.ajugbook.vo.Post;

import org.jboss.aerogear.android.pipeline.AbstractActivityCallback;

import android.app.ListActivity;
import android.util.Log;

public class PostCallback extends AbstractActivityCallback<List<Post>> {
    
	private static final long serialVersionUID = 1L;

	@Override
    public void onSuccess(List<Post> data) {
        ListActivity activity = (ListActivity) super.getActivity();
        activity.setListAdapter(new PostListAdapter(getActivity().getApplicationContext(), R.id.status, data)); 
    }
    
    @Override
    public void onFailure(Exception e) {
        Log.e("TAG", e.getMessage(), e);
    }
}