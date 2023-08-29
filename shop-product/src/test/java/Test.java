import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

/**
 * @Author cxc
 * @Date 2023/8/14 6:36 PM
 * @Version 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProductApplication.class)
public class Test {
    @org.junit.Test
    public void contextLoads() {
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", "124.223.213.54:8848");
            properties.put("namespace", "e7dfbbd8-c8f6-4128-b74b-946ef4e4b4bc");
            ConfigService configService = NacosFactory.createConfigService(properties);
            String contentInfo = configService.getConfig("service-gateway-dev.yaml", "DEFAULT_GROUP", 1000L);
            System.out.println("contentInfo:" + contentInfo);
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }


}
