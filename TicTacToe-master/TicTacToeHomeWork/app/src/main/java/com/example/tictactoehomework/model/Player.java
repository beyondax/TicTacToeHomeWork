package com.example.tictactoehomework.model;

import androidx.annotation.DrawableRes;

import com.example.tictactoehomework.R;

public enum Player {

    CROSS(R.drawable.cross),
    CIRCLE(R.drawable.circle);

    private final int drawable;

    Player(int drawable) {
        this.drawable = drawable;
    }

    @DrawableRes
    public int getDrawable() {
        return this.drawable;
    }
}
