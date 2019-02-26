package com.detroitlabs.giflibrary.Controller;

import com.detroitlabs.giflibrary.Data.CategoryRepository;
import com.detroitlabs.giflibrary.Data.GifRepository;
import com.detroitlabs.giflibrary.Model.Category;
import com.detroitlabs.giflibrary.Model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;


    @RequestMapping("/categories")
    public String gifCategories(ModelMap modelMap) {
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);


        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String showCategoryById(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryID(id);
        modelMap.put("gifs", gifs);

        return "category";
    }


  @RequestMapping("/gif/search?q={name}")
  public String showGifsInCategoryByName(String name, ModelMap modelMap){

        int idFromName = categoryRepository.searchCategoryNameToId(name);

      System.out.println(idFromName);

      List<Gif> gif = gifRepository.findByCategoryID(idFromName);
      modelMap.put("gif", gif);


        return "results";
  }

}
