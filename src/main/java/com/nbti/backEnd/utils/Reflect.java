package com.nbti.backEnd.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.nbti.backEnd.model.NbtiEntity;

public class Reflect {
	/**
	 * Discontinued as not needed so far. keeping it for the chance to reuse it in
	 * the future
	 * 
	 * @param toBeUpdated
	 * @param updatingInfo
	 */
	@Deprecated
	public static void updateObject(Object toBeUpdated, Object updatingInfo) {
		if (toBeUpdated.getClass().equals(updatingInfo.getClass())) {
			Class<? extends Object> instanceClass = toBeUpdated.getClass();
			List<Method> methods = Arrays.asList(instanceClass.getDeclaredMethods());
			List<Method> getters = methods.stream().filter(m -> m.getName().startsWith("get"))
					.collect(Collectors.toList());
			List<Method> setters = methods.stream().filter(m -> m.getName().startsWith("set"))
					.collect(Collectors.toList());

			getters.stream().filter(get -> {
				try {
					return get.invoke(toBeUpdated) != null;
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			});

		}

	}

	public static void UpdateDates(NbtiEntity nbtie) {
		if (nbtie.getId() == null)
			nbtie.setCreated(LocalDateTime.now());
		nbtie.setLastUpdated(LocalDateTime.now());
		System.out.println(nbtie.getLastUpdated());

	}
	
	public static void UpdateAllDates(List<? extends NbtiEntity> entitites) {
		for (NbtiEntity ent : entitites) {
			UpdateDates(ent);
		}

	}

}
