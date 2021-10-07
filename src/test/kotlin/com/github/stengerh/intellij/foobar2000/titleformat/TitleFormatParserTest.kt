package com.github.stengerh.intellij.foobar2000.titleformat

import com.intellij.testFramework.ParsingTestCase
import com.intellij.testFramework.TestDataPath

@TestDataPath("\$CONTENT_ROOT/testData/parser")
class TitleFormatParserTest : ParsingTestCase("", "ftf", true, TitleFormatParserDefinition()) {

    fun testColorSettingsPageDemoText() = doTest(true)

    fun testFunctionCall_noArgs() = doTest(true)
    fun testFunctionCall_oneArg() = doTest(true)
    fun testFunctionCall_oneEmptyArg() = doTest(true)
    fun testFunctionCall_twoArgs() = doTest(true)
    fun testFunctionCall_twoEmptyArgs() = doTest(true)

    override fun getTestDataPath(): String = "src/test/testData/parser"

    override fun skipSpaces(): Boolean = false
    override fun includeRanges(): Boolean = true
}