package com.github.stengerh.intellij.foobar2000.titleformat

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import com.intellij.testFramework.TestDataPath

@TestDataPath("\$CONTENT_ROOT/resources/lexer")
class TitleFormatLexerTest : LexerTestCase() {
    fun testComment() = doFileTest()

    fun testSingleLineString() = doFileTest()
    fun testMultiLineString() = doFileTest()

    fun testVerbatimText() = doFileTest()

    fun testSpecialCharDollarSign() = doFileTest()
    fun testSpecialCharPercentSign() = doFileTest()
    fun testSpecialCharApostrophe() = doFileTest()

    fun testField() = doFileTest()
    fun testOptional() = doFileTest()
    fun testFunction() = doFileTest()

    fun testColorSettingsPageDemoText() = doFileTest()

    override fun createLexer(): Lexer = TitleFormatLexerAdapter()
    override fun shouldTrim(): Boolean = false

    private fun doFileTest() {
        doFileTest("ftf")
    }

    override fun getDirPath(): String? = null

    override fun getPathToTestDataFile(extension: String?): String {
        val resource = javaClass.getResource("/lexer/" + getTestName(true) + extension)
        return resource.file.toString()
    }
}