package com.tatwadeep.phonicplayer.listener

import android.view.View

/*
 * Created by Elesh Baraiya on 19 December 2019
 * Copyright © 2019 Phonic Audio Player. All rights reserved.
 */
interface OnPlayerViewClickListener {
    /**
     * Fires when a view is clicked in the player view.
     */
    fun onPlayerViewClick(view: View?)
}