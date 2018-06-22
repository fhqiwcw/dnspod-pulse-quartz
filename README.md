# dnspod-pulse-quartz
dnspod-pulse quartz version

## Spring Boot 整合 Quartz

## 创建类继承自QuartzJobBean，实现方法executeInternal
```java
public class QuartzJob extends QuartzJobBean{
    
    private Logger logger = LoggerFactory.getLogger(QuartzJob.class);

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        logger.info("Quartz run at: {}" + Calendar.getInstance().getTime());
    }
}
```

## 创建一个Quartz的配置 声明JobDetail 和 Trigger 标明哪个类被调用QuartzJob.class
```java
@Configuration
public class QuartzConifg {
    
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
```


