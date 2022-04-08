package com.kreitek.editor.commands;

import com.kreitek.editor.*;
import com.kreitek.editor.memento.Memento;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UndoCommand implements Command  {
public boolean undoSelected;
    public void execute(ArrayList<String> documentLines) {
    undoSelected =true;
    }

}
