package com.netreality.live4carnival.annotations;

import java.lang.annotation.Documented;
import java.util.Calendar;

@Documented
public @interface MyClassPreamble {

		String author();
		String todayDate = Calendar.getInstance().getTime().toString();
		int currentRevision() default 1;
		String lastModified() default "NA";
		String lastModifiedBy() default "Net Reality LLC";
		String [] reviewers();
}
