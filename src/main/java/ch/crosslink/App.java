package ch.crosslink;

import com.google.inject.Guice;
import com.google.inject.Injector;
import picocli.CommandLine;

public class App
{
    public static void main(String[] args )
    {
        Injector injector = Guice.createInjector(new Main());
        int exitCode = new CommandLine(new EntryCommand(), new CommandFactory(injector)).execute(args);
        System.exit(exitCode);
    }
}
