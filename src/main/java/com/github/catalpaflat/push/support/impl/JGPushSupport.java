package com.github.catalpaflat.push.support.impl;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NettyHttpClient;
import cn.jpush.api.JPushClient;
import com.github.catalpaflat.push.PushRegisterEndpoint;
import com.github.catalpaflat.push.support.AbstractPushSupport;
import net.sf.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author CatalpaFlat
 */
public abstract class JGPushSupport extends AbstractPushSupport {
    private String host;
    protected ClientConfig clientConfig;
    protected JPushClient jPushClient;

    public JGPushSupport(PushRegisterEndpoint pushRegisterEndpoint) {
        super(pushRegisterEndpoint);
        if (clientConfig == null) {
            this.clientConfig = ClientConfig.getInstance();
        }
        if (host == null) {
            this.host = obtainHost();
        }
    }

    /**
     * 根据是否异步选取不同Client实现
     *
     * @param alert 标示
     * @return 结果
     */
    public abstract String pushAll(String alert);

    /**
     * 根据是否异步选取不同Client实现
     *
     * @param alert      content
     * @param extrasJson 附带信息
     * @return 结果
     */
    public abstract String pushAll(String alert, JSONObject extrasJson);

    /**
     * 推送到指定alias
     *
     * @param alias 标示
     * @param alert 内容
     * @return 结果
     */
    public abstract String pushAlias(String alias, String alert);

    /**
     * 推送到指定alias并附带title
     *
     * @param alias 标示
     * @param alert 内容
     * @param title 标题
     * @return 结果
     */
    public abstract String pushAlias(String alias, String alert, String title);

    /**
     * 推送到指定alias并附带title,附带信息
     *
     * @param alert      内容
     * @param title      标题
     * @param extrasJson 附带信息
     * @param alias      标示
     * @return 结果
     */
    public abstract String pushAlias(String alert, String title, JSONObject extrasJson, String... alias);

    /**
     * 推送到指定组并附带title,附带信息
     *
     * @param tag        组
     * @param alert      内容
     * @param title      标题
     * @param extrasJson 附带信息
     * @return 结果
     */
    public abstract String pushTag(String alert, String title, JSONObject extrasJson, String... tag);


    private String obtainHost() {
        return (String) clientConfig.get(ClientConfig.PUSH_HOST_NAME);
    }

    protected NettyHttpClient obtainNettyHttpClient() {
        return new NettyHttpClient(ServiceHelper.getBasicAuthorization(super.appId,
                super.secret), null, clientConfig);
    }

    protected URI obtainUri() throws URISyntaxException {
        return new URI(host + clientConfig.get(ClientConfig.PUSH_PATH));
    }
}
