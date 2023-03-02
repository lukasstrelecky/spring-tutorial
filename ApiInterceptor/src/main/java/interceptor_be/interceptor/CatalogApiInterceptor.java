package cz.i.catalogApi.interceptor;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@CommonsLog
public class CatalogApiInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
        if (ex != null) {
            ex.printStackTrace();
        }
        log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
        log.info(request.getMethod() + " " + request.getRequestURI());
        request.getParameterMap().forEach((s, strings) -> log.info(s + "=" + Arrays.toString(strings)));

        log.info(IOUtils.toString(request.getReader()));
    }


}
