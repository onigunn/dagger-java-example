package net.schoengeist.java.dwx;

import javax.inject.Inject;

/**
 * schoengeist UG (haftungsbeschraenkt)
 * User: onur.guengoeren <guengoeren@schoengeist.net>
 */
public class Rocket {

    private Tank tank;

    @Inject
    public Rocket(Tank tank) {
        this.tank = tank;
    }

    public void start() {
        System.out.println("Starting Rocket in:");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(250);
                System.out.println(String.valueOf(i + 1));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Lift off!");
        tank.openTank();
    }
}
