package com.sergames;

enum PlaneMenuOptions {
    ENGINE_ON {
        @Override
        String print(final int i) {
            return i + "- Turn on engine";
        }
    },
    ENGINE_OFF {
        @Override
        String print(final int i) {
            return i + "- Turn off engine";
        }
    },
    SPEED {
        @Override
        String print(final int i) {
            return i + "- Change speed";
        }
    },
    HEIGHT {
        @Override
        String print(final int i) {
            return i + "- Change height";
        }
    },
    UNDERCARRIAGE_SHOW {
        @Override
        String print(final int i) {
            return i + "- Show undercarriage";
        }
    },
    UNDERCARRIAGE_HIDE {
        @Override
        String print(final int i) {
            return i + "- Hide undercarriage";
        }
    },
    DESTINATION {
        @Override
        String print(final int i) {
            return i + "- Change destination";
        }
    },
    POSITION {
        @Override
        String print(final int i) {
            return i + "- Change position";
        }
    },
    SHOOT {//just military

        @Override
        String print(final int i) {
            return i + "- Shoot";
        }
    },
    OUT {
        @Override
        String print(final int i) {
            return i + "- Exit";
        }
    };

    abstract String print(int num);
}

class PlaneMenu {
    static void showPlaneMenu(boolean engine, boolean undercarriage, int height) {
        int i = 1;
        if (engine) System.out.println(PlaneMenuOptions.ENGINE_OFF.print(i++));
        else System.out.println(PlaneMenuOptions.ENGINE_ON.print(i++));
        System.out.println(PlaneMenuOptions.SPEED.print(i++));
        System.out.println(PlaneMenuOptions.HEIGHT.print(i++));
        if (undercarriage) System.out.println(PlaneMenuOptions.UNDERCARRIAGE_HIDE.print(i++));
        else System.out.println(PlaneMenuOptions.UNDERCARRIAGE_SHOW.print(i++));
        System.out.println(PlaneMenuOptions.DESTINATION.print(i++));
        System.out.println(PlaneMenuOptions.POSITION.print(i++));
        System.out.println(PlaneMenuOptions.OUT.print(i));

    }
}