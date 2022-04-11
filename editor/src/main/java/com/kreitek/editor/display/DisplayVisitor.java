package com.kreitek.editor.display;

import com.kreitek.editor.ConsoleEditor;

import java.util.ArrayList;

public interface DisplayVisitor {
    public ArrayList<String> visit(ConsoleEditor documentLines, String[] args);
}
