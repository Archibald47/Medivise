package edu.usyd.medivise;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.usyd.medivise.web.MapController;

public class MapControllerTests {

	@Test
	public void test() {
		MapController mc = new MapController();
		assertEquals(mc.home(), "map");
	}

}
