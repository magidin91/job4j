package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobSorterTest {

    @Test
    public void sortCompare() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4)
        );
        Collections.sort(jobs);
        assertThat(jobs, is(expected));
    }
}