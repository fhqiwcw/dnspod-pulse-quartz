package com.fhqiwcw.dnspod.schedule.quartz;

import java.util.Calendar;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzJob extends QuartzJobBean{
	
	private Logger logger = LoggerFactory.getLogger(QuartzJob.class);

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Quartz run at: {}" + Calendar.getInstance().getTime());
	}
	
	

}
