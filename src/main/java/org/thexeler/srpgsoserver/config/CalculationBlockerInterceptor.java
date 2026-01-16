package org.thexeler.srpgsoserver.config;

import org.jspecify.annotations.NonNull;
import org.thexeler.srpgsoserver.task.GameTaskScheduler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CalculationBlockerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        if (GameTaskScheduler.isNextDayCalculating()) {
            response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
            response.getWriter().write("System is calculating next day, please try again later");
            return false;
        }
        return true;
    }
}
