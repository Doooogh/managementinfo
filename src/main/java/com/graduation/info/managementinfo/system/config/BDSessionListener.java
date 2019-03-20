package com.graduation.info.managementinfo.system.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

public class BDSessionListener implements SessionListener {

	private final AtomicInteger sessionCount = new AtomicInteger(0);
	//以原子的方式+1
	@Override
	public void onStart(Session session) {
		sessionCount.incrementAndGet();
	}

	//以原子的方式-1
	@Override
	public void onStop(Session session) {
		sessionCount.decrementAndGet();
	}

	@Override
	public void onExpiration(Session session) {
		sessionCount.decrementAndGet();

	}

	public int getSessionCount() {
		return sessionCount.get();
	}

}
