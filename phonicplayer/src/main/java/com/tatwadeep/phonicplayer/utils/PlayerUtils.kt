package com.tatwadeep.phonicplayer.utils

import java.util.concurrent.TimeUnit

/*
 * Created by Elesh Baraiya on 19 December 2019
 * Copyright © 2019 Phonic Audio Player. All rights reserved.
 */
object PlayerUtils {
    fun getDurationFormat(durationn: Long): String {
        return String.format(
            "%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(durationn),
            TimeUnit.MILLISECONDS.toSeconds(durationn) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(durationn)
            )
        )
    }
}