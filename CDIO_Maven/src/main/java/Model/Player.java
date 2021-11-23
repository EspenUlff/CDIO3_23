package Model;

import gui_fields.GUI_Player;

public class Player {
    private String name;
    private int money;
    //private boolean inJail; skal eftertjekkes med kunden

    public Player(String name) {
        this.name = name;
        this.money = 35;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int value){
        this.money += value;
    }
}
