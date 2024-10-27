package com.fiap.veiculos.infrastructure.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/token",
            "/swagger-ui-custom.html",
            "/swagger-ui/index.html"
    );

    public Predicate<HttpServletRequest> isSecured = request -> {
        String path = request.getRequestURI();
        if(path.contains("css")|| path.contains("js")
                || path.contains("png")  || path.contains("api") ||
                path.contains("docs") || path.contains("swagger"))
        {
            return false;
        }
        return openApiEndpoints.stream().noneMatch(path::contains);
    };
}
