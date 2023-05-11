package com.tagservice.infrastructure;

import com.tagservice.domain.Tag;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository("tagRepository")
public interface TagRepository extends ReactiveCrudRepository<Tag, Long> {
    Flux<List<Tag>> findByCreatedBy(String createdBy);
}
