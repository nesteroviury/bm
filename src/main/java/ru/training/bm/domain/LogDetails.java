package ru.training.bm.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(schema = "LOG", name = "APPLICATION_LOG")
public class LogDetails implements Serializable {

    private static final long serialVersionUID = -6830319679370313976L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_SEQ")
    @SequenceGenerator(name = "LOG_SEQ", sequenceName = "LOG_SEQ", allocationSize = 1, schema = "LOG")
    private Long id;

    @Column(name = "LEVEL", length = 15)
    private String level;

    @Column(name = "LOGGER")
    private String logger;

    @Column(name = "MESSAGE", length = 500)
    private String message;

    @CreationTimestamp
    @Column(name = "EVENT_DATE", updatable = false)
    private Timestamp eventDate;

    @Column(name = "EXCEPTION", length = 10000)
    private String exception;

}
