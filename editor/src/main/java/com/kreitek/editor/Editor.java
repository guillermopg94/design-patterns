package com.kreitek.editor;

import com.kreitek.editor.memento.Memento;

public interface Editor {
    void run();

    Memento getState();

    void restore(Memento pop);
}
