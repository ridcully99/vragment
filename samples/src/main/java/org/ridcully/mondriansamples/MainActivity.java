package org.ridcully.mondriansamples;

import android.os.Bundle;
import android.widget.FrameLayout;

import org.ridcully.vragments.VragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static org.ridcully.vragments.VragmentManager.bundle;

public class MainActivity extends VragmentActivity {

    @BindView(R.id.segment_container) FrameLayout mSegmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_add)
    public void addSegment() {
        getSegmentManager().push(R.id.segment_container, new GreenVragment(this, bundle("name", "Robert")), "marker");
    }

    @Override
    public void onBackPressed() {
        if (!getSegmentManager().onBackPressed(R.id.segment_container)) {
            super.onBackPressed();
        }
    }
}
