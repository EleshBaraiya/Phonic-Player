package com.tatwadeep.phonicplayer.listener

/**
 * Allows [MediaPlayerHolder] to report media playback duration and progress updates to
 */
abstract class OnPlaybackInfoListener {
    annotation class State {
        companion object {
            var INVALID = -1
            var PLAYING = 0
            var PAUSED = 1
            var RESET = 2
            var COMPLETED = 3
        }
    }

    open fun onLogUpdated(formattedMessage: String?) {}
    open fun onDurationChanged(duration: Int) {}
    open fun onPositionChanged(position: Int) {}
    open fun onStateChanged(@State state: Int) {}
    open fun onPlaybackCompleted() {}

    companion object {
        fun convertStateToString(@State state: Int): String {
            val stateString: String
            stateString = when (state) {
                State.COMPLETED -> "COMPLETED"
                State.INVALID -> "INVALID"
                State.PAUSED -> "PAUSED"
                State.PLAYING -> "PLAYING"
                State.RESET -> "RESET"
                else -> "N/A"
            }
            return stateString
        }
    }
}