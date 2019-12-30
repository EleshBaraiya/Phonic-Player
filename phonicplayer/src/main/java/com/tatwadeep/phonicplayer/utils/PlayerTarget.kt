package com.tatwadeep.phonicplayer.utils

import android.net.Uri

/*
 * Created by Elesh Baraiya on 19 December 2019
 * Copyright © 2019 Phonic Audio Player. All rights reserved.
 */
class PlayerTarget(builder: Builder) {
    @Type
    var targetType: Int
    var fileUri: Uri?
    var resource: Int
    var remoteUrl: String?


    internal annotation class Type {
        companion object {
            var RESOURCE = 1
            var LOCAL_FILE_URI = 2
            var REMOTE_FILE_URL = 3
            var INVALID = -1
        }
    }

    class Builder {
        var fileUri: Uri? = null
        var resource = 0
        var remoteUrl: String? = null
        @Type
        var targetType = 0

        fun withLocalFile(uri: Uri?): Builder {
            fileUri = uri
            targetType = Type.LOCAL_FILE_URI
            return this
        }

        fun withRemoteUrl(url: String?): Builder {
            remoteUrl = url
            targetType = Type.REMOTE_FILE_URL
            return this
        }

        fun withResource(res: Int): Builder {
            resource = res
            targetType = Type.RESOURCE
            return this
        }

        fun build(): PlayerTarget {
            return PlayerTarget(this)
        }
    }

    init {
        fileUri = builder.fileUri
        remoteUrl = builder.remoteUrl
        resource = builder.resource
        targetType = builder.targetType
    }
}