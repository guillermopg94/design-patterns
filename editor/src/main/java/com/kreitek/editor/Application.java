package com.kreitek.editor;


import com.kreitek.editor.commands.UndoCommand;
import com.kreitek.editor.memento.EditorCaretaker;

public class Application {

    public static void main(String[] args) {
         EditorFactory editorFactory = new EditorFactory();
         EditorCaretaker editorCaretaker = new EditorCaretaker();
         Editor editor = editorFactory.getEditor();
         UndoCommand undo = new UndoCommand();

         editor.run(args);
         editorCaretaker.push(editor.getState());

         if (undo.undoSelected){
            editor.restore(editorCaretaker.pop());
        }

}
}