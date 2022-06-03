package com.nbti.backEnd.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nbti.backEnd.model.NbtiEntity;
import com.nbti.backEnd.model.Student;

public class Reflect {
	/**
	 * updated an object using the not null fields of an object of the same type.
	 * 
	 * @param toBeUpdated
	 * @param updatingInfo
	 */

	public static void updateObject(NbtiEntity toBeUpdated, NbtiEntity updatingInfo) {
			
		if (toBeUpdated.getClass().equals(updatingInfo.getClass())) {
			Class<? extends Object> instanceClass = toBeUpdated.getClass();
			List<Field> fields = Arrays.asList(instanceClass.getDeclaredFields());

			fields.stream().forEach(f -> {
				String fieldName = StringUtils.capitalize(f.getName());
				try {
					
					Object value = instanceClass.getDeclaredMethod("get" + fieldName).invoke(updatingInfo);
					if (value != null) {
						instanceClass.getDeclaredMethod("set" + fieldName, f.getType()).invoke(toBeUpdated, value);
					} 
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
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
