package net.saga.aerogear.ajugbook;

import java.util.List;

import net.saga.aerogear.ajugbook.fragment.AccountDialogFragment;
import net.saga.aerogear.ajugbook.vo.AccountBean;

import org.jboss.aerogear.android.pipeline.AbstractFragmentCallback;

public class AccountDialogCallback extends AbstractFragmentCallback<List<AccountBean>> {

	private static final long serialVersionUID = 1L;

	@Override
	public void onSuccess(List<AccountBean> data) {
		AccountDialogFragment fragment = (AccountDialogFragment) getFragment();
		fragment.setFirstName(data.get(0).getFirstName());
		fragment.setLastName(data.get(0).getLastName());
		fragment.setEmail(data.get(0).getEmailAddress());
		fragment.setImage(data.get(0).getImage().getImageBytes());
	}

	@Override
	public void onFailure(Exception e) {

	}

}
