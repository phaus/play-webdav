/**
 * Created
 * 30.07.2012
 * @author Philipp Haussleiter
 *
 */
package results;

import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.results.Result;

/**
 * HTTP/1.1 201 Created
 */
public class Created extends Result {

    public Created() {
        super("Created");
    }

    public void apply(Request request, Response response) {
        response.status = Http.StatusCode.CREATED;
    }
}
