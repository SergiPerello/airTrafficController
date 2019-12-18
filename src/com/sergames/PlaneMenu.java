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
            return "";
        }
    },
    HEIGHT {
        @Override
        String print(final int i) {
            return "";
        }
    },
    UNDERCARRIAGE {
        @Override
        String print(final int i) {
            return "";
        }
    },
    DESTINATION{
        @Override
        String print(final int i) {
            return "";
        }
    },
    POSITION{
        @Override
        String print(final int i) {
            return "";
        }
    },
    SHOOT{//just military
        @Override
        String print(final int i) {
            return "";
        }
    },
    OUT{
        @Override
        String print(final int i) {
            return "";
        }
    };

    abstract String print(int num);
};


class PlaneMenu {
    public static void shit (){

        System.out.println(PlaneMenuOptions.ENGINE_ON.print(1));
        System.out.println(PlaneMenuOptions.ENGINE_OFF.print(2));
    }
}