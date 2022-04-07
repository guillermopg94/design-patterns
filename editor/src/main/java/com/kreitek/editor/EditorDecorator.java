package com.kreitek.editor;

import com.kreitek.editor.commands.CommandFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static com.kreitek.editor.ConsoleEditor.*;

public class EditorDecorator implements Editor{
    private final Editor editor;
    private final CommandFactory commandFactory = new CommandFactory();
    private ArrayList<String> documentLines = new ArrayList<String>();
    public EditorDecorator(Editor editor) {
        this.editor = editor;
    }
    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines);
            } catch (BadCommandException e) {
                printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            }
            showDocumentLines(documentLines);
            showHelp();
        }
    }

    private void showDocumentLines(ArrayList<String> textLines) {

        JSONObject sampleObject = new JSONObject ();

        if (textLines.size() > 0){
            setTextColor(TEXT_YELLOW);
            printLnToConsole("doc[");
            for (int index = 0; index < textLines.size(); index++) {

            sampleObject.put("line", index);
            sampleObject.put("text; ",textLines.get(index));
                printLnToConsole(sampleObject.toString());

            }
            printLnToConsole("]");
            setTextColor(TEXT_RESET);
        }
    }


    private String waitForNewCommand() {
        printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }
    @Override
    public Memento getState() {
        return null;
    }

    @Override
    public void restore(Memento pop) {

    }
    private void showHelp() {
        printLnToConsole("To add new line -> a \"your text\"");
        printLnToConsole("To update line  -> u [line number] \"your text\"");
        printLnToConsole("To delete line  -> d [line number]");
    }

    private void printErrorToConsole(String message) {
        setTextColor(TEXT_RED);
        printToConsole(message);
        setTextColor(TEXT_RESET);
    }
    private void setTextColor(String color) {
        System.out.println(color);
    }
    private void printLnToConsole(String message) {
        System.out.println(message);
    }
    private void printToConsole(String message) {
        System.out.print(message);
    }
}
