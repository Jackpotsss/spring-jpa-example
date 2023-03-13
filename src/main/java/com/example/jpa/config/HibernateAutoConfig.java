//package com.example.jpa.config;
//
//import org.hibernate.Hibernate;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.support.ApplicationObjectSupport;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ConditionalOnClass(Hibernate.class)
//@EnableConfigurationProperties(HibernateProperties.class)
////@AutoConfigureAfter(DataSourceAutoConfiguration.class)
//public class HibernateAutoConfig {
//
//    static final String HIBERNATE_SESSION_FACTORY = "hibernate.SessionFactory";
//    @Configuration
//    @ConditionalOnSingleCandidate(DataSource.class)
//    static class SimpleSessionFactoryConfiguration extends ApplicationObjectSupport {
//
//        private static final String SYS_HBM_LOCATION = "classpath*:/config/system/hbm/*.xml";
//
//        private final DataSource dataSource;
//
//        private final HibernateProperties properties;
//
//        SimpleSessionFactoryConfiguration(DataSource dataSource, HibernateProperties properties) {
//            this.dataSource = dataSource;
//            this.properties = properties;
//        }
//
//        @Bean(HIBERNATE_SESSION_FACTORY)
//        @Primary
//        @ConditionalOnMissingBean(name = HIBERNATE_SESSION_FACTORY)
//        public HibernateSessionFactoryBean sessionFactory() throws Exception {
//            HibernateSessionFactoryBean factoryBean = new HibernateSessionFactoryBean();
//            factoryBean.setDataSource(dataSource);
//            Set<Resource> mappingLocations = new HashSet<>();
//            Resource[] resources = getApplicationContext().getResources(SYS_HBM_LOCATION);
//            Collections.addAll(mappingLocations, resources);
//            if (properties.getMappingLocations() != null && properties.getMappingLocations().length > 0) {
//                for (String mappingLocation : properties.getMappingLocations()) {
//                    if (!mappingLocation.equals(SYS_HBM_LOCATION)) {
//                        resources = getApplicationContext().getResources(mappingLocation);
//                        Collections.addAll(mappingLocations, resources);
//                    }
//                }
//            }
//            factoryBean.setMappingLocations(mappingLocations.toArray(new Resource[mappingLocations.size()]));
//            factoryBean.setPackagesToScan(properties.getPackagesToScan());
//            factoryBean.setHibernateProperties(properties.getProperties());
//            return factoryBean;
//        }
//
//    }
//
//    @Configuration
//    @Import({ TenantSessionFactoryConfiguration.class, SimpleSessionFactoryConfiguration.class })
//    static class HibernateTemplateConfiguration {
//
//        @Bean(JdbcStoreConstants.BEAN_PRIMARY_HIBERNATE_TEMPLATE)
//        @Primary
//        @ConditionalOnMissingBean(name = JdbcStoreConstants.BEAN_PRIMARY_HIBERNATE_TEMPLATE)
//        public HibernateTemplate hibernateTemplate(
//                @Qualifier(JdbcStoreConstants.BEAN_PRIMARY_HIBERNATE_SESSION_FACTORY) SessionFactory sessionFactory) {
//            HibernateTemplate template = new HibernateTemplate();
//            template.setSessionFactory(sessionFactory);
//            template.setSessionFactoryName(JdbcStoreConstants.BEAN_PRIMARY_HIBERNATE_SESSION_FACTORY);
//            return template;
//        }
//
//    }
//
//    @Configuration
//    @Import({  SimpleSessionFactoryConfiguration.class })
//    static class HibernateTransactionManagerConfiguration {
//
//        @Bean()
////        @Primary
//        public HibernateTransactionManager hibernateTransactionManager(
//                @Qualifier(HIBERNATE_SESSION_FACTORY) SessionFactory sessionFactory) {
//            return new HibernateTransactionManager(sessionFactory);
//        }
//
//    }
//}
