package net.schoengeist.java.dwx;

import dagger.Module;
import dagger.Provides;

/**
 * schoengeist UG (haftungsbeschraenkt)
 * User: onur.guengoeren <guengoeren@schoengeist.net>
 */
@Module( injects = Application.class )
public class AppModule {

    @Provides
    public Tank providesTank() {
        return new FuelTank();
    }
}
