package com.wisoft.io.testermatchingplatform.domain.questmaker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestMakerRepository extends JpaRepository<QuestMakerEntity,Long> {


    @Override
    Optional<QuestMakerEntity> findById(Long id);

    Optional<QuestMakerEntity> findByEmail(String email);
}
