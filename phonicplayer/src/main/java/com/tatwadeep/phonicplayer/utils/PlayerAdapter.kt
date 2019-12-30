package com.tatwadeep.phonicplayer.utils

import com.tatwadeep.phonicplayer.listener.OnPlaybackInfoListener

/*
 * Created by Elesh Baraiya on 19 December 2019
 * Copyright © 2019 Phonic Audio Player. All rights reserved.
 */
interface PlayerAdapter {
    fun loadMedia(resourceId: PlayerTarget?)
    fun release()
    val isPlaying: Boolean
    fun play()
    fun reset(reload: Boolean)
    fun pause()
    fun initializeProgressCallback()
    fun seekTo(position: Int)
    fun setPlaybackInfoListener(listenerOn: OnPlaybackInfoListener?)
    fun hasTarget(audioTarget: PlayerTarget?): Boolean
}