package algorithms.select;

import algorithms.pivot.Pivot;
import algorithms.pivot.impl.MedianOfMediansPivot;
import algorithms.pivot.impl.RandomElementPivot;
import algorithms.select.impl.QuickSelect;
import algorithms.sort.Sort;
import algorithms.sort.impl.TopDownMergeSort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DeterministicQuickSelectTest.QuickSelectTestConfiguration.class)
public class DeterministicQuickSelectTest {

	@Autowired
	private QuickSelect<String> quickSelect;

	@Before
	public void before() { }

	@Test
	public void select_desc() {
		final String[] array = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final int order = 2;

		assertEquals("2", quickSelect.select(array, order));
	}

	@Test
	public void select_random() {
		final String[] array = new String[] {"3", "8", "7", "5", "6", "1", "9", "0", "4", "2"};
		final int order = 5;

		assertEquals("5", quickSelect.select(array, order));
	}

	@Configuration
	public static class QuickSelectTestConfiguration {

		@Bean
		public Pivot<String> pivot() {
			return new MedianOfMediansPivot<>();
		}

		@Bean
		public QuickSelect<String> quickSort() {
			return new QuickSelect<>();
		}
	}

}
