package org.sandromax.fastest.domain.result;

import org.sandromax.fastest.domain.user.Student;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Describes the expanded information about passing the single test by theme
 */
public class TestHistory {
    private Student student;
    private String theme;
    private LocalDate dateLocal;
    private Date dateSql;
    private List<IssueDone> issueDones;

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
