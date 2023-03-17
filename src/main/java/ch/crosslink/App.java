package ch.crosslink;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * Hello world!
 *
 */
@Command(name = "wp-reflect", version = "wp-reflect 1.0.0", mixinStandardHelpOptions = true)
public class App implements Runnable
{
    @CommandLine.Option(names = {"--upstream"}, description = "Upstream server")
    String upstreamUrl;

    @Override
    public void run() {
        System.out.println(this.upstreamUrl);
    }

    public static void main(String[] args )
    {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
