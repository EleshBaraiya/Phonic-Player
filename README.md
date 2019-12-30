# Phonic-Player

Android Phonic-Player is a high-level library that aims to make working with audio on Android more simple. The reason is simple, when it comes to work with audio there is a lot of work to do before to get the feature you want for example:

- Customize layout
- Handling the permission when granted
- Handling playback control (pause, play, stop) on the MediaPlayer with your UI
- Reporting the media playing progress using a seekbar or something similar
- Ensure to release the MediaPlayer when not needed anymore

When it comes to do the same audio playing in a list like a Recyclerview, this becomes more complicated
- Stop and reset the current playing audio before playing another
- As Recyclerview's items are not directly bounded to the Activity/Fragment lifecycle, releasing the MediaPlayer may become a problem
- Most of the times on list of audio track (like in an Audion Player app or a chat app like whatsapp), wen you play hit the pause button, the play button appear and vice versa. Doing the same thing in a list items is a bit problematic
Etc...
Audio Sensei take care of all of this for you and provide a very simple way to record and play audio even in a Recyclerview

### Add it in your root build.gradle at the end of repositories:
    
    allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
	
### Add the dependency:

    dependencies {
	        implementation 'com.github.EleshBaraiya:Phonic-Player:0.1'
	}
	
[![](https://jitpack.io/v/EleshBaraiya/Phonic-Player.svg)](https://jitpack.io/#EleshBaraiya/Phonic-Player)

![alt text](https://github.com/EleshBaraiya/Phonic-Player/blob/master/phonic_player.png)

# Create a player view
Most of the time an audio player just follow the same pattern. You have 2 buttons, Play and Pause, sometimes the stop button and the view that indicate the progress which mostly a SeekBar. After creating the view most of the next step is to get an instance of MediaPlayer and play/pause/stop depending on which button is clicked. Handling the progress is done by using MediaPlayer.getCurrentPosition()

Now gess what you don't need to do any of that now. With Phonic-Player library, you can just do this:
   
    <com.tatwadeep.phonicplayer.views.PhonicPlayerView
        android:id="@+id/a_main_audio_player1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        app:custom_layout="@layout/view_audio_player_1" />
	
Even when you put this as item for a Recyclerview, nothing changes. Phonic-Player knows if a media is being played and will stop the current media in order to play the new one.

## Provide an Audio target
Phonic-Player library considers any sound to play as a target be it remote sound (on the internet) or local sound file (on the phone). To set a target you just need to call one of the implementation of the method setAudioTarget. You just set a target and you're done!

    setAudioTarget(url : String) // If you want to play remote file in streaming mode. Can also be used for local files
    
    setAudioTarget(url : String, audioName :String ) // If you want to play remote file with download
    
    setAudioTarget(resource : int) // If you want to play resource in your android project or APK
    
    setAudioTarget(uri : Uri) // If you want to play a local file on the user disk storage
    
 ## Player inside recyclerView
 If you are using PhonicPlayerView in recyclerview, you must tell Phonic-Player to track down the lifecycle by adding this code:
     
     PlayerListObserver.instance?.registerLifecycle(lifecycle)
     
     
