package com.appweava.androidstarter.debugdrawer.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.appweava.androidstarter.R;

/**
 * A layout that draws something in the insets passed to {@link #fitSystemWindows(Rect)}, i.e. the
 * area above UI chrome (status and navigation bars, overlay action bars).
 * <p>
 * Unlike the {@code ScrimInsetsFrameLayout} in the design support library, this variant does not
 * consume the insets.
 */
public final class NonConsumingScrimInsetsFrameLayout extends FrameLayout {
    private Drawable insetForeground;
    private Rect insets;
    private Rect tempRect = new Rect();

    public NonConsumingScrimInsetsFrameLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public NonConsumingScrimInsetsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public NonConsumingScrimInsetsFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a =
                context.obtainStyledAttributes(attrs, R.styleable.NonConsumingScrimInsetsView, defStyle, 0);
        if (a == null) {
            return;
        }
        insetForeground = a.getDrawable(R.styleable.NonConsumingScrimInsetsView_insetForeground);
        a.recycle();

        setWillNotDraw(true);
    }

    @Override
    protected boolean fitSystemWindows(@NonNull Rect insets) {
        this.insets = new Rect(insets);
        setWillNotDraw(insetForeground == null);
        ViewCompat.postInvalidateOnAnimation(this);
        return false; // Do not consume insets.
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);

        int width = getWidth();
        int height = getHeight();
        if (insets != null && insetForeground != null) {
            int sc = canvas.save();
            canvas.translate(getScrollX(), getScrollY());

            // Top
            tempRect.set(0, 0, width, insets.top);
            insetForeground.setBounds(tempRect);
            insetForeground.draw(canvas);

            // Bottom
            tempRect.set(0, height - insets.bottom, width, height);
            insetForeground.setBounds(tempRect);
            insetForeground.draw(canvas);

            // Left
            tempRect.set(0, insets.top, insets.left, height - insets.bottom);
            insetForeground.setBounds(tempRect);
            insetForeground.draw(canvas);

            // Right
            tempRect.set(width - insets.right, insets.top, width, height - insets.bottom);
            insetForeground.setBounds(tempRect);
            insetForeground.draw(canvas);

            canvas.restoreToCount(sc);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (insetForeground != null) {
            insetForeground.setCallback(this);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (insetForeground != null) {
            insetForeground.setCallback(null);
        }
    }
}
