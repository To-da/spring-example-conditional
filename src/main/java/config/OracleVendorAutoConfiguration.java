package config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJavaVendor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config initialize {@link config.FooVendorSpecificBean} fooProperty with Oracle JDK String only
 * if current {@link org.springframework.boot.autoconfigure.condition.ConditionalOnJavaVendor.VendorType}
 * is ORACLE
 *
 */
@Configuration
@ConditionalOnJavaVendor(ConditionalOnJavaVendor.VendorType.ORACLE)
public class OracleVendorAutoConfiguration {

    @Bean
    public FooVendorSpecificBean fooVendorSpecificBean() {
        final FooVendorSpecificBean fooVendorSpecificBean = new FooVendorSpecificBean();
        fooVendorSpecificBean.setFooProperty("bean has been initialized with Oracle JDK");
        return fooVendorSpecificBean;
    }
}
