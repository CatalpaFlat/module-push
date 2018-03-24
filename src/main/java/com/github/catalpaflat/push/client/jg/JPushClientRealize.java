package com.github.catalpaflat.push.client.jg;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import com.github.catalpaflat.push.PushRegisterEndpoint;
import com.github.catalpaflat.push.exception.PushException;
import com.github.catalpaflat.push.payload.jg.JGPushPayloadRealize;
import com.github.catalpaflat.push.support.impl.JGPushSupport;
import com.google.gson.Gson;
import net.sf.json.JSONObject;

/**
 * @author CatalpaFlat
 */
public class JPushClientRealize extends JGPushSupport {

    public JPushClientRealize(PushRegisterEndpoint pushRegisterEndpoint) {
        super(pushRegisterEndpoint);
    }

    @Override
    public String pushAll(String alert) {
        try {
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert(alert);
            PushResult result = obtainJPushClient().sendPush(pushPayload);
            return new Gson().toJson(result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            throw new PushException(e.getMessage());
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            throw new PushException(e.getMessage());
        }
    }

    @Override
    public String pushAll(String alert, JSONObject extrasJson) {
        try {
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Extras(alert, extrasJson);
            PushResult result = obtainJPushClient().sendPush(pushPayload);
            return new Gson().toJson(result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            throw new PushException(e.getMessage());
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            throw new PushException(e.getMessage());
        }
    }

    @Override
    public String pushAlias(String alias, String alert) {
        try {
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Alias(alias, alert);
            PushResult result = obtainJPushClient().sendPush(pushPayload);
            return new Gson().toJson(result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            throw new PushException(e.getMessage());
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            throw new PushException(e.getMessage());
        }
    }

    @Override
    public String pushAlias(String alias, String alert, String title) {
        try {
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Title(alias, alert, title);
            PushResult result = obtainJPushClient().sendPush(pushPayload);
            return new Gson().toJson(result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            throw new PushException(e.getMessage());
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            throw new PushException(e.getMessage());
        }
    }

    @Override
    public String pushAlias(String alert, String title, JSONObject extrasJson, String... alias) {
        try {
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Title_Extras(alert, title, extrasJson, alias);
            PushResult result = obtainJPushClient().sendPush(pushPayload);
            return new Gson().toJson(result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            throw new PushException(e.getMessage());
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            throw new PushException(e.getMessage());
        }
    }

    @Override
    public String pushTag(String title, String alert, JSONObject extrasJson, String... tag) {
        try {
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Title_Extras_Tag(alert, title, extrasJson, tag);
            PushResult result = obtainJPushClient().sendPush(pushPayload);
            return new Gson().toJson(result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            throw new PushException(e.getMessage());
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            throw new PushException(e.getMessage());
        }
    }


    private JPushClient obtainJPushClient() {
        return new JPushClient(super.secret, super.appId, null, clientConfig);

    }
}
