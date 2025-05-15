package chat.config;

import chat.core.domain.repositories.UserRepositoryMongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("mongo")
@EnableMongoAuditing
@EnableMongoRepositories(basePackageClasses = UserRepositoryMongo.class)
public class MongoConfig {

    @Bean
    public UserRepositoryMongo userRepository(UserRepositoryMongo userRepositoryMongo) {
        return userRepositoryMongo;
    }
}
