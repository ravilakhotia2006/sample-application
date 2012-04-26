package com.spdp.nettech;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MapController;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class ViewLocation extends MapActivity{
	public List<Overlay> mapOverlays;
	
	@Override
	protected boolean isRouteDisplayed(){
		return false;
	}
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewlocation);
		
		MapView mapView = (MapView)findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapOverlays = mapView.getOverlays();
		
		MapController myController = mapView.getController();
		Drawable drawable = this.getResources().getDrawable(R.drawable.red_marker_n);
        Overlays itemizedoverlay = new Overlays(drawable);
        GeoPoint point = new GeoPoint(22311367,88214875);
        OverlayItem overlayitem = new OverlayItem(point, "Nettech Private Limited","3B, Hindustan Road, Kolkata");
        itemizedoverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedoverlay);
        myController.animateTo(point);
        myController.setZoom(17);
	}
	
}
