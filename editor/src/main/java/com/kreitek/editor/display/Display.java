package com.kreitek.editor.display;

import com.kreitek.editor.ConsoleEditor;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import static com.kreitek.editor.ConsoleEditor.TEXT_RESET;
import static com.kreitek.editor.ConsoleEditor.TEXT_YELLOW;

public class Display implements DisplayVisitor{
    @Override
    public ArrayList<String> visit(ConsoleEditor consoleEditor, String[] args) {
        if(args[0].equals("text")){
            if (consoleEditor.getDocumentLines().size() > 0){
                setTextColor(TEXT_YELLOW);
                printLnToConsole("START DOCUMENT ==>");
                for (int index = 0; index < consoleEditor.getDocumentLines().size(); index++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("[");
                    stringBuilder.append(index);
                    stringBuilder.append("] ");
                    stringBuilder.append(consoleEditor.getDocumentLines().get(index));
                    printLnToConsole(stringBuilder.toString());
                }
                printLnToConsole("<== END DOCUMENT");
                setTextColor(TEXT_RESET);
            }
        }else
        {

            JSONObject sampleObject = new JSONObject ();

            if (consoleEditor.getDocumentLines().size() > 0){
                setTextColor(TEXT_YELLOW);
                printLnToConsole("doc[");
                for (int index = 0; index < consoleEditor.getDocumentLines().size(); index++) {

                    sampleObject.put("line", index);
                    sampleObject.put("text; ",consoleEditor.getDocumentLines().get(index));
                    printLnToConsole(sampleObject.toString());

                }
                printLnToConsole("]");
                setTextColor(TEXT_RESET);
            }
        }


        return null;
    }


    private void setTextColor(String color) {
        System.out.println(color);
    }

    private void printLnToConsole(String message) {
        System.out.println(message);
    }
}
