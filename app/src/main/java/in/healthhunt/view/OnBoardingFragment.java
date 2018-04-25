package in.healthhunt.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.healthhunt.R;
import in.healthhunt.model.Constants;

/**
 * Created by abhishekkumar on 4/24/18.
 */

public class OnBoardingFragment extends Fragment {

    @BindView(R.id.on_board_text)
    public TextView mOnBoardText;

    @BindView(R.id.get_started)
    public Button mGetStarted;

    private Unbinder mUnBinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_onboarding, container, false);
        mUnBinder = ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        int index = bundle.getInt(Constants.VIEWPAGER_FRAGMENT_NO_KEY);
        if(index == Constants.ON_BOARDING_SCREEN_COUNT - 1) {
                mOnBoardText.setText(getText(R.string.swipe_right_back));
                mGetStarted.setVisibility(View.VISIBLE);
        }
        else {
            mOnBoardText.setText(getText(R.string.explore_new_things));
            mGetStarted.setVisibility(View.INVISIBLE);
        }
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}
