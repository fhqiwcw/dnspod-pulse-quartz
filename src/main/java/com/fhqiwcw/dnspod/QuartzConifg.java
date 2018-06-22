package com.fhqiwcw.dnspod;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.fhqiwcw.dnspod.schedule.quartz.QuartzJob;

@Configuration
public class QuartzConifg {

	//@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		return new SchedulerFactoryBean();
	}
	
	//@Bean
	public Scheduler scheduler() {
		return schedulerFactoryBean().getScheduler();
	}
	
	@Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(QuartzJob.class).withIdentity("QuartzJob").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("QuartzJob")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
