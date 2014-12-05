package org.springframework.boot.autoconfigure.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

import com.google.common.base.StandardSystemProperty;

/**
 * @Author Martin Tosovsky
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnJavaVendorCondition.class)
public @interface ConditionalOnJavaVendor {

    VendorType value();

    public enum VendorType {
        ORACLE("Oracle", "Oracle Corporation"),
        AZUL("Azul", "Azul Systems, Inc."),
        OPEN_JDK("OpenJDK", "Oracle Corporation"),
        SUN("Sun microsystem", "Sun Microsystems Inc.");

        private VendorType(String name, String identifier) {
            this.name = name;
            this.identifier = identifier;
        }

        private final String name;

        private final String identifier;

        @Override
        public String toString() {
            return "VendorType{" +
                    "name='" + name + '\'' +
                    ", identifier='" + identifier + '\'' +
                    '}';
        }

        /**
         * Returns the {@link VendorType} of the current runtime or null of runtime was not recognized
         */
        public static VendorType getVendorType() {
            StandardSystemProperty standardSystemProperty = StandardSystemProperty.JAVA_VM_VENDOR;
            for (VendorType candidate : VendorType.values()) {
                if (candidate.identifier.equals(standardSystemProperty.value())) {
                    return getOracleVendorType(candidate);
                } else {
                    return candidate;
                }
            }
            return null;
        }

        private static VendorType getOracleVendorType(VendorType candidate) {
            if ((candidate.equals(ORACLE) || candidate.equals(OPEN_JDK)) && StandardSystemProperty.JAVA_VM_NAME.value().contains("OpenJDK")) {
                return OPEN_JDK;
            } else {
                return ORACLE;
            }
        }

    }

}


