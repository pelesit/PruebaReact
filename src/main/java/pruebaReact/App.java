package pruebaReact;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        ResourceConfig config = new ResourceConfig();
        config.packages("pruebaReact");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));


        Server server = new Server(2222);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");
        */

        Server server = new Server(2222);

        // ---JSON RESOURCE---//
        Resource resource = new Resource();

        ResourceConfig rc = new ResourceConfig();
        rc.register(resource);

        ServletContainer sc = new ServletContainer(rc);

        ServletHolder servletHolder = new ServletHolder(sc);

        ServletContextHandler jsonResourceContext = new ServletContextHandler();
        jsonResourceContext.addServlet(servletHolder, "/*");

        // ---STATIC RESOURCE---//

        ResourceHandler staticResourceHandler = new ResourceHandler();
        staticResourceHandler.setResourceBase("./src/main/java/webapp/src/");
        //staticResourceHandler.setResourceBase(".");


        //staticResourceHandler.setDirectoriesListed(true);
        ContextHandler staticContextHandler = new ContextHandler("/");
        staticContextHandler.setContextPath("/");
        staticContextHandler.setHandler(staticResourceHandler);

        // ---ADD HANDLERS---//

        HandlerList handlers = new HandlerList();

        handlers.setHandlers(new Handler[] { jsonResourceContext, //
                staticContextHandler, //
                new DefaultHandler() //
        });

        server.setHandler(handlers);


        try {
            server.start();
            server.join();
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            server.destroy();
        }





    }
}
