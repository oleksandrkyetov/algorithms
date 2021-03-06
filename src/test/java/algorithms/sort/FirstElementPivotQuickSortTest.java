package algorithms.sort;

import algorithms.pivot.Pivot;
import algorithms.pivot.impl.FirstElementPivot;
import algorithms.sort.impl.QuickSort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FirstElementPivotQuickSortTest.QuickSortTestConfiguration.class)
public class FirstElementPivotQuickSortTest {

	@Autowired
	private QuickSort<String> quickSort;

	@Before
	public void before() { }

	@Test
	public void sort_desc() {
		final String[] initialArray = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final String[] expectedArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		final String[] actualArray = quickSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void sort_random() {
		final String[] initialArray = new String[] {"3", "8", "7", "5", "6", "1", "9", "0", "4", "2"};
		final String[] expectedArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		final String[] actualArray = quickSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void test() {
		final String[] array = new String[] {"lime", "ecru", "sand", "palm", "drab", "gold", "coal", "cyan", "gray", "dust", "pear", "iris", "kobi", "rose", "mist", "aqua", "dusk", "pink", "bone", "corn", "sage", "jade", "bark", "herb"};

		quickSort.sort(array);
	}

	@Configuration
	public static class QuickSortTestConfiguration {

		@Bean
		public Pivot<String> pivot() {
			return new FirstElementPivot<>();
		}

		@Bean
		public QuickSort<String> quickSort() {
			return new QuickSort<>();
		}
	}

}
