package ru.training.bm.api.config.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.db.ColumnMapping;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class JdbcLogger {

    private final DataSource dataSource;

    @Autowired
    public JdbcLogger(@Qualifier("logDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void init() {

        System.out.println("####### JDBCLog init() ########");
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();

        ColumnConfig[] columnConfigs = new ColumnConfig[]{
                ColumnConfig.newBuilder()
                        .setName("LEVEL")
                        .setPattern("%level")
                        .setLiteral(null)
                        .setEventTimestamp(false)
                        .setUnicode(false)
                        .setClob(false).build(),
                ColumnConfig.newBuilder()
                        .setName("LOGGER")
                        .setPattern("%logger")
                        .setLiteral(null)
                        .setEventTimestamp(false)
                        .setUnicode(false)
                        .setClob(false).build(),
                ColumnConfig.newBuilder()
                        .setName("MESSAGE")
                        .setPattern("%m")
                        .setLiteral(null)
                        .setEventTimestamp(false)
                        .setUnicode(false)
                        .setClob(false).build(),
                ColumnConfig.newBuilder()
                        .setName("EVENT_DATE")
                        .setPattern(null)
                        .setLiteral(null)
                        .setEventTimestamp(true)
                        .setUnicode(false)
                        .setClob(false).build(),
                ColumnConfig.newBuilder()
                        .setName("EXCEPTION")
                        .setPattern("%ex")
                        .setLiteral(null)
                        .setEventTimestamp(false)
                        .setUnicode(false)
                        .setClob(false).build()
        };

        Appender jdbcAppender = JdbcAppender.newBuilder()
                .setBufferSize(0)
                .setColumnConfigs(columnConfigs)
                .setColumnMappings(new ColumnMapping[]{})
                .setConnectionSource(new Connect(dataSource))
                .setTableName("LOG.APPLICATION_LOG")
                .withName("databaseAppender")
                .withIgnoreExceptions(true)
                .withFilter(null)
                .build();

        jdbcAppender.start();
        config.addAppender(jdbcAppender);

        // Create an Appender reference.
        // @param ref The name of the Appender.
        // @param level The Level to filter against.
        // @param filter The filter(s) to use.
        // @return The name of the Appender.
        AppenderRef ref = AppenderRef.createAppenderRef("JDBC_Appender", null, null);
        AppenderRef[] refs = new AppenderRef[]{ref};

        /*
         * Factory method to create a LoggerConfig.
         *
         * @param additivity true if additive, false otherwise.
         * @param level The Level to be associated with the Logger.
         * @param loggerName The name of the Logger.
         * @param includeLocation whether location should be passed downstream
         * @param refs An array of Appender names.
         * @param properties Properties to pass to the Logger.
         * @param config The Configuration.
         * @param filter A Filter.
         * @return A new LoggerConfig.
         * @since 2.6
         */
        LoggerConfig loggerConfig = LoggerConfig.createLogger(
                false, Level.DEBUG, "JDBC_Logger", null, refs, null, config, null);
        loggerConfig.addAppender(jdbcAppender, null, null);

        config.addLogger("JDBC_Logger", loggerConfig);
        ctx.updateLoggers();

        System.out.println("####### JDBCLog init() - DONE ########");

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    class Connect implements ConnectionSource {

        private DataSource dsource;

        public Connect(DataSource dsource) {
            this.dsource = dsource;
        }

        @Override
        public State getState() {
            return null;
        }

        @Override
        public void initialize() {

        }

        @Override
        public void start() {

        }

        @Override
        public void stop() {

        }

        @Override
        public boolean isStarted() {
            return false;
        }

        @Override
        public boolean isStopped() {
            return false;
        }

        @Override
        public Connection getConnection() throws SQLException {
            return this.dsource.getConnection();
        }

    }

}
