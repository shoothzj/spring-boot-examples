package com.github.shoothzj.reactor.mysql.common.domain;

import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.event.BeforeSaveCallback;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class AuditableEntityCallback implements BeforeSaveCallback<AuditableEntity>, BeforeConvertCallback<AuditableEntity> {

    @Override
    public Publisher<AuditableEntity> onBeforeSave(AuditableEntity entity, OutboundRow row, SqlIdentifier table) {
        System.out.println("before save " + entity.getCreatedTime());
        entity.setCreatedTime(roundToMilliseconds(entity.getCreatedTime()));
        entity.setUpdatedTime(roundToMilliseconds(entity.getUpdatedTime()));
        System.out.println("before save " + entity.getCreatedTime());
        return Mono.just(entity);
    }

    @Override
    public AuditableEntity onBeforeConvert(AuditableEntity entity) {
        System.out.println("before convert " + entity.getCreatedTime());
        entity.setCreatedTime(roundToMilliseconds(entity.getCreatedTime()));
        entity.setUpdatedTime(roundToMilliseconds(entity.getUpdatedTime()));
        System.out.println("before convert " + entity.getCreatedTime());
        return entity;
    }

    private static LocalDateTime roundToMilliseconds(LocalDateTime dateTime) {
        if (dateTime == null) {
            return roundToMilliseconds(LocalDateTime.now());
        }
        LocalDateTime localDateTime = dateTime.truncatedTo(ChronoUnit.MILLIS);
        int dateTimeNano = dateTime.getNano() % 1000_000;
        if (dateTimeNano >= 500_000) {
            localDateTime = localDateTime.plusNanos(1_000_000);
        }
        return localDateTime;
    }
}
