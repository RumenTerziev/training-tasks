package org.example.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.maxsum.finder.util.TestCasesGenerator.getLargeTestArray;

class ISorterTest {

    private final ISorter selectionSorter = new SelectionSorter();
    private final ISorter quickSorter = new QuickSorter();

    @Test
    void testSelectionSorterSort_whenGivenUnsortedArray_shouldSortIt() {
        //Given
        int[] testArray = {1, 8, 5, 4, 3, 6, 7, 2, 9, 10};
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //When
        selectionSorter.sort(testArray);

        //Then
        assertThat(testArray).isEqualTo(expectedArray);
    }

    @Test
    void testQuickSorterSort_whenGivenUnsortedArray_shouldSortIt() {
        //Given
        int[] testArray = {1, 8, 5, 4, 3, 6, 7, 2, 9, 10};
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //When
        quickSorter.sort(testArray);

        //Then
        assertThat(testArray).isEqualTo(expectedArray);
    }

    @Test
    void logBaseSorterExecutionTime() {
        Runnable runnable = () -> selectionSorter.sort(getLargeTestArray());
        testRunTime(selectionSorter, runnable);
    }

    @Test
    void logQuickSorterExecutionTime() {
        Runnable runnable = () -> quickSorter.sort(getLargeTestArray());
        testRunTime(quickSorter, runnable);
    }

    private void testRunTime(ISorter sorter, Runnable runnable) {
        long currentTimeMillis = System.currentTimeMillis();
        runnable.run();
        System.out.printf("%s took %d millis for execution%n%n", sorter.getClass().getSimpleName(),
                System.currentTimeMillis() - currentTimeMillis);
    }
}
