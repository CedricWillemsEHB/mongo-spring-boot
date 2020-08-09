package com.opencodez.model;

import java.util.List;

public interface IEvent {
    boolean setupEvent(String name, List<ICharacters> characters);
    String showEvent();
    List<ICharacters> getCharacters();
}
