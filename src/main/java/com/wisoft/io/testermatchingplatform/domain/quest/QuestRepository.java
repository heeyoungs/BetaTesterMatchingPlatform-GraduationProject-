package com.wisoft.io.testermatchingplatform.domain.quest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestRepository extends JpaRepository<QuestEntity, Long> {

    // 카테고리로 퀘스트 조회
    List<QuestEntity> findByCategory_Id(Long id);

    // ntc로 퀘스트 조회
    List<QuestEntity> findByQuestMaker_Id(Long id);

    // 아이디로 퀘스트 하나 조회
    @Override
    Optional<QuestEntity> findById(Long id);

    //퀘스트 save

    // 아이디와 연관된 퀘스트 모두 제거
    void deleteAllByQuestMaker_Id(Long id);
}
