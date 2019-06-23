package com.services.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestApplication extends Application {
	HashSet<Object> singletons = new HashSet<Object>();

	public RestApplication() {
//		singletons.add(new Library());
	}

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> set = new HashSet<Class<?>>();
		set.add(CursosRestService.class);
		return set;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
