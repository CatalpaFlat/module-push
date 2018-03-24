package com.github.catalpaflat.push;

import com.github.catalpaflat.push.config.PushConfig;
import com.github.catalpaflat.push.model.PushTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author CatalpaFlat
 */
public class PushRegisterEndpoint {
    private PushConfig pushConfig;
    @Getter
    @Setter
    private String appId;
    @Getter
    @Setter
    private String secret;
    @Getter
    @Setter
    private Boolean isAsynchronous = true;

    public PushRegisterEndpoint(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
        initAppIdWithSecret();
    }

    private void initAppIdWithSecret() {
        PushTO push = this.pushConfig.getPush();
        this.appId = push.getAppId();
        this.secret = push.getSecret();
    }

    public PushRegisterEndpoint setAsynchronous(Boolean type) {
        this.isAsynchronous = type;
        return this;
    }
}
