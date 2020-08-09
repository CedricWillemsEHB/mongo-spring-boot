package com.opencodez.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "players")
public class Player {

    @Id
    private String id;
    private String name;
    private int hp;
    private int attack;
    private boolean isDM;

    public Player(String name, int hp, int attack) {
        super();
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.isDM = false;
    }
    public Player(String name, int hp, int attack, boolean isDM) {
        super();
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.isDM = isDM;
    }
    public boolean isDM() {
        return isDM;
    }
    public void setDM(boolean isDM) {
        this.isDM = isDM;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

}
