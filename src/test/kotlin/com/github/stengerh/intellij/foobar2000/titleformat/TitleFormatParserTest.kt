package com.github.stengerh.intellij.foobar2000.titleformat

import com.intellij.testFramework.ParsingTestCase
import com.intellij.testFramework.TestDataPath

@TestDataPath("\$CONTENT_ROOT/testData/parser")
class TitleFormatParserTest : ParsingTestCase("", "ftf", true, TitleFormatParserDefinition()) {

    fun testColorSettingsPageDemoText() = doTest(true)

    override fun getTestDataPath(): String = "src/test/testData/parser"

    override fun skipSpaces(): Boolean = false
    override fun includeRanges(): Boolean = true
}