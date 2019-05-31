package config;

import batch.MailItemProcessor;
import org.bibliotheque.wsdl.EmpruntType;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public MailItemProcessor processor(){
        return new MailItemProcessor();
    }

    @Bean
    protected Step step1() {
        return stepBuilderFactory.get("step1")
                .<EmpruntType, EmpruntType> chunk(10)
                .processor(processor())
                .build();
    }


//    @Bean
//    public Job job(JobCompletionNotificationListener listener, Step step1) {
//        return jobBuilderFactory.get("job")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .start(step1())
//                .build();
//    }


}
