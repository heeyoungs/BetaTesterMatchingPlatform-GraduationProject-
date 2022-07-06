package com.wisoft.io.testermatchingplatform.domain.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static CategoryEntity from(final Category category){
        return new CategoryEntity(
                category.getId(),
                category.getName()
        );
    }

    public CategoryEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category toDomain(){
        return new Category(
                this.id,
                this.name
        );
    }
}
