/*
 * Copyright 2014 Toxic Bakery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.noprom.app;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class DepthPageTransformer extends ABaseTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    protected void onTransform(View view, float position) {
        if (position <= 0f) {
            //view.setTranslationX(0f);
            ViewHelper.setTranslationX(view, 0f);
            //view.setScaleX(1f);
            ViewHelper.setScaleX(view, 1f);
            //view.setScaleY(1f);
            ViewHelper.setScaleY(view, 1f);
        } else if (position <= 1f) {
            final float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            //view.setAlpha(1 - position);
            ViewHelper.setAlpha(view, 1 - position);

            //view.setPivotY(0.5f * view.getHeight());
            ViewHelper.setPivotY(view, 0.5f * view.getHeight());
            //view.setTranslationX(view.getWidth() * -position);
            ViewHelper.setTranslationX(view, view.getWidth() * -position);
            //view.setScaleX(scaleFactor);
            ViewHelper.setScaleX(view, scaleFactor);
            //view.setScaleY(scaleFactor);
            ViewHelper.setScaleY(view, scaleFactor);
        }
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }

}
