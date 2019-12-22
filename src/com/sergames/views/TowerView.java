package com.sergames.views;

import static com.sergames.views.Consts.*;
import static com.sergames.askUser.askUser;

public class TowerView {
    public int TowerMenu() {
        return Integer.parseInt(askUser(towerMenuOptions, towerMenu, notValidOption));
    }
}
