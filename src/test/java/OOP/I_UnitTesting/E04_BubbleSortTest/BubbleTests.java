package OOP.I_UnitTesting.E04_BubbleSortTest;

import D_OOP.I_UnitTesting.E04_BubbleSortTest.*;
import org.junit.jupiter.api.*;

/*There is a sorting algorithm - Bubble Sort. You could read this article, to get a better idea: Bubble Sort.
Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list to
be sorted, compares each pair of adjacent items, and swaps them if they are in the wrong order. The pass of the list is
repeated until no swaps are needed, which indicates that the list is sorted. The algorithm, which is a comparison sort,
is named for the way smaller elements "bubble" to the top of the list. Although the algorithm is simple,
it is too slow and impractical for most problems even when compared to insertion sort.
It can be practical if the input is usually in sorted order but may occasionally have some out-of-order elements nearly in position.
You are given a simple class  "Bubble". Create a Test class and test, is it working as intended. Think about the border cases. */

public class BubbleTests {

    private static final int[] ARRAY = new int[]{432, 65, -10, -324, 43, 0, -1, 4, 9, 102};
    private static final int[] SORTED_ARRAY = new int[]{-324, -10, -1, 0, 4, 9, 43, 65, 102, 432};

    @Test
    public void SortingIsCorrect() {
        Bubble.sort(ARRAY);
        Assertions.assertArrayEquals(SORTED_ARRAY, ARRAY);
    }
}
