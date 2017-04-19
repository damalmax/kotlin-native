/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.konan

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.PosixFilePermission
import java.util.*

private val PERMISSIONS = PosixFilePermission.values()
private val PERMISSIONS_LENGTH = PERMISSIONS.size
private val MAX_INT_MODE = (1 shl PERMISSIONS_LENGTH) - 1

fun setFilePermissions(path: Path, mode: Int) {
    Files.setPosixFilePermissions(path, intModeToPosix(mode))
}

fun intModeToPosix(intMode: Int): Set<PosixFilePermission> {
    var mode = intMode
    if (mode and MAX_INT_MODE != mode) {
        throw IllegalArgumentException("The int mode $mode is invalid")
    }

    val perms = EnumSet.noneOf(PosixFilePermission::class.java)

    for(i in 0 .. PERMISSIONS_LENGTH) {
        if (mode and 1 == 1) {
            perms.add(PERMISSIONS[PERMISSIONS_LENGTH - i - 1])
        }
        mode = mode shr 1
    }
    return perms
}
