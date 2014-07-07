package net.schoengeist.java.dwx;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.inject.Singleton;

import static org.junit.Assert.assertThat;

/**
 * schoengeist UG (haftungsbeschraenkt)
 * User: onur.guengoeren <guengoeren@schoengeist.net>
 */
public class RocketTest {

    // injections
    @Inject Rocket rocket;
    @Inject Tank tank;

    // test module override
    @Module(
            includes = AppModule.class,
            overrides = true,
            injects = RocketTest.class
    )
    class TestModule {
        @Provides @Singleton
        public Tank providesTestTank() {
              return Mockito.mock(Tank.class);
        }
    }

    // tests
    @Before
    public void setUp() throws Exception {
        ObjectGraph.create(new TestModule()).inject(this);
    }

    @Test
    public void shouldInvokeOpenTank() {
        // when
        rocket.start();

        // then
        Mockito.verify(tank).openTank();
    }

}
