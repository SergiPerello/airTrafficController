package com.sergames;

enum PlaneMenuOptions {
    ENGINE {
        @Override
        String print(final int i) {
            return "";
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
        PlaneMenuOptions operator = PlaneMenuOptions.ENGINE;
        System.out.println(operator.print(1));
    }
}