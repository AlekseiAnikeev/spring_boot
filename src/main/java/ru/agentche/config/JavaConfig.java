package ru.agentche.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.agentche.systemProfile.DevProfile;
import ru.agentche.systemProfile.ProductionProfile;
import ru.agentche.systemProfile.SystemProfile;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 07.12.2022
 */
@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(value = "agentche.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "agentche.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}