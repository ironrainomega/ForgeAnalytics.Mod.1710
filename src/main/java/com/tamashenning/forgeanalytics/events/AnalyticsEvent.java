package com.tamashenning.forgeanalytics.events;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;

public class AnalyticsEvent extends Event {
	
	public final Side side;
	
	public AnalyticsEvent(Side s){
		super();
		side = s;
	}
}
