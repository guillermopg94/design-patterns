package com.kreitek.editor;

import com.kreitek.editor.memento.Memento;

public interface Editor {
    void run(String[] args);

    Memento getState();

    void restore(Memento pop);
}
