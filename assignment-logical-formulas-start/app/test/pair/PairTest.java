package pair;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void firstInOut() {
		Pair<String,Boolean> p = new Pair<>("foo", true);
		assertEquals("foo", p.first());
		assertEquals(true, p.second());
	}

	@Test
	public void fails()
	{
		Pair<String,Boolean> p = new Pair<>("foo", true);
		// This should be a compile error, not a run time error
		assertEquals(true,  p.first());
		assertEquals("foo", p.second());
	}
}
