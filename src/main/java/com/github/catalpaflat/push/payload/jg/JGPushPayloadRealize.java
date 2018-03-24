package com.github.catalpaflat.push.payload.jg;

import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.google.gson.Gson;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CatalpaFlat
 */
public final class JGPushPayloadRealize {
    private JGPushPayloadRealize() {
    }

    public static PushPayload buildPushObject_all_all_alert(String alert) {
        return PushPayload.alertAll(alert);
    }

    public static PushPayload buildPushObject_all_all_alert_Extras(String alert, JSONObject extrasJson) {
        Map<String, String> extras = new HashMap<String, String>(1);
        if (extrasJson != null) {
            extras.put("info", new Gson().toJson(extrasJson));
        }
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(
                        Notification.newBuilder()
                                .setAlert(alert)
                                .addPlatformNotification(AndroidNotification.newBuilder()
                                        .addExtras(extras).build())
                                .addPlatformNotification(IosNotification.newBuilder()
                                        .incrBadge(1)
                                        .addExtras(extras).build())
                                .build()
                ).build();
    }

    public static PushPayload buildPushObject_all_all_alert_Alias(String alias, String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(
                        Notification.newBuilder()
                                .setAlert(alert)
                                .build()
                ).build();
    }

    public static PushPayload buildPushObject_all_all_alert_Title(String alias, String alert, String title) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(
                        Notification.newBuilder()
                                .setAlert(alert)
                                .addPlatformNotification(AndroidNotification.newBuilder()
                                        .setAlert(alert)
                                        .setTitle(title)
                                        .build())
                                .addPlatformNotification(IosNotification.newBuilder()
                                        .incrBadge(1)
                                        .setAlert(alert)
                                        .build())
                                .build()
                ).build();
    }

    public static PushPayload buildPushObject_all_all_alert_Title_Extras(String alert, String title, JSONObject extrasJson,String... alias) {
        Map<String, String> extras = new HashMap<String, String>(1);
        if (extrasJson != null) {
            extras.put("info", new Gson().toJson(extrasJson));
        }
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(
                        Notification.newBuilder()
                                .setAlert(alert)
                                .addPlatformNotification(AndroidNotification.newBuilder()
                                        .setAlert(alert)
                                        .setTitle(title)
                                        .addExtras(extras)
                                        .build())
                                .addPlatformNotification(IosNotification.newBuilder()
                                        .incrBadge(1)
                                        .setAlert(alert)
                                        .addExtras(extras)
                                        .build())
                                .build()
                ).build();
    }

    public static PushPayload buildPushObject_all_all_alert_Title_Extras_Tag(String alert, String title, JSONObject extrasJson,String... tag) {
        Map<String, String> extras = new HashMap<String, String>(1);
        if (extrasJson != null) {
            extras.put("info", new Gson().toJson(extrasJson));
        }
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setNotification(
                        Notification.newBuilder()
                                .setAlert(alert)
                                .addPlatformNotification(AndroidNotification.newBuilder()
                                        .setAlert(alert)
                                        .setTitle(title)
                                        .addExtras(extras)
                                        .build())
                                .addPlatformNotification(IosNotification.newBuilder()
                                        .incrBadge(1)
                                        .setAlert(alert)
                                        .addExtras(extras)
                                        .build())
                                .build()
                ).build();
    }
}
