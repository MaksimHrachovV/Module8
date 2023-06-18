package goit;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TimeZoneUtil timeZoneUtil = new TimeZoneUtil();

        ZoneId zoneId = ZoneId.of(timeZoneUtil.parseTimeZone(req));
        Clock clock = Clock.system(zoneId);
        String timeFormat = LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")) + zoneId;
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(timeFormat);
        resp.getWriter().close();
    }
}
