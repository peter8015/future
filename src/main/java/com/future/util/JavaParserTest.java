package com.future.util;

import com.github.javaparser.JavaParser;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.printer.YamlPrinter;


public class JavaParserTest {

    public static void main(String[] args) {
        // Parse the code you want to inspect:
        CompilationUnit cu = StaticJavaParser.parse("class X { int x; }");
        // Now comes the inspection code:
        System.out.println(cu);

        YamlPrinter yamlPrinter = new YamlPrinter(true);
        System.out.println(yamlPrinter.output(cu));



    }
}
