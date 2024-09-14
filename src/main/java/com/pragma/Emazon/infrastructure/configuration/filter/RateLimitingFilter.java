package com.pragma.Emazon.infrastructure.configuration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimitingFilter extends OncePerRequestFilter {

    // Definir los lÃmites de tasa por ruta
    private static final Map<String, RateLimitInfo> rateLimits = new ConcurrentHashMap<>();

    private static class RateLimitInfo {
        private final int maxRequests;
        private final Duration timeWindow;
        private final AtomicInteger requestCount = new AtomicInteger(0);
        private long lastRequestTime = System.currentTimeMillis();

        RateLimitInfo(int maxRequests, Duration timeWindow) {
            this.maxRequests = maxRequests;
            this.timeWindow = timeWindow;
        }

        synchronized void incrementRequestCount() {
            long now = System.currentTimeMillis();
            if (now - lastRequestTime > timeWindow.toMillis()) {
                requestCount.set(0); // Reset counter if time window has passed
                lastRequestTime = now;
            }
            requestCount.incrementAndGet();
        }

        boolean isLimitExceeded() {
            return requestCount.get() >= maxRequests;
        }
    }

    static {
        // Rate limits for API endpoints
        rateLimits.put("/api/obtener", new RateLimitInfo(100, Duration.ofMinutes(1)));
        rateLimits.put("/api/crear", new RateLimitInfo(3, Duration.ofMinutes(1)));

        // Rate limits for Swagger endpoints
        rateLimits.put("/swagger-ui/**", new RateLimitInfo(1000, Duration.ofMinutes(1))); // Adjust limits as needed
        rateLimits.put("/swagger-ui.html", new RateLimitInfo(1000, Duration.ofMinutes(1))); // Adjust limits as needed
        rateLimits.put("/v3/api-docs/**", new RateLimitInfo(1000, Duration.ofMinutes(1))); // Adjust limits as needed
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestUri = request.getRequestURI();
        RateLimitInfo rateLimitInfo = getRateLimitInfo(requestUri);

        if (rateLimitInfo == null || !rateLimitInfo.isLimitExceeded()) {
            rateLimitInfo.incrementRequestCount();
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT); // 429 Too Many Requests
            response.getWriter().write("Too many requests - try again later");
        }
    }

    private RateLimitInfo getRateLimitInfo(String uri) {
        return rateLimits.entrySet().stream()
                .filter(entry -> uri.startsWith(entry.getKey())) // Change this line
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
