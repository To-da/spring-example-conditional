package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public FooVendorSpecificBean fooVendorSpecificBean() {
        final FooVendorSpecificBean fooVendorSpecificBean = new FooVendorSpecificBean();
        fooVendorSpecificBean.setFooProperty("bean has been initialized with some other JDK");
        return fooVendorSpecificBean;
    }

}
