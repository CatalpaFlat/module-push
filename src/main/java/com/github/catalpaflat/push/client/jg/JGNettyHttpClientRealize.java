package com.github.catalpaflat.push.client.jg;

import cn.jiguang.common.connection.NettyHttpClient;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jpush.api.push.model.PushPayload;
import com.github.catalpaflat.push.PushRegisterEndpoint;
import com.github.catalpaflat.push.exception.PushException;
import com.github.catalpaflat.push.payload.jg.JGPushPayloadRealize;
import com.github.catalpaflat.push.support.impl.JGPushSupport;
import io.netty.handler.codec.http.HttpMethod;
import net.sf.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author CatalpaFlat
 */
public class JGNettyHttpClientRealize extends JGPushSupport {

    public JGNettyHttpClientRealize(PushRegisterEndpoint pushRegisterEndpoint) {
        super(pushRegisterEndpoint);
    }

    @Override
    public String pushAll(String alert) {
        NettyHttpClient nettyHttpClient = obtainNettyHttpClient();
        final String[] result = {null};
        try {
            URI uri = obtainUri();
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert(alert);
            nettyHttpClient.sendRequest(HttpMethod.POST, pushPayload.toString(), uri, new NettyHttpClient.BaseCallback() {
                public void onSucceed(ResponseWrapper responseWrapper) {
                    result[0] = responseWrapper.responseContent;
                }
            });
            // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
            nettyHttpClient.close();
        } catch (URISyntaxException e) {
            throw new PushException(e.getMessage());
        }
        return result[0];
    }

    @Override
    public String pushAll(String alert, JSONObject extrasJson) {
        NettyHttpClient nettyHttpClient = obtainNettyHttpClient();
        final String[] result = {null};
        try {
            URI uri = obtainUri();
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Extras(alert, extrasJson);
            nettyHttpClient.sendRequest(HttpMethod.POST, pushPayload.toString(), uri, new NettyHttpClient.BaseCallback() {
                public void onSucceed(ResponseWrapper responseWrapper) {
                    result[0] = responseWrapper.responseContent;
                }
            });
            // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
            nettyHttpClient.close();
        } catch (URISyntaxException e) {
            throw new PushException(e.getMessage());
        }
        return result[0];
    }

    @Override
    public String pushAlias(String alias, String alert) {
        NettyHttpClient nettyHttpClient = obtainNettyHttpClient();
        final String[] result = {null};
        try {
            URI uri = obtainUri();
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Alias(alias, alert);
            nettyHttpClient.sendRequest(HttpMethod.POST, pushPayload.toString(), uri, new NettyHttpClient.BaseCallback() {
                public void onSucceed(ResponseWrapper responseWrapper) {
                    result[0] = responseWrapper.responseContent;
                }
            });
            // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
            nettyHttpClient.close();
        } catch (URISyntaxException e) {
            throw new PushException(e.getMessage());
        }
        return result[0];
    }

    @Override
    public String pushAlias(String alias, String alert, String title) {
        NettyHttpClient nettyHttpClient = obtainNettyHttpClient();
        final String[] result = {null};
        try {
            URI uri = obtainUri();
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Title(alias, alert, title);
            nettyHttpClient.sendRequest(HttpMethod.POST, pushPayload.toString(), uri, new NettyHttpClient.BaseCallback() {
                public void onSucceed(ResponseWrapper responseWrapper) {
                    result[0] = responseWrapper.responseContent;
                }
            });
            // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
            nettyHttpClient.close();
        } catch (URISyntaxException e) {
            throw new PushException(e.getMessage());
        }
        return result[0];
    }

    @Override
    public String pushAlias(String alert, String title, JSONObject extrasJson, String... alias) {
        NettyHttpClient nettyHttpClient = obtainNettyHttpClient();
        final String[] result = {null};
        try {
            URI uri = obtainUri();
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Title_Extras(alert, title, extrasJson, alias);
            nettyHttpClient.sendRequest(HttpMethod.POST, pushPayload.toString(), uri, new NettyHttpClient.BaseCallback() {
                public void onSucceed(ResponseWrapper responseWrapper) {
                    result[0] = responseWrapper.responseContent;
                }
            });
            // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
            nettyHttpClient.close();
        } catch (URISyntaxException e) {
            throw new PushException(e.getMessage());
        }
        return result[0];
    }


    @Override
    public String pushTag(String title, String alert, JSONObject extrasJson, String... tag) {
        NettyHttpClient nettyHttpClient = obtainNettyHttpClient();
        final String[] result = {null};
        try {
            URI uri = obtainUri();
            PushPayload pushPayload = JGPushPayloadRealize.buildPushObject_all_all_alert_Title_Extras_Tag(alert, title, extrasJson, tag);
            nettyHttpClient.sendRequest(HttpMethod.POST, pushPayload.toString(), uri, new NettyHttpClient.BaseCallback() {
                public void onSucceed(ResponseWrapper responseWrapper) {
                    result[0] = responseWrapper.responseContent;
                }
            });
            // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
            nettyHttpClient.close();
        } catch (URISyntaxException e) {
            throw new PushException(e.getMessage());
        }
        return result[0];
    }


}
