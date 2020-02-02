package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Job> expected = List.of(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4)
        );
        Collections.sort(jobs);
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortComparatorByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        List<Job> expected = List.of(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortComparatorByNameThanByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1),
                new Job("Fix bugs", 5)
        );
        List<Job> expected = List.of(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 5),
                new Job("Fix bugs", 4)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        assertThat(jobs, is(expected));
    }

}