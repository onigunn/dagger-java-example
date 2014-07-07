package net.schoengeist.java.dwx;

import dagger.ObjectGraph;

import javax.inject.Inject;

/**
 * schoengeist UG (haftungsbeschraenkt)
 * User: onur.guengoeren <guengoeren@schoengeist.net>
 */
public class Application implements Runnable {
    @Inject Rocket rocket;


    public static void main(String[] args) {
        ObjectGraph og = ObjectGraph.create(new AppModule());
        Application application = og.get(Application.class);
        application.run();
    }

    @Override
    public void run() {
        rocket.start();
    }
}
