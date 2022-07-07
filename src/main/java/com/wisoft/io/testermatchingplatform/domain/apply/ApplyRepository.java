package com.wisoft.io.testermatchingplatform.domain.apply;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<ApplyEntity,Long> {

    List<ApplyEntity> findByQuest_Id(Long id);
}
