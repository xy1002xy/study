package com.xy.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by wxy on 2017/11/1.
 */

@Component
public class WechatMpConfig {
    @Autowired
    private WechatAccountConfig config;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService=new WxMpServiceImpl();
         wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
         return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpConfigStorage=new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(config.getMpAppId());
        wxMpConfigStorage.setSecret(config.getMpAppSecret());
        return wxMpConfigStorage;
    }


}
