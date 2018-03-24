# JavaEE-推送服务
> 使用场景：  
> 
> 当项目需要进行推送，即推送到客户应用程序，可以使用阿里推送服务，mod到推送服务，极光到推送服务等
> 此module暂时集成了极光推送的相关接口，只需配置，并注入相关关键类即可使用。   
>（建议使用SpringBoot项目，也可以使用spring依赖注入相关Bean）   
>
> version:
> - 1.0.0 : 集成极光推送

## 一，Module详解

推送分为两类：   
- 单用户推送（alias）
- 组推送（tag）


单用户显而易见只对单用户进行推送信息，组推送则对属于某个组范围下用户进行推送。

现暴露接口为：  

```java
public interface PushSupport {
    //全局推送（每个用户都推送）
    String pushAll(String alert);
    //全局推送（每个用户都推送），并附带json相关业务参数
    String pushAll(String alert, JSONObject extrasJson);
    //对特定用户alias进行推送
    String pushAlias(String alias, String alert);
    //对特定用户alias进行推送，并设定标题
    String pushAlias(String alias, String alert, String title);
    //对特定用户alias进行推送，并设定标题，并附带json相关业务参数（可多个用户推送相同内容）
    String pushAlias(String content, String title, JSONObject extrasJson, String... alias);
    //对特定用户组tag进行推送，并设定标题，并附带json相关业务参数（可推送多个组）
    String pushTag(String title, String msg, JSONObject json, String... tag);
}
```

## 二，Module使用

### 1. 配置密钥 secret 和 app_key
```yml
catalpaflat:
    push:
        appId: xxxx
        secret: xxxx
```
### 2. 注入关键Bean
```java
@Configuration
public class PushResourceConfig {
    //获取yml配置属性
    @Bean
    public PushConfig pushConfig() {
        return new PushConfig();
    }
    //断点注入
    @Bean
    public PushRegisterEndpoint pushRegisterEndpoint(PushConfig pushConfig) {
        return new PushRegisterEndpoint(pushConfig);
    }
    //异步请求极光推送
    @Bean
    public JGNettyHttpClientRealize jgNettyHttpClientRealize(PushRegisterEndpoint pushRegisterEndpoint) {
        return new JGNettyHttpClientRealize(pushRegisterEndpoint);
    }
    
    @Bean
    public JPushClientRealize jPushClientRealize(PushRegisterEndpoint pushRegisterEndpoint) {
        return new JPushClientRealize(pushRegisterEndpoint);
    }
}

```
### 3.调用
```java
@Component
public class Test{
    @Resource
    private JGNettyHttpClientRealize jgNettyHttpClientRealize;
    @Resource
    private JPushClientRealize jPushClientRealize;
    
    public void test(){
        String result = jgNettyHttpClientRealize.pushAll(alias);
        String result = jPushClientRealize.pushAll(alias);
    }
}
```

