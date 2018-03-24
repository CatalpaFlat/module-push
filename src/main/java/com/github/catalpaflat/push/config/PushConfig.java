package com.github.catalpaflat.push.config;

import com.github.catalpaflat.push.model.PushTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author CatalpaFlat
 */
@ConfigurationProperties(prefix = "catalpaflat")
public class PushConfig {

    @Getter
    @Setter
    private PushTO push;
}
