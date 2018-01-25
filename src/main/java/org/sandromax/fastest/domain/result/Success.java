package org.sandromax.fastest.domain.result;

import org.sandromax.fastest.domain.user.Student;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains all test results by student
 */
public class Success {
    private Student student;
    private List<TestDone> rates;

    public Success() {
        setStudent(new Student());
        setRates(new LinkedList<>());
    }

    public Success(Student student, List<TestDone> rates) {
        this.setStudent(student);
        this.setRates(rates);
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<TestDone> getRates() {
        return rates;
    }

    public void setRates(List<TestDone> rates) {
        this.rates = rates;
    }

    public void addRate(TestDone testDone) {
        rates.add(testDone);
    }
}