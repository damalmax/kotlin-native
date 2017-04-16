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

package org.jetbrains.kotlin.backend.konan

open class KonanVersion(val major: Int, val minor: Int) {
    companion object {
        val CURRENT = EapKonanVersion(0, 1)
    }
    override fun toString() = "$major.$minor"
}

class EapKonanVersion(val major: Int, val minor: Int) {
    override fun toString() = "EAP $major.$minor"
}