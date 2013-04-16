/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.saga.aerogear.ajugbook;

import java.net.MalformedURLException;
import java.net.URL;

import net.saga.aerogear.ajugbook.fragment.AccountDialogFragment;
import net.saga.aerogear.ajugbook.vo.AccountBean;
import net.saga.aerogear.ajugbook.vo.Post;

import org.jboss.aerogear.android.Callback;
import org.jboss.aerogear.android.Pipeline;
import org.jboss.aerogear.android.authentication.AuthenticationConfig;
import org.jboss.aerogear.android.authentication.AuthenticationModule;
import org.jboss.aerogear.android.authentication.impl.Authenticator;
import org.jboss.aerogear.android.http.HeaderAndBody;
import org.jboss.aerogear.android.impl.pipeline.PipeConfig;
import org.jboss.aerogear.android.pipeline.LoaderPipe;

import android.app.Activity;
import android.app.Application;

public class AjugBookApplication extends Application {

    private Pipeline pipeline;
    final static URL baseURL;
    private Authenticator authenticator; 
    static {
        try {
            baseURL = new URL("http://10.0.2.2:8080/AjugBook");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void onCreate() {
        super.onCreate(); 
        pipeline = new Pipeline(baseURL);
        
        AuthenticationConfig config = new AuthenticationConfig();
        authenticator = new Authenticator(baseURL);
        AuthenticationModule module = authenticator.auth("auth", config);
        
        PipeConfig postConfig = new PipeConfig(baseURL, Post.class);
        postConfig.setAuthModule(module);
        pipeline.pipe(Post.class, postConfig);
     
        PipeConfig accountConfig = new PipeConfig(baseURL, AccountBean.class);
        accountConfig.setEndpoint("account");
        accountConfig.setName("account");
        accountConfig.setAuthModule(module);
        pipeline.pipe(AccountBean.class, accountConfig);
        
        
    }
    
    public LoaderPipe<Post> getPostPipe(Activity activity) {
        return pipeline.get("post", activity);
    }

    public void login(String username, String password, Activity activity, Callback<HeaderAndBody> callback) {
    	authenticator.get("auth", activity).login(username, password, callback);
    }
    
    public void logout(Activity activity, Callback<Void> callback) {
    	authenticator.get("auth", activity).logout(callback);
    }
    
    public boolean isLoggedIn() {
    	return authenticator.get("auth").isLoggedIn();
    }

	public void loadAccount(AccountDialogFragment accountDialogFragment) {
		LoaderPipe pipe = pipeline.get("account", accountDialogFragment, this);
		pipe.reset();
		pipe.read(new AccountDialogCallback());
	}
    
}
