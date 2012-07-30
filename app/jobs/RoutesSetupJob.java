/**
 * RoutesSetupJob
 * 30.07.2012
 * @author Philipp Haussleiter
 *
 */
package jobs;

import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.mvc.Router;
import play.mvc.Router.Route;

@OnApplicationStart
public class RoutesSetupJob extends Job {

    /*
     *
    OPTIONS,
    GET,
    HEAD,
    POST,
    PUT,
    DELETE,
    TRACE,
    COPY,
    MOVE,
    MKCOL,
    PROPFIND,
    PROPPATCH,
    LOCK,
    UNLOCK,
    ORDERPATCH
     */
    @Override
    public void doJob() {
        Logger.info("running Routes Setup");
        Router.addRoute("LOCK", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.lock");
        Router.addRoute("UNLOCK", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.unlock");
        Router.addRoute("PROPPATCH", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.proppatch");
        Router.addRoute("HEAD", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.show");
        Router.addRoute("GET", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.show");
        Router.addRoute("PUT", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.update");
        Router.addRoute("MOVE", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.move");
        Router.addRoute("COPY", "/endpoints/{<[0-9]+>id}", "RouteEndpoint.copy");
        Router.addRoute("MKCOL", "/endpoints/{folder}", "RouteEndpoint.mkcol");
        Router.addRoute("POST", "/endpoints/?", "RouteEndpoint.create");
        Router.addRoute("HEAD", "/endpoints/?", "RouteEndpoint.index");
        Router.addRoute("GET", "/endpoints/?", "RouteEndpoint.index");
        Router.addRoute("PROPFIND", "/endpoints/?", "RouteEndpoint.propfind");
        Router.addRoute("OPTIONS", "/endpoints/?", "RouteEndpoint.options");
        Router.addRoute("TRACE", "/endpoints/?", "RouteEndpoint.trace");
        listRoutes();
        Logger.info("Routes Setup done");
    }

    private void listRoutes() {
        Logger.info("routes: ");
        for (Route route : Router.routes) {
            Logger.info("\t" + route.method + " " + route.path + " " + route.action);
        }
    }
}
