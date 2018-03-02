package com.altemetric.entity;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Double>{

	@Override
	public int compare(Double o1, Double o2) {
		return o2.compareTo(o1);
	}

}
