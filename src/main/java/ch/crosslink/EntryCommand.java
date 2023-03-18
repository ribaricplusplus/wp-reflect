package ch.crosslink;

import ch.crosslink.subcommands.Config;
import picocli.CommandLine;

@CommandLine.Command(name = "wp-reflect", version = "wp-reflect 1.0.0", mixinStandardHelpOptions = true, subcommands = {Config.class})
public class EntryCommand implements Runnable {
    @Override
    public void run() {}
}
