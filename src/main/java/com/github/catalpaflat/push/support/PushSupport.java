package com.github.catalpaflat.push.support;

import net.sf.json.JSONObject;

/**
 * @author CatalpaFlat
 */
public interface PushSupport {
    String pushAll(String alert);

    String pushAll(String alert, JSONObject extrasJson);

    String pushAlias(String alias, String content);

    String pushAlias(String alias, String content, String title);

    String pushAlias(String content, String title, JSONObject extrasJson, String... alias);

    String pushTag(String title, String msg, JSONObject json, String... tag);
}
