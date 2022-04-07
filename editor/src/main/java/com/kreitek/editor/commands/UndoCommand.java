package com.kreitek.editor.commands;

import com.kreitek.editor.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UndoCommand extends Application implements Command  {

    public void execute(ArrayList<String> documentLines) {

       editor.restore(editorCaretaker.pop());

    }
}
