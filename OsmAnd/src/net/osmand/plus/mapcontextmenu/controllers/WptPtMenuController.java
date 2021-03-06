package net.osmand.plus.mapcontextmenu.controllers;

import android.graphics.drawable.Drawable;

import net.osmand.data.PointDescription;
import net.osmand.plus.GPXUtilities.WptPt;
import net.osmand.plus.OsmandApplication;
import net.osmand.plus.R;
import net.osmand.plus.activities.MapActivity;
import net.osmand.plus.base.FavoriteImageDrawable;
import net.osmand.plus.mapcontextmenu.MenuController;
import net.osmand.plus.mapcontextmenu.builders.WptPtMenuBuilder;
import net.osmand.util.Algorithms;

public class WptPtMenuController extends MenuController {

	private WptPt wpt;

	public WptPtMenuController(OsmandApplication app, MapActivity mapActivity, PointDescription pointDescription, final WptPt wpt) {
		super(new WptPtMenuBuilder(app, wpt), pointDescription, mapActivity);
		this.wpt = wpt;
	}

	@Override
	protected int getSupportedMenuStatesPortrait() {
		return MenuState.HEADER_ONLY | MenuState.HALF_SCREEN | MenuState.FULL_SCREEN;
	}

/*
	@Override
	public boolean handleSingleTapOnMap() {
		Fragment fragment = getMapActivity().getSupportFragmentManager().findFragmentByTag(FavoritePointEditor.TAG);
		if (fragment != null) {
			((FavoritePointEditorFragment)fragment).dismiss();
			return true;
		}
		return false;
	}
*/

	@Override
	public boolean needStreetName() {
		return false;
	}

	@Override
	public boolean needTypeStr() {
		return true;
	}

	@Override
	public boolean displayDistanceDirection() {
		return true;
	}

	@Override
	public Drawable getLeftIcon() {
		return FavoriteImageDrawable.getOrCreate(getMapActivity().getMyApplication(),
				wpt.getColor(getMapActivity().getResources().getColor(R.color.gpx_color_point)), false);
	}

	@Override
	public Drawable getSecondLineIcon() {
		if (Algorithms.isEmpty(getTypeStr())) {
			return null;
		} else {
			return getIcon(R.drawable.ic_small_group);
		}
	}

	@Override
	public String getTypeStr() {
		return wpt.category != null ? wpt.category : "";
	}
}
