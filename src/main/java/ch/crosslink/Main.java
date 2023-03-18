package ch.crosslink;

import com.google.inject.AbstractModule;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();

        bind(EntityManagerFactory.class).toInstance(Persistence.createEntityManagerFactory("ch.crosslink.sqlitePU"));
    }
}
