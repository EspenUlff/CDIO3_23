package Model;

import Model.Game.Config;

public class Player {
    public final String name;
    private int money = Config.START_MONEY;

    private int prevPosition = 0;
    private int position = 0;
    public boolean inJail = false;

    public boolean outOfJailFree = false;
    public int jailTime = 0;

    public boolean bankrupt = false;


    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int value) {
        this.money += value;
    }

    public int getPrevPosition() {
        return prevPosition;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.prevPosition = this.position;
        this.position = position;
    }
}
