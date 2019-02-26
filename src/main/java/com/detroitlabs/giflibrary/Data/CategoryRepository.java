package com.detroitlabs.giflibrary.Data;

import com.detroitlabs.giflibrary.Model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Funny"),
            new Category(2,"Cute"),
            new Category(3, "Angry Real Housewives"),
            new Category(4, "Taylor Swift"),
            new Category (5, "Dogs")
    );

    public List<Category> getAllCategories(){

        return ALL_CATEGORIES;
    }

    public Category findById(int id){

        for (Category category : ALL_CATEGORIES) {
            if(category.getId() == id){
                return category;
            }

        }
        return null;

    }


    public int searchCategoryNameToId(String name){
        int idNumber = 0;

        for(Category catergory : ALL_CATEGORIES){
            if(catergory.getName().equalsIgnoreCase(name)){
                idNumber = catergory.getId();
            }
        }

        return idNumber;
    }





}
