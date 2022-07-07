package com.wisoft.io.testermatchingplatform.domain.submit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmitRepository extends JpaRepository<SubmitEntity,Long> {

    List<SubmitEntity> findByQuest_Id(final Long id);
}
