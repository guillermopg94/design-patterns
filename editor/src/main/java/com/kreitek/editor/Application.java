package com.kreitek.editor;

public class Application {
   public static EditorFactory editorFactory = new EditorFactory();
    public static EditorCaretaker editorCaretaker = new EditorCaretaker();
    public static Editor editor = editorFactory.getEditor();
    public static Editor editorJSON = new EditorDecorator(new ConsoleEditor());
    public static void main(String[] args) {

        editorCaretaker.push(editor.getState());
if (args[0].equals("json")){
    editorJSON.run();
}else{
    editor.run();
}


    }

}