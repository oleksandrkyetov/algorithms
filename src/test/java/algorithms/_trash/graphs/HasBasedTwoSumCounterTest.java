package algorithms._trash.graphs;

import algorithms._trash.graphs.impl.HashBasedTwoSumCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HasBasedTwoSumCounterTest {

	@InjectMocks
	private HashBasedTwoSumCounter hashBasedTwoSumCounter;

	@Test
	public void find() {
		assertEquals(Integer.valueOf(6), hashBasedTwoSumCounter.init(new long[] { 8, -3, -2 , 2, 2, 3, 5 }).count(-5, 4));
	}

	@Test
	public void test() throws Exception {
		long[] input = new long[1000000];

		final BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader().getResourceAsStream("2sum.txt")));

		int i = 0;
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			input[i++] = Long.parseLong(line);
		}

		System.out.println(hashBasedTwoSumCounter.init(input).count(-10000, 10000));
	}

}
