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
};

class PlaneMenu {
    public static void showMenu() {
        System.out.println(PlaneMenuOptions.ENGINE_ON.print(1));
        System.out.println(PlaneMenuOptions.POSITION.print(2));
    }
}