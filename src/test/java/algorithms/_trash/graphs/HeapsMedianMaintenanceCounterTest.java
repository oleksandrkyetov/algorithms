package algorithms._trash.graphs;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import algorithms._trash.graphs.impl.HeapsMedianMaintenanceCounter;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HeapsMedianMaintenanceCounterTest {

	@InjectMocks
	private HeapsMedianMaintenanceCounter heapsMedianMaintenanceCounter;

	@Test
	public void count() {
		assertEquals(9335, heapsMedianMaintenanceCounter.init(new int[] { 6331, 2793, 1640, 9290, 225, 625, 6195, 2303, 5685, 1354 }).count() % 10000);
	}

	@Test
	public void test() throws Exception {
		int[] input = new int[10000];

		final BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader().getResourceAsStream("Median.txt")));

		int i = 0;
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			input[i++] = Integer.parseInt(line);
		}

		System.out.println(heapsMedianMaintenanceCounter.init(input).count() % 10000);
	}

}
