/*
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

package xenon.clickhouse

import org.scalatest.funsuite.AnyFunSuite
import Utils._

class UtilsSuite extends AnyFunSuite {

  test("stripSingleQuote") {
    assert(stripSingleQuote("'") === "")
    assert(stripSingleQuote("''") === "")
    assert(stripSingleQuote("'abc'") === "abc")
    assert(stripSingleQuote("abc'") === "abc")
    assert(stripSingleQuote("'abc\'") === "abc")
    assert(stripSingleQuote("\'abc") === "abc")
    assert(stripSingleQuote("'abc\\'") === "abc\\'")
    assert(stripSingleQuote("\\'abc") === "\\'abc")
  }

  test("wrapBackQuote") {
    assert(wrapBackQuote("`") === "``")
    assert(wrapBackQuote("``") === "``")
    assert(wrapBackQuote("abc") === "`abc`")
    assert(wrapBackQuote("`abc") === "`abc`")
    assert(wrapBackQuote("abc`") === "`abc`")
  }
}
