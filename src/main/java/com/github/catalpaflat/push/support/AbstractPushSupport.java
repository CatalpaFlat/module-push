package com.github.catalpaflat.push.support;

import com.github.catalpaflat.push.PushRegisterEndpoint;
import lombok.Getter;
import lombok.Setter;

/**
 * @author CatalpaFlat
 */
public abstract class AbstractPushSupport implements PushSupport {
    @Getter
    @Setter
    private PushRegisterEndpoint pushRegisterEndpoint;
    protected Boolean isAsynchronous;
    protected String appId;
    protected String secret;

    public AbstractPushSupport(PushRegisterEndpoint pushRegisterEndpoint) {
        this.pushRegisterEndpoint = pushRegisterEndpoint;

        this.isAsynchronous = pushRegisterEndpoint.getIsAsynchronous();

        this.appId = pushRegisterEndpoint.getAppId();

        this.secret = pushRegisterEndpoint.getSecret();
    }
}
