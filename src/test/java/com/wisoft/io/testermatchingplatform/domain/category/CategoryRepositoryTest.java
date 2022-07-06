//package com.wisoft.io.testermatchingplatform.domain.category;
//
//import org.junit.jupiter.api.DisplayNameGeneration;
//import org.junit.jupiter.api.DisplayNameGenerator;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//class CategoryRepositoryTest {
//
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @Test
//    public void category_이름으로_조회(){
//        //given
//        String categoryName = "게임 테스트";
//
//        CategoryEntity categoryEntity = new CategoryEntity(categoryName);
//        categoryRepository.save(categoryEntity);
//
//        //when
//        CategoryEntity category = categoryRepository.findByName(categoryName).get();
//
//        //then
//        assertEquals(categoryName, category.getName());
//    }
//
//
//}