package Model;

import Model.Game.Config;

public class Player {
    private String name;
    private int money = Config.START_MONEY;
    private int position = 0;
    private boolean inJail = false;

    private boolean outOfJailFree = false;
    private int jailTime = 0;

    private boolean bankrupt = false;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int value) {
        this.money += value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean isOutOfJailFree() {
        return outOfJailFree;
    }

    public void setOutOfJailFree(boolean outOfJailFree) {
        this.outOfJailFree = outOfJailFree;
    }

    public int getJailTime() {
        return jailTime;
    }

    public void setJailTime(int jailTime) {
        this.jailTime = jailTime;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }
}
