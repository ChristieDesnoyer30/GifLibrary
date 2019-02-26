package com.detroitlabs.giflibrary.Data;

import com.detroitlabs.giflibrary.Model.Category;
import com.detroitlabs.giflibrary.Model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("toobad", LocalDate.of(2019, 2, 23), "Erika Languirand"
                    , true, 1),
            new Gif("exhausting", LocalDate.of(2019, 2, 23), "Jen Bloomer"
                    , false,4),
            new Gif("headtilt", LocalDate.of(2019, 2, 23), "Dan Newport"
                    , true,5),
            new Gif("corgibeg", LocalDate.of(2019, 2, 23), "Matt of Lansing"
                    , false,5),
            new Gif("hugemistake", LocalDate.of(2019, 2, 23), "Erika Languirand"
                    , true, 1),
            new Gif("whatisaid", LocalDate.of(2019, 2, 23), "Dan Newport"
                    , true,3),
            new Gif("dontwanttohearit", LocalDate.of(2019, 2,26)
                    , "Christie Desnoyer", true,3),
            new Gif("cutecat", LocalDate.of(2019,2,25), "Jen Bloomer"
                    , false, 2),
            new Gif("pigpenguin", LocalDate.of(2019,2,26), "Matt of Lansing"
                    , false, 2)
    );

    public static List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public Gif findByName(String name) {


        for (Gif gif : ALL_GIFS) {
            if (gif.getName().contains(name)) {
                return gif;
            }

        }
        return null;
    }

    public List<Gif> getFavorites(){
        List<Gif> favoriteList = new ArrayList<>();

        for(Gif gif : ALL_GIFS){
            if(gif.isFavorite()){
                favoriteList.add(gif);
            }

        }
        return favoriteList;
    }


    public List<Gif> findByCategoryID(int id){

        List<Gif> gifsInCategory = new ArrayList<>();

        for(Gif gif : ALL_GIFS){

            if(gif.getCategoryId() == id){
                gifsInCategory.add(gif);
            }
        }

        return gifsInCategory;
    }



}
