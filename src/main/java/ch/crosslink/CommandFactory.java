package ch.crosslink;

import com.google.inject.Injector;
import picocli.CommandLine;

public class CommandFactory implements CommandLine.IFactory {

    Injector injector;

    public CommandFactory(Injector injector) {
        this.injector = injector;
    }
    @Override
    public <K> K create(Class<K> cls) throws Exception {
        return this.injector.getInstance(cls);
    }
}
