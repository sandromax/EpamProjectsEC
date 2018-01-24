package org.sandromax.fastest.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Describes the expanded information about passing the test by theme
 */
public class TestHistory {
    Student student;
    String theme;
    LocalDate dateLocal;
    Date dateSql;
    List<IssueDone> questions;

    /**
     * @return converted from LocalDate(java.time) to Date(java.sql) field
     */
    public Date getSqlDate() {
        dateSql = Date.valueOf(dateLocal);
        return dateSql;
    }

    /**
     * @return converted from Date(java.sql.Date) to LocalDate(java.time) field
     */
    public LocalDate getLocalDate() {
        dateLocal = dateSql.toLocalDate();
        return dateLocal;
    }
}
