/**
 * MultiStatus
 * 30.07.2012
 * @author Philipp Haussleiter
 *
 */
package results;

import controllers.RouteEndpoint;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.results.Result;

public class MultiStatus extends Result {

    public MultiStatus() {
        super("Multi-Status");
    }

    public void apply(Request request, Response response) {
        response.status = RouteEndpoint.MULTI_STATUS;
    }
}
