/**
 * RouteEndpoint
 * 30.07.2012
 * @author Philipp Haussleiter
 *
 */
package controllers;

import play.libs.Codec;
import play.mvc.Http.Header;
import results.Created;

public class RouteEndpoint extends Application {

    public final static int MULTI_STATUS = 207;
    
    public static void index() {
        renderText("index");
    }

    public static void show(long id) {
        renderText("show");
    }

    public static void create() {
        ok();
    }

    public static void update(long id) {
    }

    public static void propfind() {
        request.format = "xml";
        String uuid = Codec.UUID();
        render(uuid);
    }

    public static void copy(long id) {
        ok();
    }

    public static void move(long id) {
        ok();
    }

    public static void lock(long id){
        ok();
    }
    
    public static void unlock(long id){
        ok();
    }

    public static void proppatch(long id) {
        ok();
    }

    public static void mkcol() {
        throw new Created();
    }

    public static void options() {
        request.format = "xml";
        response.headers.put("Allow", new Header("Allow", "OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, COPY, MOVE, MKCOL, PROPFIND, PROPPATCH, LOCK, UNLOCK, ORDERPATCH"));
        response.headers.put("Public", new Header("Public", "OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, COPY, MOVE, MKCOL, PROPFIND, PROPPATCH, LOCK, UNLOCK, ORDERPATCH"));
        response.headers.put("DAV", new Header("DAV", "1, 2, ordered-collections"));
        response.headers.put("MS-Author-Via", new Header("MS-Author-Via", "DAV"));
        render();
    }

    public static void trace() {
        renderText(request.toString());
    }
}
