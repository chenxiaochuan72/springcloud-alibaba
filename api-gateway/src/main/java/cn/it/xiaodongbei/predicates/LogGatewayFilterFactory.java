//package cn.it.xiaodongbei.predicates;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Author cxc
// * @Date 2023/8/12 3:05 PM
// * @Version 1.0
// * @Description:
// */
//@Component
//public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {
//    public LogGatewayFilterFactory() {
//        super(LogGatewayFilterFactory.Config.class);
//    }
//
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Arrays.asList("consoleLog", "cacheLog");
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return new GatewayFilter() {
//            @Override
//            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//                if (config.isCacheLog()){
//                    System.out.println("cacheLog已经开启了....");
//                }
//                if (config.isConsoleLog()){
//                    System.out.println("consoleLog已经开启了....");
//                }
//                return chain.filter(exchange);
//            }
//        };
//    }
//
//    public static class Config {
//        public Config() {
//        }
//
//        public boolean isConsoleLog() {
//            return consoleLog;
//        }
//
//        public void setConsoleLog(boolean consoleLog) {
//            this.consoleLog = consoleLog;
//        }
//
//        public boolean isCacheLog() {
//            return cacheLog;
//        }
//
//        public void setCacheLog(boolean cacheLog) {
//            this.cacheLog = cacheLog;
//        }
//
//        private boolean consoleLog;
//        private boolean cacheLog;
//    }
//}
