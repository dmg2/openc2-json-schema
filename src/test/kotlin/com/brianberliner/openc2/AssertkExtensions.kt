/**
 * Copyright 2019 Brian Berliner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.brianberliner.openc2

import assertk.Assert
import assertk.assertions.support.expected
import org.leadpony.justify.api.Problem

fun Assert<List<Problem>>.isValid() = given { actual ->
    if (actual.isEmpty()) return
    expected("JSON to be valid, but it did not validate successfully\nErrors:\n$actual")
}

fun Assert<List<Problem>>.hasProblems() = given { actual ->
    if (actual.isNotEmpty()) return
    expected("JSON to not be valid, but it validated successfully")
}
