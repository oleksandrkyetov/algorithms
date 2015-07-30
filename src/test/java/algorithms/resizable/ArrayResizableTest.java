package algorithms.resizable;

import algorithms.resizable.impl.ArrayResizable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ArrayResizableTest {

	@InjectMocks
	private ArrayResizable<Integer> arrayResizable;

	@Before
	public void before() { }

	@Test
	public void add_sizeDoubles() {
		final Integer[] elements = new Integer[] {1, 2};

		arrayResizable.init(elements).add(3).add(4).add(5);

		assertEquals(5, arrayResizable.getSize());
		assertEquals(8, arrayResizable.getCapacity());
		assertTrue(Arrays.equals(new Integer[] {1, 2, 3, 4, 5}, arrayResizable.getElements()));
	}

	@Test
	public void set() {

	}

	@Test
	public void get_sizeHalves() {
		final Integer[] elements = new Integer[] {1, 2};

		arrayResizable.init(elements).add(3).add(4).add(5);
		arrayResizable.get(1);
		arrayResizable.get(1);
		arrayResizable.get(1);
		Integer element = arrayResizable.get(0);

		assertEquals(Integer.valueOf(0), element);
		assertEquals(1, arrayResizable.getSize());
		assertEquals(4, arrayResizable.getCapacity());
		assertTrue(Arrays.equals(new Integer[] {5}, arrayResizable.getElements()));
	}

}
