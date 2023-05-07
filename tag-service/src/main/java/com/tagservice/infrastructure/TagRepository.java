package com.tagservice.infrastructure;

import com.tagservice.domain.Tag;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository("tagRepository")
public interface TagRepository extends ReactiveCrudRepository<Tag, Long> {
}
