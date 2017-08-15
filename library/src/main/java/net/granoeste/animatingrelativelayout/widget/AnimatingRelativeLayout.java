/*
 * Copyright (C) 2017 granoeste (https://github.com/granoeste)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.granoeste.animatingrelativelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import net.granoeste.animatingrelativelayout.R;

/**
 * Android: show/hide a view using an animation - Stack Overflow https://stackoverflow.com/questions/9252740/android-show-hide-a-view-using-an-animation
 */
public class AnimatingRelativeLayout extends RelativeLayout {
    Context context;
    Animation inAnimation;
    Animation outAnimation;

    public AnimatingRelativeLayout(Context context) {
        super(context);
        this.context = context;
        initAnimations(null);
    }

    public AnimatingRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAnimations(attrs);
    }

    public AnimatingRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initAnimations(attrs);
    }

    private void initAnimations(AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.AnimatingRelativeLayout);
            int inAnimationResId = array.getResourceId(R.styleable.AnimatingRelativeLayout_inAnimation, android.R.anim.fade_in);
            int outAnimationResId = array.getResourceId(R.styleable.AnimatingRelativeLayout_outAnimation, android.R.anim.fade_out);
            inAnimation = AnimationUtils.loadAnimation(context, inAnimationResId);
            outAnimation = AnimationUtils.loadAnimation(context, outAnimationResId);
            array.recycle();
        } else {
            inAnimation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            outAnimation = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        }
    }

    public void show() {
        if (isVisible()) return;
        show(true);
    }

    public void show(boolean withAnimation) {
        if (withAnimation) this.startAnimation(inAnimation);
        this.setVisibility(View.VISIBLE);
    }

    public void hide() {
        if (!isVisible()) return;
        hide(true);
    }

    public void hide(boolean withAnimation) {
        if (withAnimation) this.startAnimation(outAnimation);
        this.setVisibility(View.GONE);
    }

    public boolean isVisible() {
        return (this.getVisibility() == View.VISIBLE);
    }

    public void setInAnimation(Animation inAnimation) {
        this.inAnimation = inAnimation;
    }

    public void setOutAnimation(Animation outAnimation) {
        this.outAnimation = outAnimation;
    }
}
