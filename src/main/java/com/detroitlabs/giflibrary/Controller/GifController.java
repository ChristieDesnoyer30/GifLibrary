package com.detroitlabs.giflibrary.Controller;

import com.detroitlabs.giflibrary.Data.GifRepository;
import com.detroitlabs.giflibrary.Model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GifController {


    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String displayGifs(ModelMap modelMap) {
        List<Gif> gif = gifRepository.getAllGifs();
        modelMap.put("gif", gif);

        return "home";
    }

    //when on this page from click from the home page, can not get search function to work properly
     @RequestMapping("/gif/{name}")
    public ModelAndView gifDetails(@PathVariable String name) {
        ModelAndView mv = new ModelAndView("gif-details");
        Gif gif = gifRepository.findByName(name);
        mv.addObject("gif", gif);

        return mv;
    }


    @RequestMapping("/gif/search/{name}")
    public String gifSearchDetails(@RequestParam("q") String name, ModelMap modelMap) {

        String returnedValue = searchedGifDetails(name, modelMap);

        return returnedValue;
    }


    @RequestMapping("search")
    public String searchedGifDetails(@RequestParam("q") String name, ModelMap modelMap) {

        Gif gif = gifRepository.findByName(name);

        if (gif != null) {
            modelMap.put("gif", gif);
            return "gif-details";
        }

        return null;

    }

    @RequestMapping("/favorites")
    public String gifFavorites(ModelMap modelMap) {
        List<Gif> gifs = gifRepository.getFavorites();
        modelMap.put("gifs", gifs);

        return "favorites";
    }






}
