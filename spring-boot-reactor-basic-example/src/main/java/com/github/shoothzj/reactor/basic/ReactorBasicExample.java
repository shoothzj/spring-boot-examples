package com.github.shoothzj.reactor.basic;

import io.netty.channel.ChannelOption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactorBasicExample {

    @Bean
    public NettyReactiveWebServerFactory nettyReactiveWebServerFactory() {
        NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
        factory.addServerCustomizers(server -> {
            server.tcpConfiguration(tcpServer ->
                    tcpServer.option(ChannelOption.SO_BACKLOG, 1));
            return server;
        });
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactorBasicExample.class, args);
    }
}
