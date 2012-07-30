package controllers;

import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import play.Logger;
import play.mvc.*;
import play.mvc.Http.Header;

public class Application extends Controller {

    @Before
    public static void in() throws IOException {
        Http.Request r = Http.Request.current();
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t*** In: ***\n");
        sb.append("\t").append(r.querystring).append("\n");
        sb.append("\t").append(params.toString()).append("\n");
        sb.append("\t").append(r.toString()).append("\n");
        sb = debugHeader(r.headers, sb);
        String body = IOUtils.toString(request.body, "UTF-8");
        sb.append("\n").append(body).append("\n");
        sb.append("\t***     ***\n\n");
        Logger.info(sb.toString());
    }

    @Finally
    public static void out() throws IOException {
        Http.Response r = Http.Response.current();
        StringBuilder sb = new StringBuilder();

        sb.append("\n\t*** Out: ***");
        sb = debugHeader(r.headers, sb);
        sb.append("\n").append(new String(r.out.toByteArray(), "UTF-8")).append("\n");
        sb.append("\t***     ***\n\n");
        Logger.info(sb.toString());
    }

    private static StringBuilder debugHeader(Map<String, Header> headers, StringBuilder sb) {
        sb.append("\n\tHEADERS: \n");
        for (String key : headers.keySet()) {
            Header header = headers.get(key);
            sb.append("\t\t").append(header.name).append(": ").append(header.toString()).append("\n");
        }
        sb.append("\n");
        return sb;
    }

    public static void index() {
        render();
    }
}
