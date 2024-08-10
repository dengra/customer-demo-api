package de.dengralaura.customerapi.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAuditing implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // SecurityContextHolder.getContext().getAuthentication().getName();
        String userName = "admin";
        return Optional.of(userName);
    }

}