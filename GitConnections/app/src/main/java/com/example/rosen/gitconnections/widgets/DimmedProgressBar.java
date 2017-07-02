package com.example.rosen.gitconnections.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.example.rosen.gitconnections.R;

/**
 * Created by Rosen on 7/2/2017.
 */

public class DimmedProgressBar extends FrameLayout {
    public DimmedProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.dimmed_progress_bar, this);
        setWillNotDraw(false);
    }
}
