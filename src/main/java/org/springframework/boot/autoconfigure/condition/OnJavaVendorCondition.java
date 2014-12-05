package org.springframework.boot.autoconfigure.condition;

import java.util.Map;
import java.util.Objects;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJavaVendor.VendorType;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * {@link Condition} that checks for a required vendor of Java.
 * <p>
 * Precedes the {@link org.springframework.boot.autoconfigure.condition.OnJavaCondition}
 *
 * @Author Martin Tosovsky
 */
@Order(Ordered.HIGHEST_PRECEDENCE + 21)
class OnJavaVendorCondition extends SpringBootCondition {

    private static final VendorType JVM_VENDOR = VendorType.getVendorType();

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata
                .getAnnotationAttributes(ConditionalOnJavaVendor.class.getName());
        VendorType vendorType = (VendorType) attributes.get("value");
        return getMatchOutcome(JVM_VENDOR, vendorType);
    }

    protected ConditionOutcome getMatchOutcome(VendorType runningVendorType, VendorType vendorType) {
        boolean match = Objects.equals(runningVendorType, vendorType);
        return new ConditionOutcome(match, getMessage(runningVendorType, vendorType));
    }

    private String getMessage(VendorType runningVendorType, VendorType vendorType) {
        return "Required JVM vendor " + vendorType + " found " + runningVendorType;
    }
}
