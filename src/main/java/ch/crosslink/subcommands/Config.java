package ch.crosslink.subcommands;

import ch.crosslink.model.ProjectConfig;
import com.google.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import picocli.CommandLine;

@CommandLine.Command(name = "config", description = "Configure wp-reflect")
public class Config implements Runnable {
    public EntityManagerFactory efactory;
    @CommandLine.Option(names = {"--upstream-url"}, required = true)
    String upstreamUrl;

    @CommandLine.Option(names= {"--local-url"}, required = true)
    String localUrl;
    @Override
    public void run() {
        System.out.println("Running the config subcommand...");
        EntityManager en = this.efactory.createEntityManager();
        en.getTransaction().begin();
        ProjectConfig config = new ProjectConfig();
        config.setId("some-project-id");
        config.setUpstreamUrl(this.upstreamUrl);
        config.setLocalUrl(this.localUrl);
        en.persist(config);
        en.getTransaction().commit();
        en.close();
    }

    @Inject
    public Config(EntityManagerFactory efactory) {
        this.efactory = efactory;
    }
}