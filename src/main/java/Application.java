import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import config.CommonConfig;
import config.FooVendorSpecificBean;

@Configuration
@ComponentScan(basePackageClasses = CommonConfig.class)
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        logger.info("Property is: {}", run.getBean(FooVendorSpecificBean.class).getFooProperty());
    }

}
