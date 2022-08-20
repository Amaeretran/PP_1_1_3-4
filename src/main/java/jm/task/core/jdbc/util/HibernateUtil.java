package jm.task.core.jdbc.util;

public class HibernateUtil {
/*
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void shutdown() {
        if(entityManager != null) {
            entityManager.close();
        }
        if(entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public static void build(){
        entityManagerFactory = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                archiverPersistenceUnitInfo(),
                new HashMap<String, Object>() {{
                    put(JPA_JDBC_DRIVER, JPA_JDBC_DRIVER);
                    put(JPA_JDBC_URL, JPA_JDBC_URL);
                    put(DIALECT, PostgreSQL95Dialect.class);
                    put(SHOW_SQL, true);
                    put(QUERY_STARTUP_CHECKING, false);
                    put(GENERATE_STATISTICS, false);
                    put(USE_REFLECTION_OPTIMIZER, false);
                    put(USE_SECOND_LEVEL_CACHE, false);
                    put(USE_QUERY_CACHE, false);
                    put(USE_STRUCTURED_CACHE, false);
                    put(STATEMENT_BATCH_SIZE, 20);
                }}
        );

        entityManager = entityManagerFactory.createEntityManager();
    }

    private static PersistenceUnitInfo archiverPersistenceUnitInfo() {
        return new PersistenceUnitInfo() {
            @Override
            public String getPersistenceUnitName() {
                return "YourPersistenceUnit";
            }

            @Override
            public String getPersistenceProviderClassName() {
                return "org.hibernate.jpa.HibernatePersistenceProvider";
            }

            @Override
            public PersistenceUnitTransactionType getTransactionType() {
                return PersistenceUnitTransactionType.RESOURCE_LOCAL;
            }

            @Override
            public DataSource getJtaDataSource() {
                return null;
            }

            @Override
            public DataSource getNonJtaDataSource() {
                return null;
            }

            @Override
            public List<String> getMappingFileNames() {
                return Collections.emptyList();
            }

            @Override
            public List<URL> getJarFileUrls() {
                try {
                    return Collections.list(this.getClass()
                            .getClassLoader()
                            .getResources(""));
                }catch(IOException e) {
                    throw new UncheckedIOException(e);
                }
            }

            @Override
            public URL getPersistenceUnitRootUrl() {
                return null;
            }

            @Override
            public List<String> getManagedClassNames() {
                return entityClassNames();
            }

            @Override
            public boolean excludeUnlistedClasses() {
                return false;
            }

            @Override
            public SharedCacheMode getSharedCacheMode() {
                return null;
            }

            @Override
            public ValidationMode getValidationMode() {
                return null;
            }

            @Override
            public Properties getProperties() {
                return hibernateProperties();
            }

            @Override
            public String getPersistenceXMLSchemaVersion() {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }

            @Override
            public void addTransformer(ClassTransformer transformer) {

            }

            @Override
            public ClassLoader getNewTempClassLoader() {
                return null;
            }
        };
    }

    private static Properties hibernateProperties(){
        final Properties properties = new Properties();

        properties.put("hibernate.hbm2ddl.auto", "update" );
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver" );
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect" );
        properties.put("hibernate.connection.datasource", dataSource());

        return properties;
    }

    private static DataSource dataSource() {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("dbName");
        dataSource.setUser("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    private static List<String> entityClassNames() {
        Class<?>[] entities = new Class<?>[] {
                YourEntity.class
        };
        return Arrays.stream(entities).map(Class::getName).collect(Collectors.toList());

 */
    }
