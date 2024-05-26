package com.tracker.application.job.repository;
import com.tracker.application.job.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
