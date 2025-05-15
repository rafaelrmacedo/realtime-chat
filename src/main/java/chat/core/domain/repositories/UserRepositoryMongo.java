package chat.core.domain.repositories;

import chat.core.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMongo extends MongoRepository<User, String> {
}
