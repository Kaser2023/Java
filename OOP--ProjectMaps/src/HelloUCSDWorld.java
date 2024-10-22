import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;



//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

/**
 * Hello World!
 * 
 * This is the basic stub to start creating interactive maps.
 */
public class HelloUCSDWorld extends PApplet {

	UnfoldingMap map;

	public void setup() {
		size(800, 600, OPENGL);

		map = new UnfoldingMap(this, new Google.GoogleTerrainProvider());
		map.zoomAndPanTo(14, new Location(32.881, -117.238)); // UCSD

		MapUtils.createDefaultEventDispatcher(this, map);
	}

	public void draw() {
		background(0);
		map.draw();
	}

}
