package com.kreitek.editor;

public interface Editor {
    void run();

    Memento getState();

    void restore(Memento pop);
}
