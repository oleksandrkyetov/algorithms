package algorithms.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HelperTest {

	@Test
	public void swap() {
		final String[] initialArray = new String[] {"9", "8"};
		final String[] expectedArray = new String[] {"8", "9"};

		Helper.swap(initialArray, 0, 1);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(initialArray));
	}

}
